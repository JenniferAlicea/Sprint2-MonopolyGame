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
    private int rent;
    private int mortgageValue;
    private int position;
    public Railroad(String name, int rent, int mortgageValue, int position) {
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