import Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

public class BoardSquaretests {

    private BoardSquare goSpace;
    private Property property;
    private Railroad railroad;
    private Utility utility;
    private TitleDeedCard titleDeedCard;
    private Color DarkBlue;

    @BeforeEach
    public void setUp() {
        DarkBlue = new Color(0, 0, 139);
        titleDeedCard = new TitleDeedCard("Boardwalk", DarkBlue, 50, 200, 50, 100, 150, 200, 250, 300, 350, 400, 200);
        goSpace = new GoSpace("Go", 0);
        property = new Property("Boardwalk", Color.BLUE, new TitleDeedCard("Boardwalk", DarkBlue,
                400, 50, 100, 200, 600, 1400,
                1700, 2000, 200, 200, 200), 39);
        railroad = new Railroad("Reading Railroad", 25, 100, 5, 50, 100, 200);
        utility = new Utility("Electric Company", 12, 150, 75, false);
    }

    @Test
    public void testGetName() {
        assertEquals("Go", goSpace.getName());
        assertEquals("Boardwalk", property.getName());
        assertEquals("Reading Railroad", railroad.getName());
        assertEquals("Electric Company", utility.getName());
    }

    @Test
    public void testGetPosition() {
        assertEquals(0, goSpace.getPosition());
        assertEquals(39, property.getPosition());
        assertEquals(5, railroad.getPosition());
        assertEquals(75, utility.getPosition());
    }

    @Test
    public void testPropertyAttributes() {
        assertEquals("Boardwalk", property.getName());
        assertEquals(Color.BLUE, property.getColor());
        assertEquals(50, titleDeedCard.getCost());
        assertEquals(200, titleDeedCard.getRent());
        assertEquals(100, titleDeedCard.getWithOneHouse());
        assertEquals(150, titleDeedCard.getWithTwoHouses());
        assertEquals(200, titleDeedCard.getWithThreeHouses());
        assertEquals(250, titleDeedCard.getWithFourHouses());
        assertEquals(300, titleDeedCard.getWithHotel());
        assertEquals(50, titleDeedCard.getMonopolyRent());
        assertEquals(200, titleDeedCard.getRent());



    }

    @Test
    public void testRailroadAttributes() {
        assertEquals(200, railroad.getCost());
        assertEquals(25, railroad.getRent());
    }

    @Test
    public void testUtilityAttributes() {
        assertEquals(150, utility.getCost());
        assertEquals(12, utility.getRent());
    }
}