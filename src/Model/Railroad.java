/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

public class Railroad extends BoardSquare {
    /**
     * Constructor for the Railroad class
     * @param name the name of the railroad
     */
    private int cost;
    private int rent;
    private int twoRailroadRent;
    private int threeRailroadRent;
    private int fourRailroadRent;
    private int mortgageValue;


    /**
     * Constructor for the Railroad class
     * @param name
     * @param rent
     * @param mortgageValue
     * @param position
     * @param twoRailroadRent
     * @param threeRailroadRent
     * @param fourRailroadRent
     */
    public Railroad(String name, int rent, int mortgageValue, int position, int twoRailroadRent, int threeRailroadRent, int fourRailroadRent) {
        super(name, position);
        cost = 200;
        this.rent = rent;
        this.twoRailroadRent = twoRailroadRent;
        this.threeRailroadRent = threeRailroadRent;
        this.fourRailroadRent = fourRailroadRent;
        this.mortgageValue = mortgageValue;

    }



    /**
     * This method returns the rent of the railroad
     * @return the rent of the railroad
     */
    public int getRent() {
        return rent;
    }

    /**
     * This method returns the mortgage value of the railroad
     * @return the mortgage value of the railroad
     */
    public int getMortgageValue() {
        return mortgageValue;
    }

    /**
     * This method returns the cost of the railroad
     * @return the cost of the railroad
     */
    public int getCost() {
        return cost;
    }

    /**
     * This method is called when a player lands on this square
     * @param player the player that landed on this square
     * @param gameState the current state of the game
     */
    @Override
    public void landedOn(Player player, GameState gameState) {

        int numRailroadsOwned = player.getOwnedRailroads().size();
        int rentOwed = 0;
        if (numRailroadsOwned == 1) {
            rentOwed = rent;
        } else if (numRailroadsOwned == 2) {
            rentOwed = twoRailroadRent;
        } else if (numRailroadsOwned == 3) {
            rentOwed = threeRailroadRent;
        } else if (numRailroadsOwned == 4) {
            rentOwed = fourRailroadRent;
        }
        player.updateBalance(-rentOwed);
        gameState.getBank().updateBalance(player, rentOwed, "Railroad rent");
    }

    /**
     * This method sets the owner of the railroad
     * @param owner the player that owns the railroad
     */
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    /**
     * This method returns the owner of the railroad
     * @return the owner of the railroad
     */
    public Player getOwner() {
        return owner;
    }
}