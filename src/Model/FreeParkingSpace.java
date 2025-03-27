/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

public class FreeParkingSpace extends BoardSquare {

    /**
     * Constructor for the FreeParkingSpace class
     * @param freeParking
     * @param i
     */
    public FreeParkingSpace(String freeParking, int i) {
        super("Free Parking", 20);
    }

    /**
     * This method is called when a player lands on this square
     * @param player the player that landed on this square
     * @param gameState the current state of the game
     */
    @Override
    public void landedOn(Player player, GameState gameState) {
        // No action needed
    }
}