/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

public abstract class BoardSquare {
    protected String name;
    protected int position;
    protected Player owner;

    /**
     * This constructor creates a new BoardSquare object
     * @param name
     * @param position
     */
    public BoardSquare(String name, int position) {
        this.name = name;
        this.position = position;
    }


    /**
     * This method returns the name of the square
     * @return the name of the square
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the position of the square
     * @return the position of the square
     */
    public int getPosition() {
        return position;
    }
    /**
     * This method is called when a player lands on this square
     * @param player the player that landed on this square
     * @param gameState the current state of the game
     */
    public abstract void landedOn(Player player, GameState gameState);

    /**
     * This method sets the owner of the square
     * @return player that owns the square
     */
    public Player getOwner() {
        return owner;
    }
}