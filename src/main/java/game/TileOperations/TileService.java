package game.TileOperations;

import game.CardOperations.CardService;
import game.GameplayOperations.Player;

import java.util.List;

public interface TileService {
    void executeSpecificTile(Player player, int diceSum, List<CardService> cards, List<Player> players);
}
