/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

public abstract class BoardSquare {
    protected String name;
    protected int position;
    protected Player owner;
    
    public BoardSquare(String name, int position) {
        this.name = name;
        this.position = position;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPosition() {
        return position;
    }
    
    public abstract void landedOn(Player player, GameState gameState);
    
    public Player getOwner() {
        return owner;
    }
}