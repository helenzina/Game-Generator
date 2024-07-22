package game.BoardOperations;

import game.CardOperations.CardFactory;
import game.CardOperations.CardService;
import game.Dice;
import game.RulesOperations.Rule;
import game.TileOperations.TileService;
import game.TileOperations.TilesFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class BoardInitializer {

    private final BoardService board;

    public BoardInitializer(BoardService board) {
        this.board = board;
    }

    public void thisBoard(String fileName) {
        try {
            JSONParser jsonParser = new JSONParser();
            String filePath = new File("").getAbsolutePath();
            String specsPath = filePath + fileName;
            JSONObject fileJsonObject = (JSONObject) jsonParser.parse(new FileReader(specsPath));

            JSONObject gameObj = (JSONObject) fileJsonObject.get("game");

            final int boardSize = Integer.parseInt(gameObj.get("board_size").toString());
            this.board.setBoardSize(boardSize);

            final int diceNumber = Integer.parseInt(gameObj.get("dice_number").toString());
            final List<Dice> dice = this.initializeDice(diceNumber);
            this.board.setDice(dice);

            JSONArray tilesArray = (JSONArray) fileJsonObject.get("tiles");
            final List<TileService> tiles = this.initializeTiles(tilesArray);
            this.board.setTiles(tiles);

            JSONArray cardsArray = (JSONArray) fileJsonObject.get("cards");
            final List<CardService> cards = this.initializeCards(cardsArray);
            this.board.setCards(cards);

            JSONArray rulesArray = (JSONArray) fileJsonObject.get("rules");
            final List<Rule> rules = this.initializeRules(rulesArray);
            this.board.setRules(rules);

        } catch (Exception e) {
            System.out.println("There was an error during parsing. Please solve it.");
            System.exit(90);
        }
    }

    private List<Dice> initializeDice(int diceNumber) {
        List<Dice> allDice = new ArrayList<>();
        try {
            for (int i = 0; i < diceNumber; i++) {
                final Dice newDice = new Dice();
                allDice.add(newDice);
            }
        } catch (Exception e) {
            System.out.println("There was an error during parsing dice. Please solve it.");
            System.exit(90);
        }
        return allDice;
    }

    private List<TileService> initializeTiles(JSONArray allTiles) {
        List<TileService> tilesList = new ArrayList<>();
        try {
            for (int i = 0; i < allTiles.toArray().length; i++) {
                JSONObject tileObj = (JSONObject) allTiles.get(i);
                final TileService newTile = TilesFactory.getInstance(tileObj);
                tilesList.add(newTile);
            }
        } catch (Exception e){
            System.out.println("There was an error during parsing tiles. Please solve it.");
            System.exit(90);
        }
        return tilesList;
    }

    private List<CardService> initializeCards(JSONArray allCards) {
        List<CardService> cardsList = new ArrayList<>();
        try {
            for (int i = 0; i < allCards.toArray().length; i++) {
                JSONObject cardObj = (JSONObject) allCards.get(i);
                final CardService newCard = CardFactory.getInstance(cardObj);
                cardsList.add(newCard);
            }
        } catch (Exception e) {
            System.out.println("There was an error during parsing cards. Please solve it.");
            System.exit(90);
        }
        return cardsList;
    }

    private List<Rule> initializeRules(JSONArray allRules) {
        List<Rule> rulesList = new ArrayList<>();
        try {
            for (int i = 0; i < allRules.toArray().length; i++) {
                JSONObject ruleObj = (JSONObject) allRules.get(i);
                final Rule newRule = new Rule(String.valueOf(ruleObj.get("rule")));
                rulesList.add(newRule);
            }
        } catch (Exception e) {
            System.out.println("There was an error during parsing rules. Please solve it.");
            System.exit(90);
        }
        return rulesList;
    }

}
