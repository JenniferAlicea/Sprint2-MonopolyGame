/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;


import java.awt.*;

public class TitleDeedCard {
    private String name;
    private Color color;
    private int cost;
    private int rent;
    private int monopolyRent;
    private int withOneHouse;
    private int withTwoHouses;
    private int withThreeHouses;
    private int withFourHouses;
    private int withHotel;
    private int monopolyHouseCost;
    private int monopolyHotelCost;
    private int mortgageValue;



    /**
     * Constructor for the TitleDeedCard class
     * @param name
     * @param color
     * @param cost
     * @param rent
     * @param monopolyRent
     * @param withOneHouse
     * @param withTwoHouses
     * @param withThreeHouses
     * @param withFourHouses
     * @param withHotel
     * @param monopolyHouseCost
     * @param monopolyHotelCost
     * @param mortgageValue
     */
    public TitleDeedCard(String name, Color color,int cost, int rent, int monopolyRent, int withOneHouse, int withTwoHouses, int withThreeHouses, int withFourHouses, int withHotel, int monopolyHouseCost, int monopolyHotelCost, int mortgageValue) {
        this.name = name;
        this.color = color;
        this.cost = cost;
        this.rent = rent;
        this.monopolyRent = monopolyRent;
        this.withOneHouse = withOneHouse;
        this.withTwoHouses = withTwoHouses;
        this.withThreeHouses = withThreeHouses;
        this.withFourHouses = withFourHouses;
        this.withHotel = withHotel;
        this.monopolyHouseCost = monopolyHouseCost;
        this.monopolyHotelCost = monopolyHotelCost;
        this.mortgageValue = mortgageValue;
    }


    /**
     * This method returns the name of the property
     * @return the name of the property
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the color of the property
     * @return the color of the property
     */
    public Color getColor() {
        return color;
    }

    /**
     * This method returns the rent of the property
     * @return the rent of the property
     */
    public int getRent() {
        return rent;
    }

    /**
     * This method returns the cost of the property
     * @return the cost of the property
     */
    public int getCost() {
        return cost;
    }

    /**
     * This method returns the rent of the property with one house
     * @return the rent of the property with one house
     */
    public int getWithOneHouse() {
        return withOneHouse;
    }

    /**
     * This method returns the rent of the property with two houses
     * @return the rent of the property with two houses
     */
    public int getWithTwoHouses() {
        return withTwoHouses;
    }

    /**
     * This method returns the rent of the property with three houses
     * @return the rent of the property with three houses
     */
    public int getWithThreeHouses() {
        return withThreeHouses;
    }

    /**
     * This method returns the rent of the property with four houses
     * @return the rent of the property with four houses
     */
    public int getWithFourHouses() {
        return withFourHouses;
    }

    /**
     * This method returns the rent of the property with a hotel
     * @return the rent of the property with a hotel
     */
    public int getWithHotel() {
        return withHotel;
    }

    /**
     * This method returns the rent of the property when the player has a monopoly
     * @return the rent of the property when the player has a monopoly
     */
    public int getMonopolyRent() {
        return monopolyRent;
    }
    /**
     * This method returns the cost of a house on the property
     * @return the cost of a house on the property
     */
    public int getMonopolyHouseCost() {
        return monopolyHouseCost;
    }

    /**
     * This method returns the cost of a hotel on the property
     * @return the cost of a hotel on the property
     */
    public int getMonopolyHotelCost() {
        return monopolyHotelCost;
    }

    /**
     * This method returns the mortgage value of the property
     * @return the mortgage value of the property
     */
    public int getMortgageValue() {
        return mortgageValue;
    }



}
