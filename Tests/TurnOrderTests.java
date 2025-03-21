/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
import Model.Player;
import Model.TurnOrder;
import Model.Dice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TurnOrderTests {
    private TurnOrder turnOrder;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Dice dice;

    @BeforeEach
    void setUp() {
        turnOrder = new TurnOrder();
        dice = new Dice();
        player1 = new Player("Player1", 1500);
        player2 = new Player("Player2", 1500);
        player3 = new Player("Player3", 1500);
        player4 = new Player("Player4", 1500);
    }

    @Test
    void testAddPlayer() {
        assertTrue(turnOrder.addPlayer(player1));
        assertTrue(turnOrder.addPlayer(player2));
        assertTrue(turnOrder.addPlayer(player3));
        assertTrue(turnOrder.addPlayer(player4));
        assertFalse(turnOrder.addPlayer(new Player("Player5", 1500))); // Should not add more than 4 players
    }

    @Test
    void testGetCurrentPlayer() {
        turnOrder.addPlayer(player1);
        turnOrder.addPlayer(player2);
        assertEquals(player1, turnOrder.getCurrentPlayer());
    }

    @Test
    void testNextTurn() {
        turnOrder.addPlayer(player1);
        turnOrder.addPlayer(player2);
        turnOrder.nextTurn();
        assertEquals(player2, turnOrder.getCurrentPlayer());
        turnOrder.nextTurn();
        assertEquals(player1, turnOrder.getCurrentPlayer()); // Should cycle back to player1
    }

    @Test
    void testFirstRollForTurnOrder() {
        turnOrder.addPlayer(player1);
        turnOrder.addPlayer(player2);
        turnOrder.addPlayer(player3);
        turnOrder.addPlayer(player4);
        turnOrder.firstRollForTurnOrder();
        // This test just ensures the method runs without exceptions
    }

    @Test
    void testPlayerTurnOrder() {
        turnOrder.addPlayer(player1);
        turnOrder.addPlayer(player2);
        turnOrder.addPlayer(player3);
        turnOrder.addPlayer(player4);
        turnOrder.firstRollForTurnOrder();
        turnOrder.playerTurnOrder();
    }
}