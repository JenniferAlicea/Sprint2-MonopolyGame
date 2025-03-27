/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

public class GoToJailSpace extends BoardSquare {

    public GoToJailSpace(String name, int position) {
        super(name, position);
    }

    @Override
    public void landedOn(Player player, GameState gameState) {
        sendToJail(player.getToken());
    }
    public void sendToJail(Token token){
        token.sendToJail(true);
    }



}
