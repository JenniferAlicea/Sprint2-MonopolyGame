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

    public Railroad(String name, int rent, int mortgageValue, int position, int twoRailroadRent, int threeRailroadRent, int fourRailroadRent) {
        super(name, position);
        cost = 200;
        this.rent = rent;
        this.twoRailroadRent = twoRailroadRent;
        this.threeRailroadRent = threeRailroadRent;
        this.fourRailroadRent = fourRailroadRent;
        this.mortgageValue = mortgageValue;

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

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }
}