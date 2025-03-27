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

}