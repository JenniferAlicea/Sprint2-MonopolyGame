/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
import Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTests {

    private Player player;
    private Token token;
    Color Brown = new Color(58, 6, 6);
    Color LightBlue = new Color(3, 255, 255);
    Color DarkBlue = new Color(16, 41, 166);

    @BeforeEach
    public void setUp() {
        player = new Player("John Doe", 1500);
        token = new Token(TokenIcons.BOOT, player);
        player.setToken(token);
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
        assertEquals(TokenIcons.BOOT, player.getToken().getType());
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

    /**
     * Test to verify that a player does not contain a monopoly
     */
    @Test
    public void testDoesNotHaveMonopoly() {
        assertEquals(false, player.monopolies.get(Color.GREEN));
        assertEquals(false, player.monopolies.get(Color.RED));
        assertEquals(false, player.monopolies.get(Color.YELLOW));
        assertEquals(false, player.monopolies.get(Color.ORANGE));
        assertEquals(false, player.monopolies.get(Color.PINK));
        assertEquals(false, player.monopolies.get(LightBlue));
        assertEquals(false, player.monopolies.get(Brown));
        assertEquals(false, player.monopolies.get(DarkBlue));
    }

    /**
     * Test to verify that a player has a monopoly with the LightBlue properties
     */
    @Test
    public void testHasLightBlueMonopoly() {
        player.getOwnedProperties().add(new Property("Connecticut Avenue", LightBlue));
        player.getOwnedProperties().add(new Property("Vermont Avenue", LightBlue));
        player.getOwnedProperties().add(new Property("Oriental Avenue", LightBlue));
        player.checkMonopoly();
        assertEquals(true, player.monopolies.get(LightBlue));
        assertEquals(false, player.monopolies.get(Color.GREEN));
        assertEquals(false, player.monopolies.get(Color.RED));
        assertEquals(false, player.monopolies.get(Color.YELLOW));
        assertEquals(false, player.monopolies.get(Color.ORANGE));
        assertEquals(false, player.monopolies.get(Color.PINK));
        assertEquals(false, player.monopolies.get(Brown));
        assertEquals(false, player.monopolies.get(DarkBlue));
    }

    @Test
    public void testMortgageProperty() {
        Player player = new Player("John Doe", 1500);
        Property property = new Property("Boardwalk", Color.BLUE);
        player.mortgageProperty(property);
        assertEquals(1, player.getMortgagedProperties().size());
        assertEquals(property, player.getMortgagedProperties().get(0));
        //TODO: Test for player balance going up after getMortgageValue() is implemented
        //assertEquals(1500 + property.getMortgageValue(), player.getBalance());
    }

    @Test
    public void testMortgageRailroad() {
        Player player = new Player("John Doe", 1500);
        Railroad railroad = new Railroad("Reading Railroad");
        player.mortgageRailroad(railroad);
        assertEquals(1, player.getMortgagedRailroads().size());
        assertEquals(railroad, player.getMortgagedRailroads().get(0));
        //TODO: Test for player balance going up after getMortgageValue() is implemented
        //assertEquals(1500 + railroad.getMortgageValue(), player.getBalance());
    }

    @Test
    public void testMortgageUtility() {
        Player player = new Player("John Doe", 1500);
        Utility utility = new Utility("Electric Company");
        player.mortgageUtility(utility);
        assertEquals(1, player.getMortgagedUtilities().size());
        assertEquals(utility, player.getMortgagedUtilities().get(0));
        //TODO: Test for player balance going up after getMortgageValue() is implemented
        //assertEquals(1500 + ultility.getMortgageValue(), player.getBalance());
    }
}
