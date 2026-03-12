package LuckyDiceAdventure;

import java.util.Random;

public class Dice {
    private int value;

    // Step 1: Default Constructor to initialize dice
    public Dice() {
        this.value = 1;
    }

    // Step 2: Method to roll the dice
    public void roll() {
        Random random = new Random();
        value = random.nextInt(6) + 1;
    }

    // Step 3: Method to get the current value of the dice
    public int getValue() {
        return this.value;
    }
}
