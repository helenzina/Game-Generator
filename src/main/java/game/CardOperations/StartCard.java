package game.CardOperations;

import game.GameplayOperations.Player;

import java.util.List;

public class StartCard implements CardService{
    private int id;
    private String message;
    private String parameter;
    private int value;
    public StartCard(int id, String message, String parameter, int value) {
        this.id = id;
        this.message = message;
        this.parameter = parameter;
        this.value = value;
    }
    @Override
    public void executeSpecificCard(Player player, List<Player> players){
        System.out.println("Action of card: " + this.message);
        int playerPoints = player.getPoints();
        playerPoints += this.value;
        player.setPoints(playerPoints);
        player.setPosition(0);
        System.out.println(player.getName() + " moved to the beginning tile and got " + this.value + " so now they have " + player.getPoints() + " points.");
    }
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
    public String getMessage() { return this.message; }
    public void setMessage(String message) { this.message = message; }
    public String getParameter() { return this.parameter; }
    public void setParameter(String parameter) { this.parameter = parameter; }
    public int getValue() { return this.value; }
    public void setValue(int value) { this.value = value; }


}
