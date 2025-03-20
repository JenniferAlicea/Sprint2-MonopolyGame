/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
import Model.Dice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceTests {

    private Dice dice;

    @BeforeEach
    public void setUp() {
        dice = new Dice();
    }

    /**
     * Test to verify that the dice roll result is between 1 and 6.
     */

    @Test
    public void testRoll() {
        int roll = dice.roll();
        assertTrue(roll >= 2 && roll <= 12, "Roll should be between 2 and 12");
    }

    /**
     * Test to verify that the dice roll result is between 1 and 6.
     */
    @Test
    public void testGetDie1() {
        int die1 = dice.getDie1();
        assertTrue(die1 >= 1 && die1 <= 6, "Die 1 should be between 1 and 6");
    }

    /**
     * Test to verify that the dice roll result is between 1 and 6.
     */
    @Test
    public void testGetDie2() {
        int die2 = dice.getDie2();
        assertTrue(die2 >= 1 && die2 <= 6, "Die 2 should be between 1 and 6");
    }
}