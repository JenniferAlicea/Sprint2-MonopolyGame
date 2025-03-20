/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
import Model.Player;
import Model.Token;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Model.TokenIcons;

public class TokenTests {
    private Token token;
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("TestPlayer", 1500);
        token = new Token(TokenIcons.BOOT, player);
    }

    @Test
    void assignToPlayerSetsOwner() {
        Player newPlayer = new Player("NewPlayer", 1500);
        token.assignToPlayer(newPlayer);
        assertEquals(newPlayer, token.getOwner());
    }



    @Test
    void setBoardPositionUpdatesPosition() {
        int newPosition = 5;
        token.setBoardPosition(newPosition);
        assertEquals(newPosition, Token.getBoardPosition());
    }

    @Test
    void getTypeReturnsCorrectType() {
        assertEquals(TokenIcons.BOOT, token.getType());
    }
}