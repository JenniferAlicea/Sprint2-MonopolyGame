/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

public class GoSpace extends BoardSquare {
    public static final int GO_MONEY = 200;
    private int goMoney = GO_MONEY;

    /**
     * Constructor for the GoSpace class
     * @param go
     * @param i
     */
    public GoSpace(String go, int i) {
        super(go, i);
        goMoney = 200;
    }

    /**
     * This method is called when a player lands on this square
     * @param player the player that landed on this square
     * @param gameState the current state of the game
     */
    @Override
    public void landedOn(Player player, GameState gameState) {
        player.updateBalance(goMoney);
    }

    /**
     * This method returns the amount of money a player receives for landing on Go
     * @return the amount of money a player receives for landing on Go
     */
    public int getGoMoney() {
        return goMoney;
    }
}