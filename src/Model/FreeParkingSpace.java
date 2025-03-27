/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

public class FreeParkingSpace extends BoardSquare {
    public FreeParkingSpace(String freeParking, int i) {
        super("Free Parking", 20);
    }

    @Override
    public void landedOn(Player player, GameState gameState) {
        // No action needed
    }
}