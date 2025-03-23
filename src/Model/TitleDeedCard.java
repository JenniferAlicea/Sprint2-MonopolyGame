package Model;


import java.awt.*;

public class TitleDeedCard {
    private String name;
    private Color color;
    private int cost;
    private int rent;
    private int withOneHouse;
    private int withTwoHouses;
    private int withThreeHouses;
    private int withFourHouses;
    private int withHotel;
    private int monopolyHouseCost;
    private int monopolyHotelCost;
    private int mortgageValue;




    public TitleDeedCard(String name, Color color,int cost, int rent, int withOneHouse, int withTwoHouses, int withThreeHouses, int withFourHouses, int withHotel, int monopolyHouseCost, int monopolyHotelCost, int mortgageValue) {
        this.name = name;
        this.color = color;
        this.cost = cost;
        this.rent = rent;
        this.withOneHouse = withOneHouse;
        this.withTwoHouses = withTwoHouses;
        this.withThreeHouses = withThreeHouses;
        this.withFourHouses = withFourHouses;
        this.withHotel = withHotel;
        this.monopolyHouseCost = monopolyHouseCost;
        this.monopolyHotelCost = monopolyHotelCost;
        this.mortgageValue = mortgageValue;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getRent() {
        return rent;
    }

    public int getWithOneHouse() {
        return withOneHouse;
    }

    public int getWithTwoHouses() {
        return withTwoHouses;
    }

    public int getWithThreeHouses() {
        return withThreeHouses;
    }

    public int getWithFourHouses() {
        return withFourHouses;
    }

    public int getWithHotel() {
        return withHotel;
    }

    public int getMonopolyHouseCost() {
        return monopolyHouseCost;
    }

    public int getMonopolyHotelCost() {
        return monopolyHotelCost;
    }

    public int getMortgageValue() {
        return mortgageValue;
    }



}
