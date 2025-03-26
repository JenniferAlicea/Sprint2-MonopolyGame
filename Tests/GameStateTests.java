import Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

public class GameStateTests {
    private GameState gameState;
    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;
    private Dice dice;
    private Gameboard board;
    private Banker banker;

    @BeforeEach
    void setUp() {
        gameState = new GameState();
        dice = new Dice();
        board = new Gameboard();
        TitleDeedCard[] titleDeeds = new TitleDeedCard[] {
            new TitleDeedCard("Mediterranean Avenue", new Color(58, 6, 6), 60, 2, 4, 10, 30, 90, 160, 250, 50, 50, 30),
            new TitleDeedCard("Baltic Avenue", new Color(58, 6, 6), 60, 4, 8, 20, 60, 180, 320, 450, 50, 50, 30)
            // Add more TitleDeedCard instances as needed
        };
        banker = new Banker(titleDeeds);
        gameState.setBoard(board);
        gameState.setBanker(banker);
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

    @Test
    void canStartGameWithMinimumPlayers() {
        GameState testState = new GameState();
        testState.addPlayer(new Player("Test1", 1500));
        assertFalse(testState.canStartGame());

        testState.addPlayer(new Player("Test2", 1500));
        assertTrue(testState.canStartGame());
    }

    @Test
    void rollDiceUpdatesPhaseAndReturnsTotal() {
        int roll = gameState.rollDice();
        assertTrue(roll >= 2 && roll <= 12);
        assertEquals(TurnPhase.MOVE_TOKEN, gameState.getCurrentPhase());
    }

    @Test
    void moveTokenUpdatesPlayerPosition() {
        gameState.rollDice(); // Move to MOVE_TOKEN phase
        Player currentPlayer = gameState.getCurrentPlayer();
        int initialPosition = currentPlayer.getToken().getBoardPosition();

        gameState.moveToken(5);

        assertEquals((initialPosition + 5) % 40, currentPlayer.getToken().getBoardPosition());
        assertEquals(TurnPhase.HANDLE_SQUARE_ACTION, gameState.getCurrentPhase());
    }

    @Test
    void playerPassingGOReceivesSalary() {
        gameState.rollDice();
        Player currentPlayer = gameState.getCurrentPlayer();
        currentPlayer.getToken().setBoardPosition(38);
        int initialBalance = currentPlayer.getBalance();

        gameState.moveToken(4); // Move from position 38 to position 2 (passing GO)

        assertEquals(initialBalance + 200, currentPlayer.getBalance());
    }

    @Test
    void completePlayerTurnCycleWorksCorrectly() {
        Player initialPlayer = gameState.getCurrentPlayer();

        gameState.rollDice();
        gameState.moveToken(5);
        gameState.handleSquareAction();
        gameState.performAction(PlayerAction.END_TURN);
        gameState.endTurn();

        assertNotEquals(initialPlayer, gameState.getCurrentPlayer());
        assertEquals(TurnPhase.ROLL_DICE, gameState.getCurrentPhase());
    }

    @Test
    void throwsExceptionWhenRollingDiceInWrongPhase() {
        gameState.rollDice(); // Now in MOVE_TOKEN phase

        assertThrows(IllegalStateException.class, () -> gameState.rollDice());
    }

    @Test
    void throwsExceptionWhenMovingTokenInWrongPhase() {
        assertThrows(IllegalStateException.class, () -> gameState.moveToken(5));
    }

    @Test
    void throwsExceptionWhenHandlingSquareActionInWrongPhase() {
        assertThrows(IllegalStateException.class, () -> gameState.handleSquareAction());
    }

    @Test
    void throwsExceptionWhenPerformingActionsInWrongPhase() {
        assertThrows(IllegalStateException.class, () ->
                gameState.performAction(PlayerAction.END_TURN));
    }

    @Test
    void throwsExceptionWhenEndingTurnInWrongPhase() {
        assertThrows(IllegalStateException.class, () -> gameState.endTurn());
    }

    @Test
    void gameIsOverWhenOnlyOnePlayerRemainsSolvent() {
        // Make all but one player bankrupt
        player2.updateBalance(-1500);
        player3.updateBalance(-1500);
        player4.updateBalance(-1500);

        assertTrue(gameState.isGameOver());
        assertEquals(player1, gameState.getWinner());
    }

    @Test
    void gameIsNotOverWhenMultiplePlayersSolvent() {
        // Two players still have money
        player3.updateBalance(-1500);
        player4.updateBalance(-1500);

        assertFalse(gameState.isGameOver());
    }
}