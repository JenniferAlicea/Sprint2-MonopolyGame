/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

import java.awt.*;

public class Property extends BoardSquare {
    private TitleDeedCard titleDeed;
    private Color color;
    private Player owner;
    private boolean mortgaged;
    private int houses;
    private boolean hasHotel;

    /**
     * This constructor creates a new Property object
     * @param name
     * @param color
     * @param titleDeed
     * @param position
     */
    public Property(String name, Color color, TitleDeedCard titleDeed, int position) {
        super(name, position);
        this.color = color;
        this.titleDeed = titleDeed;
        this.mortgaged = false;
        this.houses = 0;
        this.hasHotel = false;
    }
    /**
     * This method is called when a player lands on this square
     * @param player the player that landed on this square
     * @param gameState the current state of the game
     */
    @Override
    public void landedOn(Player player, GameState gameState) {
        if (owner == null) {
            // Property can be purchased
            gameState.offerPropertyPurchase(this);
        } else if (owner != player && !mortgaged) {
            // Pay rent to owner
            int rent = calculateRent();
            player.updateBalance(-rent);
            owner.updateBalance(rent);
        }
    }
    /**
     * This method calculates the rent for a property
     * @return the rent for the property
     */
    public int calculateRent() {
        if (mortgaged) {
            return 0;
        }
        
        if (hasHotel) {
            return titleDeed.getWithHotel();
        }
        
        switch (houses) {
            case 1: return titleDeed.getWithOneHouse();
            case 2: return titleDeed.getWithTwoHouses();
            case 3: return titleDeed.getWithThreeHouses();
            case 4: return titleDeed.getWithFourHouses();
            default: 
                if (owner != null && owner.getMonopolies().get(color)) {
                    return titleDeed.getMonopolyRent();
                }
                return titleDeed.getRent();
        }
    }

    /**
     * This method gets the owner of the property
     * @return player that owns the property
     */
    @Override
    public Player getOwner() {
        return owner;
    }
    /**
     * This method sets the owner of the property
     * @param player the player that owns the property
     */
    public void setOwner(Player player) {
        this.owner = player;
    }

    /**
     * this method returns whether the property is mortgaged or not
     * @return whether the property is mortgaged or not
     */
    public boolean isMortgaged() {
        return mortgaged;
    }
    /**
     * this method sets whether the property is mortgaged or not
     * @param mortgaged whether the property is mortgaged or not
     */
    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
    }

    /**
     * This method returns the mortgage value of the property
     * @return the mortgage value of the property
     */
    public int getMortgageValue() {
        return titleDeed.getMortgageValue();
    }

    /**
     * This method returns the cost of the property
     * @return the cost of the property
     */
    public int getPrice() {
        return titleDeed.getCost();
    }

    /**
     * this method returns the color of the property
     * @return the color of the property
     */
    public Color getColor() {
        return color;
    }

    /**
     * This method returns the number of houses on the property
     * @return the number of houses on the property
     */
    public int getHouses() {
        return houses;
    }

    /**
     * this method adds a house to the property if possible
     */
    public void addHouse() {
        if (houses < 4) houses++;
    }

    /**
     * this method adds a hotel to the property if possible
     */
    public void addHotel() {
        if (houses == 4) {
            houses = 0;
            hasHotel = true;
        }
    }

    /**
     * this method returns the color group of the property
     */
    public String getGroup() {
        return color.toString();
    }
}