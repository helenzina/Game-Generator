package game.BoardOperations;

import game.CardOperations.CardService;
import game.Dice;
import game.GameplayOperations.Player;
import game.RulesOperations.Rule;
import game.TileOperations.TileService;
import org.json.simple.JSONArray;

import java.util.List;

public interface BoardService {
    void initializeBoard(String fileName);
    void passedBoardSize(Player playerPlaying);
    void standOnBoardSize(Player playerPlaying);
    void declareWinner(List<Player> players, int rounds);
    void removePlayer(Player playerPlaying, List<Player> players);
    void playersCurrentState(List<Player> players);
    void setTiles(List<TileService> tiles);
    List<TileService> getTiles();
    void setBoardSize(int boardSize);
    int getBoardSize();
    void setDice(List<Dice> dice);
    List<Dice> getDice();
    void setCards(List<CardService> cards);
    List<CardService> getCards();
    void setRules(List<Rule> rules);
    List<Rule> getRules();
}
