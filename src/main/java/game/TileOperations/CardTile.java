package game.TileOperations;


import game.CardOperations.CardService;
import game.GameplayOperations.Player;

import java.util.List;
import java.util.Random;

public class CardTile implements TileService{
    private int index;
    private String stat;
    private String parameter;
    private int value;

    public CardTile(){
        this.index = 0;
        this.stat = "";
        this.parameter = "";
        this.value = 0;
    }

    public CardTile(int index, String stat, String parameter, int value) {
        this.index = index;
        this.stat = stat;
        this.parameter = parameter;
        this.value = value;
    }

    @Override
    public void executeSpecificTile(Player player, int diceSum, List<CardService> cards, List<Player> players){
        System.out.println("Type of tile: " + this.stat);
        int randomCard = new Random().nextInt(cards.size());
        CardService cardToExecute = cards.get(randomCard);
        System.out.println(player.getName() + " is on tile " + this.index + " and picked a random card.");
        cardToExecute.executeSpecificCard(player, players);
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

    public int getValue(){ return this.value; }

    public void setIndex(int index){
        this.index = index;
    }

    public void setStat(String stat){
        this.stat = stat;
    }

    public void setParameter(String parameter){
        this.parameter = parameter;
    }

    public void setValue(int value){ this.value = value; }


}
