/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import Model.Banker;
import Model.Player;
import Model.TitleDeedCard;

public class BankerTests {
    private Banker banker;

    @BeforeEach
    void setUp() {
        TitleDeedCard[] emptyCards = new TitleDeedCard[0];
        banker = new Banker(emptyCards);
    }

    /**
     * Test to verify the balance of the banker.
     */
    @Test
    void testUpdateBalance() {
        Player player = new Player("TestPlayer", 1500);
        banker.updateBalance(player, 200, "Test");
        assertEquals(1700, player.getBalance());
    }

}