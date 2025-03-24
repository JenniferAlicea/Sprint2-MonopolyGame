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
    private int position;
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

}