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


    /**
     * Constructor for the Utility class
     * @param name
     * @param rent
     * @param mortgageValue
     * @param position
     * @param isAllOwned
     */
    public Utility(String name, int rent, int mortgageValue, int position, boolean isAllOwned) {
        super(name, position);
        this.rent = rent;
        this.mortgageValue = mortgageValue;
        this.cost = 150;
        this.owner = null;
    }

    /**
     * This method returns the rent of the utility
     * @return the rent of the utility
     */
    public int getRent() {
        return rent;
    }

    /**
     * This method returns the mortgage value of the utility
     * @return the mortgage value of the utility
     */
    public int getMortgageValue() {
        return mortgageValue;
    }

    /**
     * This method returns the cost of the utility
     * @return the cost of the utility
     */
    public int getCost() {
        return cost;
    }


    /**
     * This method returns the owner of the utility
     * @return the owner of the utility
     */
    public Player getOwner() {
        return owner;
    }
    /**
     * This method sets the owner of the utility
     * @param player the player that owns the utility
     */
    public void setOwner(Player player) {
        this.owner = player;

    }


    /**
     * this method runs the logic for when a player lands on a utility
     * @param player the player that landed on the utility
     * @param gameState the current state of the game
     */
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