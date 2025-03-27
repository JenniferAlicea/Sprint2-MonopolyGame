/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

public class LuxuryTaxSpace extends BoardSquare {

    /**
     * Constructor for the LuxuryTaxSpace class
     * @param luxuryTax
     * @param i
     */
    public LuxuryTaxSpace(String luxuryTax, int i) {
        super("Luxury Tax", 38);
    }

    /**
     * This method is called when a player lands on this square
     * @param player the player that landed on this square
     * @param gameState the current state of the game
     */
    @Override
    public void landedOn(Player player, GameState gameState) {
        payLuxuryTax(player.getToken());
    }
    /**
     * This method pays the luxury tax when a player lands on the luxury tax space
     * @param token the token that landed on the luxury tax space
     */
    public void payLuxuryTax(Token token){
        token.payLuxuryTax();
    }
}
