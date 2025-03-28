/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChanceCards extends Cards {

    private List<ChanceCards> toBeDisplayedChanceCards = new ArrayList<>();
    private List<ChanceCards> discardedChanceCards = new ArrayList<>();
    private Random random = new Random();

    /**
     * This constructor creates a ChanceCard object
     * @param description the description of the card
     * @param effect the effect of the card
     */
    public ChanceCards(String description, int effect) {
        super(description, effect);
    }

    /**
     * This method creates the Chance deck
     */
    public void ChanceDeck() {
        toBeDisplayedChanceCards.add(new ChanceCards("Advance to Go", 200));
        toBeDisplayedChanceCards.add(new ChanceCards("Advance to Illinois Avenue", 0));
        toBeDisplayedChanceCards.add(new ChanceCards("Advance to St. Charles Place", 0));
        toBeDisplayedChanceCards.add(new ChanceCards("Advance to the nearest railroad", 0));
        toBeDisplayedChanceCards.add(new ChanceCards("Advance to the nearest utility", 0));
        toBeDisplayedChanceCards.add(new ChanceCards("Bank pays you a dividend of $50", 50));
        toBeDisplayedChanceCards.add(new ChanceCards("Get out of jail free", 0));
        toBeDisplayedChanceCards.add(new ChanceCards("Go back three spaces", 0));
        toBeDisplayedChanceCards.add(new ChanceCards("Go to jail", 0));
        toBeDisplayedChanceCards.add(new ChanceCards("Make general repairs on all your property", -25));
        toBeDisplayedChanceCards.add(new ChanceCards("Speeding fine", -15));
        toBeDisplayedChanceCards.add(new ChanceCards("Take a trip to Reading Railroad", 0));
        toBeDisplayedChanceCards.add(new ChanceCards("Advance to Boardwalk", 0));
        toBeDisplayedChanceCards.add(new ChanceCards("You have been elected chairman of the board", -50));
        toBeDisplayedChanceCards.add(new ChanceCards("Building and loan matures", 150));
    }


    /**
     * This method draws a card from the Chance deck
     * @return the description of the card
     */
    public String drawCard() {
        ChanceCards drawnCard = toBeDisplayedChanceCards.get(random.nextInt(toBeDisplayedChanceCards.size()));
        toBeDisplayedChanceCards.remove(drawnCard);
        discardedChanceCards.add(drawnCard);
        return drawnCard.getDescription();
    }

    /**
     * This method applies the effect of the card to the player
     * @param player the player that the card is being applied to
     */
    @Override
    public void applyEffect(Player player) {
        player.updateBalance(getEffect());
    }

    /**
     * This method returns the list of Chance cards to be displayed
     * @return the list of Chance cards to be displayed
     */
    public List<ChanceCards> getToBeDisplayedChanceCards() {
        return toBeDisplayedChanceCards;
    }

    /**
     * This method returns the list of discarded Chance cards
     * @return
     */
    public List<ChanceCards> getDiscardedChanceCards() {
        return discardedChanceCards;
    }
}