import Model.CommunityChestCards;
import Model.Player;
import Model.Token;
import Model.Tokens;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommunityChestTests {

    private CommunityChestCards communityChestCards;
    private Player player;

    @BeforeEach
    public void setUp() {
        communityChestCards = new CommunityChestCards("Test Card", 100);
        Token token = new Token(Tokens.BOOT);
        player = new Player("John Doe", 1500, token);
    }

    /**
     * Test to verify the description of the community chest card.
     */
    @Test
    public void testGetCommunityChestDescription() {
        assertEquals("Test Card", communityChestCards.getCommunityChestDescription());
    }

    /**
     * Test to verify the effect of the community chest card.
     */
    @Test
    public void testGetCommunityChestEffect() {
        assertEquals(100, communityChestCards.getCommunityChestEffect());
    }

    /**
     * Test to verify the application of the community chest card effect on the player's balance.
     */
    @Test
    public void testApplyEffect() {
        communityChestCards.applyEffect(player);
        assertEquals(1600, player.getBalance());
    }

    /**
     * Test to verify the creation of the community chest deck.
     */
    @Test
    public void testCommunityChestDeck() {
        communityChestCards.CommunityChestDeck();
        assertEquals(16, communityChestCards.chestCards.size());
    }

    /**
     * Test to verify drawing a card from the community chest deck.
     */
    @Test
    public void testDrawCard() {
        communityChestCards.CommunityChestDeck();
        String drawnCard = communityChestCards.drawCard();
        assertNotNull(drawnCard);
    }
}