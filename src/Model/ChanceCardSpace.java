/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

import java.util.List;

public class ChanceCardSpace extends BoardSquare {

    private ChanceCards chanceCards;

    /**
     * Constructor for the ChanceCardSpace class
     * @param name the name of the chance card
     * @param position the position of the chance card
     * @param chanceCards the list of chance cards
     */
    public ChanceCardSpace(String name, int position, List<ChanceCards> chanceCards) {
        super(name, position);
    }


    /**
     * This method is called when a player lands on a chance card space
     * @param player the player that landed on the space
     * @param gameState the current state of the game
     */
    @Override
    public void landedOn(Player player, GameState gameState) {

        String cardDescription = gameState.getChanceDeck().drawCard();
        System.out.println("Drew Chance card: " + cardDescription);
        gameState.getChanceDeck().applyEffect(player);

    }
}
