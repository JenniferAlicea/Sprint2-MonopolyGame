/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

public class JailSpace extends BoardSquare {


    public JailSpace(String s, int i) {
        super("Jail", 10);
    }

    @Override
    public void landedOn(Player player, GameState gameState) {
        sendToJail(player.getToken());
    }
    public void sendToJail(Token token){
        token.sendToJail(true);
    }
}
