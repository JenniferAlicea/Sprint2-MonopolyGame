/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

import java.util.ArrayList;
import java.util.Random;

public class CommunityChestCards extends Cards {

    public ArrayList<CommunityChestCards> chestCards = new ArrayList<>();
    public Random random = new Random();

    public CommunityChestCards(String description, int effect) {
        super(description, effect);
    }

    /**
     * This method creates the deck of Community Chest cards
     */
    public void CommunityChestDeck() {
        chestCards.add(new CommunityChestCards("Bank error in your favor – Collect $200", 200));
        chestCards.add(new CommunityChestCards("Doctor's fees – Pay $50", -50));
        chestCards.add(new CommunityChestCards("From sale of stock, you get $50", 50));
        chestCards.add(new CommunityChestCards("Get Out of Jail Free – Keep this card until needed", 0));
        chestCards.add(new CommunityChestCards("Go to Jail – Go directly to Jail, do not pass Go, do not collect $200", 0));
        chestCards.add(new CommunityChestCards("Holiday fund matures – Collect $100", 100));
        chestCards.add(new CommunityChestCards("Income tax refund – Collect $20", 20));
        chestCards.add(new CommunityChestCards("It is your birthday – Collect $10 from each player", 10));
        chestCards.add(new CommunityChestCards("Life insurance matures – Collect $100", 100));
        chestCards.add(new CommunityChestCards("Pay hospital fees of $100", -100));
        chestCards.add(new CommunityChestCards("Pay school fees of $50", -50));
        chestCards.add(new CommunityChestCards("Receive $25 consultancy fee", 25));
        chestCards.add(new CommunityChestCards("You are assessed for street repair – $40 per house, $115 per hotel", 0));
        chestCards.add(new CommunityChestCards("You have won second prize in a beauty contest – Collect $10", 10));
        chestCards.add(new CommunityChestCards("You inherit $100", 100));
        chestCards.add(new CommunityChestCards("Advance to Go (Collect $200)", 200));
    }

    /**
     * This method draws a card from the Community Chest deck
     * @return the description of the card drawn
     */
    public String drawCard() {
        return chestCards.get(random.nextInt(chestCards.size())).getDescription();
    }

    @Override
    public void applyEffect(Player player) {
        player.updateBalance(getEffect());
    }

    public ArrayList<CommunityChestCards> getChestCards() {
        return chestCards;
    }
}