/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

public class GoToJailSpace extends BoardSquare {

    /**
     * Constructor for the GoToJailSpace class
     * @param name
     * @param position
     */
    public GoToJailSpace(String name, int position) {
        super(name, position);
    }

    /**
     * This method is called when a player lands on this square
     * @param player the player that landed on this square
     * @param gameState the current state of the game
     */
    @Override
    public void landedOn(Player player, GameState gameState) {
        sendToJail(player.getToken());
    }
    public void sendToJail(Token token){
        token.sendToJail(true);
    }



}
