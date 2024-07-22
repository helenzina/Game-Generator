package game.TileOperations;


import game.CardOperations.CardService;
import game.GameplayOperations.Player;

import java.util.List;

public class SimpleTile implements TileService {
    private int index;
    private int value;

    public SimpleTile(){
        this.index = 0;
        this.value = 0;
    }

    public SimpleTile(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public void executeSpecificTile(Player player, int diceSum, List<CardService> cards, List<Player> players) {
        player.setPosition(player.getPosition() + this.value);
        System.out.println(player.getName() + " is on tile " + this.index + " which moved them by " + this.value + " to tile " + player.getPosition() + ".");
    }

    public int getIndex(){
        return this.index;
    }
    public int getValue(){
        return this.value;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public void setValue(int value){
        this.value = value;
    }

}
