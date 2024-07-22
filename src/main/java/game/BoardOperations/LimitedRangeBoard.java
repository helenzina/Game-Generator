package game.BoardOperations;

import game.CardOperations.CardService;
import game.Dice;
import game.GameplayOperations.Player;
import game.RulesOperations.Rule;
import game.TileOperations.TileService;

import java.util.ArrayList;
import java.util.List;


public class LimitedRangeBoard implements BoardService {

    private List<TileService> tiles;
    private int boardSize;
    private List<Dice> dice;
    private List<CardService> cards;
    private List<Rule> rules;

    public LimitedRangeBoard() {
        this.tiles = new ArrayList<>();
        this.boardSize = 0;
        this.dice = new ArrayList<>();
        this.cards = new ArrayList<>();
        this.rules = new ArrayList<>();
    }

    public LimitedRangeBoard(List<TileService> tiles, int boardSize, List<Dice> dice, List<CardService> cards, List<Rule> rules) {
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
        playerPlaying.setPosition( this.boardSize - (playerPlaying.getPosition() % this.boardSize) );
    }
    @Override
    public void standOnBoardSize(Player playerPlaying){
        System.out.println(playerPlaying.getName() + " is the winner.");
        System.exit(0);
    }
    @Override
    public void declareWinner(List<Player> players, int rounds){

    }
    @Override
    public void removePlayer(Player playerPlaying, List<Player> players){

    }
    @Override
    public void playersCurrentState(List<Player> players){
        System.out.println("State of board: ");
        System.out.println("Id | Player's name |  Tile  |");
        for(Player player : players){
            System.out.printf("%2d | %-13s | %6d |%n", player.getId(), player.getName(), player.getPosition());
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
