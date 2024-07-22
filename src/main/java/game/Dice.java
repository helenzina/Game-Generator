package game;

import java.util.Random;
public class Dice {
    private int dice;

    public Dice() {
        this.dice = 0;
    }

    public void roll() {
        this.dice = new Random().nextInt(6) + 1;
    }

    public void setDice(int dice){
        this.dice = dice;
    }

    public int getDice(){
        return this.dice;
    }
}
