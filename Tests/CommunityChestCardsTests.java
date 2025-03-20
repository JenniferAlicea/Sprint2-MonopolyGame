/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
import Model.CommunityChestCards;
import Model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommunityChestCardsTests {
    private CommunityChestCards communityChestCards;
    private Player player;

    @BeforeEach
    void setUp() {
        communityChestCards = new CommunityChestCards("Bank error in your favor – Collect $200", 200);
        player = new Player("TestPlayer", 1500);
    }

    @Test
    void testGetDescription() {
        assertEquals("Bank error in your favor – Collect $200", communityChestCards.getDescription());
    }

    @Test
    void testGetEffect() {
        assertEquals(200, communityChestCards.getEffect());
    }

    @Test
    void testApplyEffect() {
        communityChestCards.applyEffect(player);
        assertEquals(1700, player.getBalance());
    }

    @Test
    void testDrawCard() {
        communityChestCards.CommunityChestDeck();
        String cardDescription = communityChestCards.drawCard();
        assertNotNull(cardDescription);
        assertFalse(cardDescription.isEmpty());
    }

    @Test
    void testCommunityChestDeckSize() {
        communityChestCards.CommunityChestDeck();
        assertEquals(16, communityChestCards.getChestCards().size());
    }
}