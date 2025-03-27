import Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

public class PropertyTests {

    private Property property;
    private Player player;
    private Player owner;
    private GameState gameState;

    @BeforeEach
    public void setUp() {
        Color DarkBlue = new Color(0, 0, 139);
        TitleDeedCard titleDeed = new TitleDeedCard("Boardwalk", DarkBlue, 50, 200, 50, 100, 150, 200,
                250, 300, 350, 400, 200);
        property = new Property("Boardwalk", Color.BLUE, titleDeed, 39);
        player = new Player("Player 1", 1500);
        owner = new Player("Owner", 1500);
        gameState = new GameState();
    }

    @Test
    public void testGetName() {
        assertEquals("Boardwalk", property.getName());
    }

    @Test
    public void testGetPosition() {
        assertEquals(39, property.getPosition());
    }

    @Test
    public void testGetColor() {
        assertEquals(Color.BLUE, property.getColor());
    }

    @Test
    public void testGetPrice() {
        assertEquals(50, property.getPrice());
    }

    @Test
    public void testGetOwner() {
        assertNull(property.getOwner());
        property.setOwner(owner);
        assertEquals(owner, property.getOwner());
    }



    @Test
    public void testMortgageProperty() {
        property.setOwner(owner);
        property.setMortgaged(true);
        assertTrue(property.isMortgaged());
        assertEquals(0, property.calculateRent());
    }

    @Test
    public void testAddHouse() {
        property.addHouse();
        assertEquals(1, property.getHouses());
        property.addHouse();
        assertEquals(2, property.getHouses());
        property.addHouse();
        assertEquals(3, property.getHouses());
        property.addHouse();
        assertEquals(4, property.getHouses());
    }

    @Test
    public void testAddHotel() {
        property.addHouse();
        property.addHouse();
        property.addHouse();
        property.addHouse();
        property.addHotel();
        assertEquals(0, property.getHouses());
        assertTrue(property.hasHotel());
    }
}