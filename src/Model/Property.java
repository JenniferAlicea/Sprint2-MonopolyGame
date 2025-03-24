/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

import java.awt.*;

public class Property extends BoardSquare {
    private Color color;
    private TitleDeedCard titleDeedCard;


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
        }


    public Color getColor() {
        return color;
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







