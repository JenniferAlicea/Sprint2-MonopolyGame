/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

import Exceptions.IllegalArgumentException;

import java.awt.*;

public class Property extends BoardSquare {
    private Color color;
    private TitleDeedCard titleDeedCard;
    private int monopolyHouses;
    private boolean monopolyHotel;


    /**
     * Constructor for the Property class
     *
     * @param name  the name of the property
     * @param color the color of the property
     */
    public Property(String name, Color color, TitleDeedCard titleDeedCard, int position){
            super(name, position);
            this.color = color;
            this.titleDeedCard = titleDeedCard;
            this.monopolyHouses = 0;
            this.monopolyHotel = false;
        }


    public Color getColor() {
        return color;
    }

    public void buildMonopolyHouses(){
        try {
            if (monopolyHouses < 4) {
                monopolyHouses++;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("You cannot build more than 4 houses on a property");
        }
    }

    public void buildMonopolyHotel(){
        try {
            if (monopolyHouses == 4) {
                monopolyHotel = true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("You cannot build a hotel on a property without 4 houses");
        }
    }

    public int getMonopolyHouses() {
        return monopolyHouses;
    }

    public boolean hasMonopolyHotel() {
        return monopolyHotel;
    }

    public TitleDeedCard getTitleDeedCard() {
        return titleDeedCard;

    }

    public int getRent() {
        return titleDeedCard.getRent();
    }

    public int getCost() {
        return titleDeedCard.getCost();
    }



    /**
     * returns the mortgage value of the property
     * @return the mortgage value of the property
     */
    public int getMortgageValue() {
        return titleDeedCard.getMortgageValue();
    }
}







