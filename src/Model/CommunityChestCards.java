/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommunityChestCards extends Cards {

    private List<CommunityChestCards> toBeDisplayedCommunityChestCards = new ArrayList<>();
    private List<CommunityChestCards> discardedCommunityChestCards = new ArrayList<>();
    private Random random = new Random();

    public CommunityChestCards(String description, int effect) {
        super(description, effect);
    }

    public void CommunityChestDeck() {
        toBeDisplayedCommunityChestCards.add(new CommunityChestCards("Bank error in your favor – Collect $200", 200));
        toBeDisplayedCommunityChestCards.add(new CommunityChestCards("Doctor's fees – Pay $50", -50));
        toBeDisplayedCommunityChestCards.add(new CommunityChestCards("From sale of stock, you get $50", 50));
        toBeDisplayedCommunityChestCards.add(new CommunityChestCards("Get Out of Jail Free – Keep this card until needed", 0));
        toBeDisplayedCommunityChestCards.add(new CommunityChestCards("Go to Jail – Go directly to Jail, do not pass Go, do not collect $200", 0));
        toBeDisplayedCommunityChestCards.add(new CommunityChestCards("Holiday fund matures – Collect $100", 100));
        toBeDisplayedCommunityChestCards.add(new CommunityChestCards("Income tax refund – Collect $20", 20));
        toBeDisplayedCommunityChestCards.add(new CommunityChestCards("It is your birthday – Collect $10 from each player", 10));
        toBeDisplayedCommunityChestCards.add(new CommunityChestCards("Life insurance matures – Collect $100", 100));
        toBeDisplayedCommunityChestCards.add(new CommunityChestCards("Pay hospital fees of $100", -100));
        toBeDisplayedCommunityChestCards.add(new CommunityChestCards("Pay school fees of $50", -50));
        toBeDisplayedCommunityChestCards.add(new CommunityChestCards("Receive $25 consultancy fee", 25));
        toBeDisplayedCommunityChestCards.add(new CommunityChestCards("You are assessed for street repair – $40 per house, $115 per hotel", 0));
        toBeDisplayedCommunityChestCards.add(new CommunityChestCards("You have won second prize in a beauty contest – Collect $10", 10));
        toBeDisplayedCommunityChestCards.add(new CommunityChestCards("You inherit $100", 100));
        toBeDisplayedCommunityChestCards.add(new CommunityChestCards("Advance to Go (Collect $200)", 200));
    }

    public String drawCard() {
        CommunityChestCards drawnCard = toBeDisplayedCommunityChestCards.get(random.nextInt(toBeDisplayedCommunityChestCards.size()));
        toBeDisplayedCommunityChestCards.remove(drawnCard);
        discardedCommunityChestCards.add(drawnCard);
        return drawnCard.getDescription();
    }

    @Override
    public void applyEffect(Player player) {
        player.updateBalance(getEffect());
    }

    public List<CommunityChestCards> getToBeDisplayedCommunityChestCards() {
        return toBeDisplayedCommunityChestCards;
    }

    public List<CommunityChestCards> getDiscardedCommunityChestCards() {
        return discardedCommunityChestCards;
    }
}