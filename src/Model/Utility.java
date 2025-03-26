/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

/**
 * Class to represent the Utility squares on the board
 */
public class Utility extends BoardSquare {
    private int rent;
    private int mortgageValue;
    private int cost;
    private Player owner;


    public Utility(String name, int rent, int mortgageValue, int position, boolean isAllOwned) {
        super(name, position);
        this.rent = rent;
        this.mortgageValue = mortgageValue;
        this.cost = 150;
        this.owner = null;
    }

    public int getRent() {
        return rent;
    }

    public int getMortgageValue() {
        return mortgageValue;
    }

    public int getCost() {
        return cost;
    }


    public Player getOwner() {
        return owner;
    }
    public Player setOwner(Player player) {
        this.owner = player;
        return player;
    }


    @Override
    public void landedOn(Player player, GameState gameState) {
        int diceRoll = Dice.roll();
        int numUtilitiesOwned = player.getOwnedUtilities().size();
        int rentOwed = 0;

        if (numUtilitiesOwned == 1) {
            rentOwed = diceRoll * 4;
        } else if (numUtilitiesOwned == 2) {
            rentOwed = diceRoll * 10;
        }

        player.updateBalance(-rentOwed);
        gameState.getBank().updateBalance(player, rentOwed, "Utility Rent");
    }
}