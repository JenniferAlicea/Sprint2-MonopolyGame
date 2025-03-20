/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
import Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameboardTests {
    private Gameboard gameboard;
    private Player player;

    @BeforeEach
    void setUp() {
        gameboard = new Gameboard();
        player = new Player("TestPlayer", 1500);
    }

    @Test
    void moveTokenIncrementsPlayerPosition() {
        int initialPosition = player.getBoardPosition();
        int steps = 5;
        int newPosition = gameboard.getSpacesMoved(player, steps);
        assertEquals((initialPosition + steps) % gameboard.getSquares().size(), newPosition);
    }

    @Test
    void luxuryTaxDeductsCorrectAmount() {
        int initialBalance = player.getBalance();
        gameboard.luxuryTax(player);
        assertEquals(initialBalance - 100, player.getBalance());
    }

    @Test
    void incomeTaxDeductsCorrectAmount() {
        int initialBalance = player.getBalance();
        gameboard.incomeTax(player);
        assertEquals(initialBalance - 200, player.getBalance());
    }

    @Test
    void placeChanceCardAddsCardToDeck() {
        ChanceCards card = new ChanceCards("Test Chance Card", 0);
        gameboard.placeChanceCard(card);
        assertTrue(gameboard.getChanceCards().contains(card));
    }

    @Test
    void placeCommunityChestCardAddsCardToDeck() {
        CommunityChestCards card = new CommunityChestCards("Test Community Chest Card", 0);
        gameboard.placeCommunityChestCard(card);
        assertTrue(gameboard.getCommunityChestCards().contains(card));
    }

    @Test
    void giveStartingMoneySetsInitialBalance() {
        Player newPlayer = new Player("NewPlayer", 0);
        gameboard.giveStartingMoney(newPlayer);
        assertEquals(1500, newPlayer.getBalance());
    }
}