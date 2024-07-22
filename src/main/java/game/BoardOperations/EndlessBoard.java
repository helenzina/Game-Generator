package game.BoardOperations;

import game.CardOperations.CardFactory;
import game.CardOperations.CardService;
import game.Dice;
import game.GameplayOperations.Player;
import game.RulesOperations.Rule;
import game.TileOperations.TileService;
import game.TileOperations.TilesFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class EndlessBoard implements BoardService {

    private List<TileService> tiles;
    private int boardSize;
    private List<Dice> dice;
    private List<CardService> cards;
    private List<Rule> rules;

    public EndlessBoard() {
        this.tiles = new ArrayList<>();
        this.boardSize = 0;
        this.dice = new ArrayList<>();
        this.cards = new ArrayList<>();
        this.rules = new ArrayList<>();
    }

    public EndlessBoard(List<TileService> tiles, int boardSize, List<Dice> dice, List<CardService> cards, List<Rule> rules) {
        this.tiles = tiles;
        this.boardSize = boardSize;
        this.dice = dice;
        this.cards = cards;
        this.rules = rules;
    }
    @Override
    public void initializeBoard(String fileName) {
        BoardInitializer initialize = new BoardInitializer(this);
        initialize.thisBoard(fileName);
    }

    @Override
    public void passedBoardSize(Player playerPlaying){
        playerPlaying.setPoints(playerPlaying.getPoints() + playerPlaying.getInitialPoints());
        System.out.println("You get " + playerPlaying.getInitialPoints() + " points.");
        playerPlaying.setPosition( playerPlaying.getPosition() % this.boardSize);
    }
    @Override
    public void standOnBoardSize(Player playerPlaying){
    playerPlaying.setPosition(playerPlaying.getPosition() - 1);
    }

    @Override
    public void declareWinner(List<Player> players, int rounds){
        List<Player> sortedPlayers = new ArrayList<>(players);
        Collections.sort(sortedPlayers, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                Integer pointsPlayer1 = p1.getPoints();
                Integer pointsPlayer2 = p2.getPoints();
                return pointsPlayer2.compareTo(pointsPlayer1);
            }
        });
        players=sortedPlayers;
        this.playersCurrentState(players);
        System.out.println(players.get(0).getName() + " is the winner.");
        System.exit(0);
    }

    @Override
    public void removePlayer(Player playerPlaying, List<Player> players){
        if (playerPlaying.getPoints()<=0){
            System.out.println(playerPlaying.getName() + " ran out of points and they're out of the game.");
            players.remove(playerPlaying.getId()-1);
        }
    }
    @Override
    public void playersCurrentState(List<Player> players){
        System.out.println("State of board: ");
        System.out.println("Id | Player's name |  Tile  |  Points  |");
        for(Player player : players){
            System.out.printf("%2d | %-13s | %6d | %8d |%n", player.getId(), player.getName(), player.getPosition(), player.getPoints());
        }
    }

    @Override
    public void setTiles(List<TileService> tiles) {
        this.tiles = tiles;
    }

    @Override
    public List<TileService> getTiles() {
        return this.tiles;
    }

    @Override
    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    @Override
    public int getBoardSize() {
        return this.boardSize;
    }

    @Override
    public void setDice(List<Dice> dice) {
        this.dice = dice;
    }

    @Override
    public List<Dice> getDice() {
        return this.dice;
    }

    @Override
    public void setCards(List<CardService> cards) {
        this.cards = cards;
    }

    @Override
    public List<CardService> getCards() {
        return this.cards;
    }

    @Override
    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    @Override
    public List<Rule> getRules() {
        return this.rules;
    }

}
