package game.CardOperations;

import game.GameplayOperations.Player;

import java.util.List;
import java.util.Random;

public class StealPointsCard implements CardService{
        private int id;
        private String message;
        private String parameter;
        private int value;

        public StealPointsCard(int id, String message, String parameter, int value) {
            this.id = id;
            this.message = message;
            this.parameter = parameter;
            this.value = value;
        }
        @Override
        public void executeSpecificCard(Player player, List<Player> players){
            System.out.println("Action of card: " + this.message);
            int randomPlayerIndex;
            do {
                randomPlayerIndex= new Random().nextInt(players.size()-1);
                if (randomPlayerIndex != player.getId()-1) {
                    int newOthersPoints = players.get(randomPlayerIndex).getPoints() - this.value;
                    players.get(randomPlayerIndex).setPoints(newOthersPoints);
                    int newPpoints = player.getPoints();
                    newPpoints += this.value;
                    player.setPoints(newPpoints);
                    System.out.println(player.getName() + " got " + this.value + " points from player " + players.get(randomPlayerIndex).getName() + ".");
                    break;
                }
            } while (true);
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

