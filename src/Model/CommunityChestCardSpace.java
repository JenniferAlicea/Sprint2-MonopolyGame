/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

import java.util.List;

public class CommunityChestCardSpace extends BoardSquare {
    private CommunityChestCards communityChestCards;

    /**
     * Constructor for the CommunityChestCardSpace class
     * @param name the name of the community chest card
     * @param position the position of the community chest card
     * @param communityChestCards the list of community chest cards
     */
    public CommunityChestCardSpace(String name, int position, List<CommunityChestCards> communityChestCards) {
        super(name, position);
    }

    /**
     * This method is called when a player lands on a community chest card space
     * @param player the player that landed on the space
     * @param gameState the current state of the game
     */
    @Override
    public void landedOn(Player player, GameState gameState) {
        String cardDescription = gameState.getCommunityChestDeck().drawCard();
        System.out.println("Drew Community Chest card: " + cardDescription);
        gameState.getCommunityChestDeck().applyEffect(player);
    }
}