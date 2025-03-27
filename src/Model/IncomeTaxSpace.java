/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

public class IncomeTaxSpace extends BoardSquare{

    /**
     * Constructor for the IncomeTaxSpace class
     * @param incomeTax
     * @param i
     */
    public IncomeTaxSpace(String incomeTax, int i) {
        super("Income Tax", 4);
    }

    @Override
    /**
     * This method is called when a player lands on this square
     * @param player the player that landed on this square
     * @param gameState the current state of the game
     */
    public void landedOn(Player player, GameState gameState) {
        payIncomeTax(player.getToken());
    }

    /**
     * This method pays the income tax when a player lands on the income tax space
     * @param token the token that landed on the income tax space
     */
    public void payIncomeTax(Token token){
        token.payIncomeTax();
    }
}
