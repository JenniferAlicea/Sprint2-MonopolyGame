/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

import java.util.ArrayList;
import java.util.Random;

public class ChanceCards extends Cards {

    public ArrayList<ChanceCards> chanceCards = new ArrayList<>();
    public Random random = new Random();

    public ChanceCards(String description, int effect) {
        super(description, effect);
    }

    /**
     * This method creates the deck of Chance cards
     */
    public void ChanceDeck() {
        chanceCards.add(new ChanceCards("Advance to Go", 200));
        chanceCards.add(new ChanceCards("Advance to Illinois Avenue", 0));
        chanceCards.add(new ChanceCards("Advance to St. Charles Place", 0));
        chanceCards.add(new ChanceCards("Advance to the nearest railroad", 0)); // If owned, pay double rent
        chanceCards.add(new ChanceCards("Advance to the nearest utility", 0)); // If owned, roll dice and pay 10x dice roll
        chanceCards.add(new ChanceCards("Bank pays you a dividend of $50", 50));
        chanceCards.add(new ChanceCards("Get out of jail free", 0));
        chanceCards.add(new ChanceCards("Go back three spaces", 0));
        chanceCards.add(new ChanceCards("Go to jail", 0));
        chanceCards.add(new ChanceCards("Make general repairs on all your property", -25)); // Per house: -$25, per hotel: -$100
        chanceCards.add(new ChanceCards("Speeding fine", -15));
        chanceCards.add(new ChanceCards("Take a trip to Reading Railroad", 0));
        chanceCards.add(new ChanceCards("Advance to Boardwalk", 0));
        chanceCards.add(new ChanceCards("You have been elected chairman of the board", -50)); // Pay $50 per player
        chanceCards.add(new ChanceCards("Building and loan matures", 150));
    }

    /**
     * This method draws a card from the deck of Chance cards
     * @return the description of the card drawn
     */
    public String drawCard() {
        return chanceCards.get(random.nextInt(chanceCards.size())).getDescription();
    }

    @Override
    public void applyEffect(Player player) {
        player.updateBalance(getEffect());
    }

    public ArrayList<ChanceCards> getChanceCards() {
        return chanceCards;
    }
}