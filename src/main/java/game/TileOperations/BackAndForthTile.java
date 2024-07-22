package game.TileOperations;

import game.CardOperations.CardService;
import game.GameplayOperations.Player;

import java.util.List;

public class BackAndForthTile implements TileService{
    private int index;
    private String stat;
    private String parameter;
    private int value;

    public BackAndForthTile(){
        this.index = 0;
        this.stat = "";
        this.parameter = "";
        this.value = 0;
    }

    public BackAndForthTile(int index, String stat, String parameter, int value) {
        this.index = index;
        this.stat = stat;
        this.parameter = parameter;
        this.value = value;
    }

    @Override
    public void executeSpecificTile(Player player, int diceSum, List<CardService> cards, List<Player> players){
        System.out.println("Type of tile: " + this.stat);
        int playerPosition = player.getPosition();
        player.setPosition(playerPosition + this.value);
        System.out.println(player.getName() + " is on tile " + this.index + " which moved them by " + this.value + " to tile " + player.getPosition() + ".");
    }

    public int getIndex(){
        return this.index;
    }

    public String getStat(){
        return this.stat;
    }

    public String getParameter(){
        return this.parameter;
    }

    public int getValue(){
        return this.value;
    }

    public void setIndex(int index){
        this.index = index;
    }

    public void setStat(String stat){
        this.stat = stat;
    }

    public void setParameter(String parameter){
        this.parameter = parameter;
    }

    public void setValue(int value){
        this.value = value;
    }


}
