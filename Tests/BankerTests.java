/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */

import Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.*;

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


    @Test
    void testSellProperty() {
        TitleDeedCard[] titleDeedCards = new TitleDeedCard[0];
        Banker banker = new Banker(titleDeedCards);
        Player player = new Player("John Doe", 1500);
        TitleDeedCard titleDeedCard = new TitleDeedCard("Boardwalk", Color.BLUE, 50, 200, 50, 100, 150, 200, 250, 300, 350, 400, 200);
        Property property = new Property("Boardwalk", Color.BLUE, titleDeedCard, 39);
        Railroad railroad = new Railroad("Reading Railroad", 200, 25, 50, 100, 200, 100);
        Utility utility = new Utility("Electric Company", 150, 75, 12, false);

        banker.sellProperty(property, player);
        assertEquals(1450, player.getBalance());

        banker.sellProperty(railroad, player);
        assertEquals(1250, player.getBalance());

        banker.sellProperty(utility, player);
        assertEquals(1100, player.getBalance());
    }


    @Test
    void testLoanMoney() {
        TitleDeedCard[] titleDeedCards = new TitleDeedCard[0];
        Banker banker = new Banker(titleDeedCards);
        Player player = new Player("John Doe", 1500);

        banker.loanMoney(player, 500);
        assertEquals(2000, player.getBalance());
    }

    @Test
    void testCollectMortgage() {
        TitleDeedCard[] titleDeedCards = new TitleDeedCard[0];
        Banker banker = new Banker(titleDeedCards);
        Player player = new Player("John Doe", 1500);
        TitleDeedCard titleDeedCard = new TitleDeedCard("Boardwalk", Color.BLUE, 50, 200, 50, 100, 150, 200, 250, 300, 350, 400, 200);
        Property property = new Property("Boardwalk", Color.BLUE, titleDeedCard, 39);

        banker.collectMortgage(player, property);
        assertEquals(1700, player.getBalance());
    }
}