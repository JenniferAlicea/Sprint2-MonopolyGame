package Model;


import java.awt.*;

public class TitleDeedCard {
    private String name;
    private Color color;
    private int rent;
    private int monopolyHouseCost;
    private int monopolyHotelCost;
    private int mortgageValue;
    private int unmortgageValue;

    public TitleDeedCard(String name, Color color, int rent, int monopolyHouseCost, int monopolyHotelCost, int mortgageValue) {
        this.name = name;
        this.color = color;
        this.rent = rent;
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

    public int getMonopolyHouseCost() {
        return monopolyHouseCost;
    }

    public int getMonopolyHotelCost() {
        return monopolyHotelCost;
    }

    public int getMortgageValue() {
        return mortgageValue;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public void setMonopolyHouseCost(int monopolyHouseCost) {
        this.monopolyHouseCost = monopolyHouseCost;
    }

    public void setMonopolyHotelCost(int monopolyHotelCost) {
        this.monopolyHotelCost = monopolyHotelCost;
    }

    public void setMortgageValue(int mortgageValue) {
        this.mortgageValue = mortgageValue;
    }

    public void setUnmortgageValue(int unmortgageValue) {
        this.unmortgageValue = unmortgageValue;
    }

    public int getUnmortgageValue() {
        return unmortgageValue;
    }


}
