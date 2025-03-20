/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
import Model.ChanceCards;
import Model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChanceCardsTests {
    private ChanceCards chanceCards;
    private Player player;

    @BeforeEach
    void setUp() {
        chanceCards = new ChanceCards("Advance to Go", 200);
        player = new Player("TestPlayer", 1500);
    }

    @Test
    void testGetDescription() {
        assertEquals("Advance to Go", chanceCards.getDescription());
    }

    @Test
    void testGetEffect() {
        assertEquals(200, chanceCards.getEffect());
    }

    @Test
    void testApplyEffect() {
        chanceCards.applyEffect(player);
        assertEquals(1700, player.getBalance());
    }

    @Test
    void testDrawCard() {
        chanceCards.ChanceDeck();
        String cardDescription = chanceCards.drawCard();
        assertNotNull(cardDescription);
        assertFalse(cardDescription.isEmpty());
    }

    @Test
    void testChanceDeckSize() {
        chanceCards.ChanceDeck();
        assertEquals(15, chanceCards.getChanceCards().size());
    }
}