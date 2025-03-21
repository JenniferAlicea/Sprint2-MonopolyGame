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
    private int position;

    public Utility(String name, int rent, int mortgageValue, int position) {
        super(name, position);
        this.rent = rent;
        this.mortgageValue = mortgageValue;
    }

    public int getRent() {
        return rent;
    }

    public int getMortgageValue() {
        return mortgageValue;
    }

}