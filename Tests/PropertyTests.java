import Model.BoardSquare;
import Model.Property;
import Model.TitleDeedCard;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

public class PropertyTests {

    @Test
    public void testBuildMonopolyHouses() {
        Color DarkBlue = new Color(16, 41, 166);

        TitleDeedCard boardwalk = new TitleDeedCard("Boardwalk", DarkBlue, 400,
                50, 100, 200, 600,
                1400, 1700, 2000, 200, 200, 200);

        Property property = new Property("Boardwalk", DarkBlue, boardwalk, 1);

        property.buildMonopolyHouses();
        assertEquals(1, property.getMonopolyHouses());

        property.buildMonopolyHouses();
        property.buildMonopolyHouses();
        property.buildMonopolyHouses();
        assertEquals(4, property.getMonopolyHouses());

    }

    @Test
    public void testBuildMonopolyHotel() {
        Color DarkBlue = new Color(16, 41, 166);

        TitleDeedCard boardwalk = new TitleDeedCard("Boardwalk", DarkBlue, 400,
                50, 100, 200, 600,
                1400, 1700, 2000, 200, 200, 200);

        Property property = new Property("Boardwalk", DarkBlue, boardwalk, 1);

        property.buildMonopolyHouses();
        property.buildMonopolyHouses();
        property.buildMonopolyHouses();
        property.buildMonopolyHouses();
        assertEquals(4, property.getMonopolyHouses());

        property.buildMonopolyHotel();
        assertTrue(property.hasMonopolyHotel());


    }

    @Test
    public void testGetMortgageValue() {
        Color DarkBlue = new Color(16, 41, 166);

        TitleDeedCard boardwalk = new TitleDeedCard("Boardwalk", DarkBlue, 400,
                50, 100, 200, 600,
                1400, 1700, 2000, 200, 200, 200);

        Property property = new Property("Boardwalk", DarkBlue, boardwalk, 1);

        assertEquals(200, property.getMortgageValue());
    }

    @Test
    public void testGetRent() {
        Color DarkBlue = new Color(16, 41, 166);

        TitleDeedCard boardwalk = new TitleDeedCard("Boardwalk", DarkBlue, 400,
                50, 100, 200, 600,
                1400, 1700, 2000, 200, 200, 200);

        Property property = new Property("Boardwalk", DarkBlue, boardwalk, 1);

        assertEquals(50, property.getRent());
    }

    @Test
    public void testGetCost() {
        Color DarkBlue = new Color(16, 41, 166);

        TitleDeedCard boardwalk = new TitleDeedCard("Boardwalk", DarkBlue, 400,
                50, 100, 200, 600,
                1400, 1700, 2000, 200, 200, 200);

        Property property = new Property("Boardwalk", DarkBlue, boardwalk, 1);

        assertEquals(400, property.getCost());
    }

    @Test
    public void testExceptions(){
        Color DarkBlue = new Color(16, 41, 166);

        TitleDeedCard boardwalk = new TitleDeedCard("Boardwalk", DarkBlue, 400,
                50, 100, 200, 600,
                1400, 1700, 2000, 200, 200, 200);

        Property property = new Property("Boardwalk", DarkBlue, boardwalk, 1);

        try {
            property.buildMonopolyHouses();
            property.buildMonopolyHouses();
            property.buildMonopolyHouses();
            property.buildMonopolyHouses();
            property.buildMonopolyHouses();
        } catch (IllegalArgumentException e) {
            assertEquals("You cannot build more than 4 houses on a property", e.getMessage());
        }

        try {
            property.buildMonopolyHotel();
        } catch (IllegalArgumentException e) {
            assertEquals("You cannot build a hotel on a property without 4 houses", e.getMessage());
        }
    }
}