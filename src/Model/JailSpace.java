/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

public class JailSpace extends BoardSquare {


    /**
     * Constructor for the JailSpace class
     * @param s
     * @param i
     */
    public JailSpace(String s, int i) {
        super("Jail", 10);
    }

    @Override
    /**
     * This method is called when a player lands on this square
     * @param player the player that landed on this square
     * @param gameState the current state of the game
     */
    public void landedOn(Player player, GameState gameState) {
        sendToJail(player.getToken());
    }
    /**
     * This method sends the player to jail when they land on the jail space
     * @param token the token that landed on the jail space
     */
    public void sendToJail(Token token){
        token.sendToJail(true);
    }
}
