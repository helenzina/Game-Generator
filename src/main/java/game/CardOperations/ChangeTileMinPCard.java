package game.CardOperations;

import game.GameplayOperations.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChangeTileMinPCard implements CardService{
        private int id;
        private String message;
        private String parameter;
        private int value;

        public ChangeTileMinPCard(int id, String message, String parameter, int value) {
            this.id = id;
            this.message = message;
            this.parameter = parameter;
            this.value = value;
        }

        @Override
        public void executeSpecificCard(Player player, List<Player> players){
            List<Player> sortedPlayers = new ArrayList<>(players);
            Collections.sort(sortedPlayers, new Comparator<Player>() {
                @Override
                public int compare(Player p1, Player p2) {
                    Integer pointsPlayer1 = p1.getPoints();
                    Integer pointsPlayer2 = p2.getPoints();
                    return pointsPlayer1.compareTo(pointsPlayer2);
                }
            });
            System.out.println("Action of card: " + this.message);
                if (player.getPoints() == sortedPlayers.get(0).getPoints()) {
                    System.out.println(player.getName() + ", you have the minimum amount of points.");
                } else {
                    int currentPlayerPosition = player.getPosition();
                    int playerPositionToChange = sortedPlayers.get(0).getPosition();
                    int playerIDToChange = sortedPlayers.get(0).getId();
                    for (Player singlePlayer: players){
                        if (singlePlayer.getId() == playerIDToChange){
                            singlePlayer.setPosition(currentPlayerPosition);
                            player.setPosition(playerPositionToChange);
                            break;
                        }
                    }
                    System.out.println(player.getName() + " changed position with " + sortedPlayers.get(0).getName() + " as they had the minimum amount of points.");
            }
        }

        public int getId() { return this.id; }
        public void setId(int id) { this.id = id; }
        public String getMessage() { return this.message; }
        public void setMessage(String message) { this.message = message; }
        public void printMessage(String message){System.out.println(message);}
        public String getParameter() { return this.parameter; }
        public void setParameter(String parameter) { this.parameter = parameter; }
        public int getValue() { return this.value; }
        public void setValue(int value) { this.value = value; }

    }

