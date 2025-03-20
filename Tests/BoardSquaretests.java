import Model.BoardSquare;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardSquaretests {

    private BoardSquare boardSquare;

    @BeforeEach
    public void setUp() {
        boardSquare = new BoardSquare("Go", 0);
    }

    /**
     * Test to verify the name of the board square.
     */
    @Test
    public void testGetName() {
        assertEquals("Go", boardSquare.getName());
    }

    /**
     * Test to verify the position of the board square.
     */
    @Test
    public void testGetPosition() {
        assertEquals(0, boardSquare.getPosition());
    }

    /**
     * Test to verify setting a new name for the board square.
     */
    @Test
    public void testSetName() {
        boardSquare.setSpaceName("Boardwalk");
        assertEquals("Boardwalk", boardSquare.getName());
    }

    /**
     * Test to verify setting a new position for the board square.
     */
    @Test
    public void testSetPosition() {
        boardSquare.setSpacePosition(39);
        assertEquals(39, boardSquare.getPosition());
    }
}