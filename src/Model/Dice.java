package Model;

import java.io.Serializable;
import java.util.Random;
import Exceptions.IndexOutOfBoundsException;


public class Dice {
    private final Random random;
    private static int die1;
    private static int die2;
    private boolean isDouble;
    private int totalDoubles = 0;

    public Dice() {
        this.random = new Random();
        roll(); // Initialize dice with a roll
    }

    /**
     * Rolls two six-sided dice.
     * Updates the dice values and checks if it's a double.
     *
     * @return
     */
    public int roll() {
        try {
            die1 = random.nextInt(6) + 1; // Generates a number between 1 and 6
            die2 = random.nextInt(6) + 1;
            isDouble = die1 == die2;
            if (isDouble) {
                totalDoubles++;
            } else {
                totalDoubles = 0;
            }
            return getTotal();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Dice roll result should be between 1 and 6");
            return 0;
        }
    }

    /**
     * Returns the sum of both dice.
     * @return the total roll value.
     */
    public int getTotal() {
        try {
            return die1 + die2;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Dice roll result should be between 1 and 6");
            return 0;
        }
    }

    /**
     * Checks if the player rolled a double.
     * @return true if both dice have the same value, false otherwise.
     */
    public boolean isDouble() {
        return isDouble;
    }

    /**
     * Gets the value of the first die.
     * @return the value of die1.
     */
    public static int getDie1() {
        return die1;
    }

    /**
     * Gets the value of the second die.
     * @return the value of die2.
     */
    public static int getDie2() {
        return die2;
    }

    /**
     * Gets the total number of doubles rolled in a row.
     * @return the total number of doubles rolled.
     */
    public int getTotalDoubles() {
        if (totalDoubles > 3) {
            return 3;
        } else {
            return totalDoubles;
        }


    }
}