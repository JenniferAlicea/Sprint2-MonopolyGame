import Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameStateTests {

    private GameState gameState;
    private Player player1;
    private Player player2;
    private Gameboard gameboard;
    private Banker banker;
    private TitleDeedCard[] titleDeedCards;

    @BeforeEach
    public void setUp() {
        gameState = new GameState();
        player1 = new Player("Player 1", 1500);
        player2 = new Player("Player 2", 1500);
        gameboard = new Gameboard();
        titleDeedCards = new TitleDeedCard[28];
        for (int i = 0; i < titleDeedCards.length; i++) {
            titleDeedCards[i] = new TitleDeedCard("Property " + (i + 1), Color.BLUE, 100 + (i * 20), 10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        }
        banker = new Banker(titleDeedCards);
        gameState.setBoard(gameboard);
        gameState.setBanker(banker);
        gameState.addPlayer(player1);
        gameState.addPlayer(player2);
    }

    @Test
    public void testAddPlayer() {
        assertEquals(2, gameState.getPlayers().size());
        Player player3 = new Player("Player 3", 1500);
        gameState.addPlayer(player3);
        assertEquals(3, gameState.getPlayers().size());
    }

    @Test
    public void testRemovePlayer() {
        gameState.removePlayer(player1);
        assertEquals(1, gameState.getPlayers().size());
        assertFalse(gameState.getPlayers().contains(player1));
    }

    @Test
    public void testSetAndGetBanker() {
        assertNotNull(gameState.getBank());
        assertEquals(banker, gameState.getBank());
    }

    @Test
    public void testSetAndGetChanceDeck() {
        ChanceCards chanceCards = new ChanceCards("", 0);
        chanceCards.ChanceDeck();
        gameState.setChanceDeck(chanceCards);
        assertEquals(chanceCards, gameState.getChanceDeck());
    }

    @Test
    public void testSetAndGetCommunityChestDeck() {
        CommunityChestCards communityChestCards = new CommunityChestCards("", 0);
        communityChestCards.CommunityChestDeck();
        gameState.setCommunityChestDeck(communityChestCards);
        assertEquals(communityChestCards, gameState.getCommunityChestDeck());
    }

    @Test
    public void testPlayerTurnOrder() {
        gameState.playerTurnOrder();
        List<Player> players = gameState.getPlayers();
        assertNotNull(players);
        assertEquals(2, players.size());
    }

    @Test
    public void testStartAuction() {
        Property property = new Property("Boardwalk", Color.BLUE, titleDeedCards[0], 39);
        gameState.startAuction(property);
        // Assuming auction logic is implemented
    }

    @Test
    public void testEndTurn() {
        gameState.setTurnPhase(TurnPhase.END_TURN);
        gameState.endTurn();
        assertEquals(TurnPhase.ROLL_DICE, gameState.getCurrentPhase());
    }

    @Test
    public void testGetCurrentPlayer() {
        assertEquals(player1, gameState.getCurrentPlayer());
        gameState.endTurn();
        assertEquals(player2, gameState.getCurrentPlayer());
    }
}