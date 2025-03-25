/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
import Model.Player;
import Model.GameState;
import Model.Dice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameStateTests {
    private GameState gameState;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Dice dice;

    @BeforeEach
    void setUp() {
        gameState = new GameState();
        dice = new Dice();
        player1 = new Player("Player1", 1500);
        player2 = new Player("Player2", 1500);
        player3 = new Player("Player3", 1500);
        player4 = new Player("Player4", 1500);
        gameState.addPlayer(player1);
        gameState.addPlayer(player2);
        gameState.addPlayer(player3);
        gameState.addPlayer(player4);
    }

    @Test
    void testAddPlayer() {
        assertFalse(gameState.addPlayer(new Player("Player5", 1500))); // Should not add more than 4 players
    }

    @Test
    void testGetCurrentPlayer() {
        assertEquals(player1, gameState.getCurrentPlayer());
    }

    @Test
    void testNextTurn() {
        gameState.nextTurn();
        assertEquals(player2, gameState.getCurrentPlayer());
        gameState.nextTurn();
        assertEquals(player3, gameState.getCurrentPlayer());
        gameState.nextTurn();
        assertEquals(player4, gameState.getCurrentPlayer());
        gameState.nextTurn();
        assertEquals(player1, gameState.getCurrentPlayer());
    }

    @Test
    void testFirstRollForTurnOrder() {
        gameState.addPlayer(player1);
        gameState.addPlayer(player2);
        gameState.addPlayer(player3);
        gameState.addPlayer(player4);
        gameState.firstRollForTurnOrder();
        // This test just ensures the method runs without exceptions
    }

    @Test
    void testPlayerTurnOrder() {
        gameState.addPlayer(player1);
        gameState.addPlayer(player2);
        gameState.addPlayer(player3);
        gameState.addPlayer(player4);
        gameState.firstRollForTurnOrder();
        gameState.playerTurnOrder();
    }
}