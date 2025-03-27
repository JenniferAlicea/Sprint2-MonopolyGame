/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

import java.util.List;

public class CommunityChestCardSpace extends BoardSquare {
    private CommunityChestCards communityChestCards;

    public CommunityChestCardSpace(String name, int position, List<CommunityChestCards> communityChestCards) {
        super(name, position);
    }

    @Override
    public void landedOn(Player player, GameState gameState) {
        String cardDescription = gameState.getCommunityChestDeck().drawCard();
        System.out.println("Drew Community Chest card: " + cardDescription);
        gameState.getCommunityChestDeck().applyEffect(player);
    }
}