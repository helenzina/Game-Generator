package game.BoardOperations;


import game.CardOperations.CardService;
import game.Dice;
import game.GameplayOperations.Player;
import game.RulesOperations.Rule;
import game.TileOperations.TileService;
import org.json.simple.JSONArray;

import java.util.List;

public class Board implements BoardService {
    public Board(){
    }

    @Override
    public void setTiles(List<TileService> newTiles) {

    }

    @Override
    public List<TileService> getTiles() {
        return null;
    }

    @Override
    public void setBoardSize(int newBoardSize) {

    }

    @Override
    public int getBoardSize() {
        return 0;
    }

    @Override
    public void setDice(List<Dice> newDice) {

    }

    @Override
    public List<Dice> getDice() {
        return null;
    }

    @Override
    public void setCards(List<CardService> newCards) {

    }

    @Override
    public List<CardService> getCards() {
        return null;
    }

    @Override
    public void setRules(List<Rule> newRules) {

    }

    @Override
    public List<Rule> getRules() {
        return null;
    }

    @Override
    public void initializeBoard(String fileName) {

    }
    @Override
    public void passedBoardSize(Player playerPlaying){

    }
    @Override
    public void standOnBoardSize(Player playerPlaying){

    }
    @Override
    public void removePlayer(Player playerPlaying, List<Player> players){

    }
    @Override
    public void declareWinner(List<Player> players, int rounds){

    }
    @Override
    public void playersCurrentState(List<Player> players){

    }

}
