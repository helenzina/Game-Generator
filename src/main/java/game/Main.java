package game;

import game.GameplayOperations.Game;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Game Generator. \t ");
        chooseGame();
    }

    private static void chooseGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Your game state will be saved automatically.");
        System.out.println("Choose a game from the Game Generator: ");
        System.out.println("1. Limited range board game of progress and setbacks.");
        System.out.println("2. Endless board game containing cards and special abilities.");
        System.out.println("3. Initialize your own game based on the example.json or load a saved game and play.");
        System.out.println("0. Exit.");

        boolean isAnswer = false;
        do {

            int userChoice= Validate.input();

            switch (userChoice) {
                case 1:
                    executeLimitedRangeGame();
                case 2:
                    executeEndlessRangeGame();
                case 3:
                    executeUsersGame();
                case 0:
                    System.out.println("Exiting.");
                    System.exit(0);
                default:
                    System.out.println("Not a valid input. Try again.");
                    isAnswer = true;
            }

        } while (isAnswer);
    }

    private static void executeLimitedRangeGame(){
        Game game = new Game();
        game.createGame(1);
        game.play();
    }

    private static void executeEndlessRangeGame(){
        Game game = new Game();
        game.createGame(2);
        game.play();
    }
    private static void executeUsersGame(){
        Game game = new Game();
        game.createGame(3);
        game.play();
    }
}

