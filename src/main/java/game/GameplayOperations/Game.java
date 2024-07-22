package game.GameplayOperations;

import game.BoardOperations.*;
import game.Dice;
import game.RulesOperations.Rule;
import game.Validate;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Game {
    private BoardService board;
    private List<Player> players;
    private String fileName;
    private int rounds;

    public Game() {
        this.board = new Board();
        this.players = new ArrayList<>();
    }

    public Game(BoardService board, List<Player> players) {
        this.board = board;
        this.players = players;
    }

    public void setBoard(BoardService board){ this.board = board; }
    public BoardService getBoard(){
        return this.board;
    }

    public void setPlayers(List<Player> players){
        this.players = players;
    }

    public List<Player> getPlayers(){
        return this.players;
    }

    public String getFileName() { return this.fileName; }

    public void setFileName(String fileName) { this.fileName = fileName; }

    public int getRounds() { return this.rounds; }

    public void setRounds(int rounds) { this.rounds = rounds; }

    public void createGame(int userChoice){
        this.initializeGame(userChoice);
    }

    private void initializeGame(int userChoice) {
        Scanner sc = new Scanner(System.in);
        boolean isAnswer = false;
        do {
        switch (userChoice) {
            case 1 ->
                this.fileName = "/simplespecs.json";
            case 2 ->
                this.fileName = "/advancedspecs.json";
            case 3 -> {
                System.out.println("Give a file's name: (either for a new game or a load game)");
                this.fileName = "/" + sc.nextLine() + ".json";
            }
            case 0 -> {
                System.out.println("Exiting.");
                System.exit(0);
                }
            default -> {
                System.out.println("Not a valid input. Try again.");
                isAnswer = true;
                }
            }
        } while(isAnswer);

            try {
                JSONParser jsonParser = new JSONParser();
                String filePath = new File("").getAbsolutePath();
                String specsPath = filePath + this.fileName;
                JSONObject fileJsonObject = (JSONObject) jsonParser.parse(new FileReader(specsPath));

                JSONObject gameObj = (JSONObject) fileJsonObject.get("game");

                final int playersNumber = Integer.parseInt(gameObj.get("players").toString());
                final int initialPlayerPoints = Integer.parseInt(gameObj.get("initial_player_points").toString());
                final int rounds=Integer.parseInt(gameObj.get("rounds").toString());
                setRounds(rounds);

                JSONArray playersStateArray = (JSONArray) fileJsonObject.get("players_state");
                if (playersStateArray == null){
                    this.initializePlayers(playersNumber, initialPlayerPoints);
                } else {
                    this.loadState(playersStateArray);
                }

                this.createBoard(gameObj);
            } catch (Exception e) {
                System.out.println("There was an error during parsing. Please solve it.");
                System.exit(90); //connectivity error
            }
    }

    private void loadState(JSONArray playersStateArray) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i<playersStateArray.size(); i++){
            JSONObject playerState = (JSONObject) playersStateArray.get(i);
            Player player = new Player(
                    Integer.parseInt(playerState.get("id").toString()),
                    playerState.get("name").toString(),
                    Integer.parseInt(playerState.get("position").toString()),
                    Integer.parseInt(playerState.get("initial_player_points").toString()),
                    Integer.parseInt(playerState.get("points").toString())
                    );
            players.add(player);
        }
        this.players = players;
    }

    private void initializePlayers(int playersNumber, int initialPlayerPoints){
        List<Player> players = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i<playersNumber; i++){
            System.out.println("Give the name of player " + (i + 1) + ".");
            final String playerName = sc.nextLine();
            final Player player = new Player( (i + 1), playerName,0, initialPlayerPoints, initialPlayerPoints);
            players.add(player);
        }
        this.players = players;
    }

    private void createBoard(JSONObject gameObj) {
        BoardService gameBoard;
        try {
            gameBoard = BoardFactory.getInstance(gameObj);
            gameBoard.initializeBoard(this.fileName); // fortwsh data
            this.board = gameBoard;
        }catch (Exception e){
            System.out.println("Wrong board type.");
            System.exit(90);
        }
    }

    private void displayRules(){
        List<Rule> rules = this.board.getRules();
        System.out.println("Game rules:");
        for (Rule rule : rules) {
            System.out.println(rule.getMessage());
        }
    }

    private void printMenu(Player playerPlaying){
        System.out.println(playerPlaying.getName() + " is playing now.");
        System.out.println("Choose from the following options:");
        System.out.println("1. Roll the dice(s).");
        System.out.println("2. Display rules.");
        System.out.println("3. Exit.");
    }

    public void play() {
        this.displayRules();
        int rounds = 0;
        do {
            for (int i = 0; i < this.players.size(); i++) {
                Player player = this.players.get(i);
                //gia kathe paikth otan paizei
                this.printMenu(player);

                int userChoice= Validate.input();

                switch (userChoice) {
                    case 1 -> {
                        //roll the dice
                        this.playGame(player);
                    }
                    case 2 -> {
                        //display rules
                        this.displayRules();
                        i--;
                    }
                    case 3 -> {
                        System.out.println("Exiting.");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Not a valid input. Try again.");
                        i--;
                    }
                }
                this.saveState();
            }
            this.board.playersCurrentState(this.players);
            rounds++;
            if (this.rounds == rounds) {
                this.board.declareWinner(this.players, rounds);
            }

        } while (true);
    }

    private void saveState() {
        try {
            JSONParser jsonParser = new JSONParser();
            String filePath = new File("").getAbsolutePath();
            String specsPath = filePath + this.fileName;
            JSONObject fileJsonObject = (JSONObject) jsonParser.parse(new FileReader(specsPath));

            JSONObject originalJsonObject = fileJsonObject;
            JSONObject clonedJsonObject = (JSONObject) originalJsonObject.clone();
            JSONArray playersStateArray = new JSONArray();

            for (Player player : this.players) {
                JSONObject playerState = new JSONObject();
                playerState.put("id", player.getId());
                playerState.put("name", player.getName());
                playerState.put("position", player.getPosition());
                playerState.put("initial_player_points", player.getInitialPoints());
                playerState.put("points", player.getPoints());

                playersStateArray.add(playerState);
            }

            clonedJsonObject.put("players_state", playersStateArray);

            String newFileName = this.fileName.substring(0, this.fileName.lastIndexOf('.')) + "_save" + this.fileName.substring(this.fileName.lastIndexOf('.'));
            String destinationFilePath = filePath + newFileName;

            FileWriter fileWriter = new FileWriter(destinationFilePath);
            fileWriter.write(clonedJsonObject.toJSONString());
            fileWriter.flush();
            fileWriter.close();

        } catch (Exception e) {
            System.out.println("An error occurred while cloning and saving the JSON file.");
            e.printStackTrace();
        }
    }

    private void playBoard(Player playerPlaying) {
        if (playerPlaying.getPosition() > this.board.getBoardSize()){
            System.out.println(playerPlaying.getName() + ", you have passed the end of the board.");
            this.board.passedBoardSize(playerPlaying);
        } else if (playerPlaying.getPosition() == this.board.getBoardSize()){
            System.out.println(playerPlaying.getName() + ", you have reached the end of the board.");
            this.board.standOnBoardSize(playerPlaying);
        }
    }
    private void playGame(Player playerPlaying){

        this.playBoard(playerPlaying);

        List<Dice> allDice = this.board.getDice();
        int diceSum = 0;
        for (Dice dice: allDice){
            dice.roll();
            diceSum += dice.getDice();
        }
        System.out.println("Value of dice: " + diceSum);

        int tempPlayerPosition = playerPlaying.getPosition() + diceSum;
        playerPlaying.setPosition(tempPlayerPosition);

        this.playBoard(playerPlaying);

        this.board.getTiles().get(playerPlaying.getPosition()).executeSpecificTile(playerPlaying, diceSum, this.board.getCards(), this.players);

        this.board.removePlayer(playerPlaying, this.players);

    }
}
