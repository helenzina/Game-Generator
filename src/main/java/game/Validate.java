package game;

import java.util.Scanner;

public class Validate {

    public static int input() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            try {
                choice = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Not an integer. Try again.");
            }
        }while(true);
        return choice;
    }
}
