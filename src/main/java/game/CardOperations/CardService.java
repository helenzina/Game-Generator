package game.CardOperations;

import game.GameplayOperations.Player;

import java.util.List;

public interface CardService {
    void executeSpecificCard(Player player, List<Player> players);
}
