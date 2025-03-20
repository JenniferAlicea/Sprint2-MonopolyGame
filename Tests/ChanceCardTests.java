import Model.ChanceCards;
import Model.Player;
import Model.Token;
import Model.Tokens;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChanceCardTests {

    private ChanceCards chanceCards;
    private Player player;

    @BeforeEach
    public void setUp() {
        chanceCards = new ChanceCards("Test Card", 100);
        Token token = new Token(Tokens.BOOT);
        player = new Player("John Doe", 1500, token);
    }

    /**
     * Test to verify the description of the chance card.
     */
    @Test
    public void testGetChanceDescription() {
        assertEquals("Test Card", chanceCards.getChanceDescription());
    }

    /**
     * Test to verify the effect of the chance card.
     */
    @Test
    public void testGetChanceEffect() {
        assertEquals(100, chanceCards.getChanceEffect());
    }

    /**
     * Test to verify the application of the chance card effect on the player's balance.
     */
    @Test
    public void testApplyEffect() {
        chanceCards.applyEffect(player);
        assertEquals(1600, player.getBalance());
    }

    /**
     * Test to verify the creation of the chance deck.
     */
    @Test
    public void testChanceDeck() {
        chanceCards.ChanceDeck();
        assertEquals(15, chanceCards.chanceCards.size());
    }

    /**
     * Test to verify drawing a card from the chance deck.
     */
    @Test
    public void testDrawCard() {
        chanceCards.ChanceDeck();
        String drawnCard = chanceCards.drawCard();
        assertEquals(true, drawnCard instanceof String);
    }
}