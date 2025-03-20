import Model.Player;
import Model.Token;
import Model.Tokens;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTests {

    private Player player;
    private Token token;

    @BeforeEach
    public void setUp() {
        token = new Token(Tokens.BOOT);
        player = new Player("John Doe", 1500, token);
    }

    /**
     * Test to verify the player's name.
     */
    @Test
    public void testGetName() {
        assertEquals("John Doe", player.getName());
    }

    /**
     * Test to verify the player's balance.
     */
    @Test
    public void testGetBalance() {
        assertEquals(1500, player.getBalance());
    }

    /**
     * Test to verify the player's token.
     */
    @Test
    public void testGetToken() {
        assertNotNull(player.getToken());
        assertEquals(Tokens.BOOT, player.getToken().getType());
    }

    /**
     * Test to verify setting a new name for the player.
     */
    @Test
    public void testSetName() {
        player.setName("Jane Doe");
        assertEquals("Jane Doe", player.getName());
    }

    /**
     * Test to verify depositing money to the player's balance.
     */
    @Test
    public void testDeposit() {
        player.deposit(500);
        assertEquals(2000, player.getBalance());
    }

    /**
     * Test to verify withdrawing money from the player's balance.
     */
    @Test
    public void testWithdraw() {
        player.withdraw(300);
        assertEquals(1200, player.getBalance());
    }
}