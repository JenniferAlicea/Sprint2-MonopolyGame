/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
import Model.BoardSquare;
import Model.GoSpace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardSquaretests {

    private BoardSquare boardSquare;

    @BeforeEach
    public void setUp() {
        boardSquare = new GoSpace("Go", 0);
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

    }


