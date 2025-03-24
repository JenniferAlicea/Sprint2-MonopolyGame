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


    public Utility(String name, int rent, int mortgageValue, int position, boolean isAllOwned) {
        super(name, position);
        this.rent = rent;
        this.mortgageValue = mortgageValue;
        this.cost = 150;
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