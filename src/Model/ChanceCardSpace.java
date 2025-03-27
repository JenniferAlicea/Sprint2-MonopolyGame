/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

import java.util.List;

public class ChanceCardSpace extends BoardSquare {

    private ChanceCards chanceCards;

    public ChanceCardSpace(String name, int position, List<ChanceCards> chanceCards) {
        super(name, position);
    }


    @Override
    public void landedOn(Player player, GameState gameState) {

        String cardDescription = gameState.getChanceDeck().drawCard();
        System.out.println("Drew Chance card: " + cardDescription);
        gameState.getChanceDeck().applyEffect(player);

    }
}
