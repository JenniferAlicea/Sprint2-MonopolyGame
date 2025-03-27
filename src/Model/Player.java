/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;


import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Player {

    private String name;
    private Token token;
    private int balance;
    private int boardPosition;
    private List<Property> mortgagedProperties;
    private List<Property> ownedProperties;
    private List<Railroad> ownedRailroads;
    private List<Railroad> mortgagedRailroads;
    private List<Utility> ownedUtilities;
    private List<Utility> mortgagedUtilities;
    private List<Player> monopolyPlayers;
    public HashMap<Color, Boolean> monopolies;
    public Color Brown = new Color(58, 6, 6);
    public Color LightBlue = new Color(3, 255, 255);
    public Color DarkBlue = new Color(16, 41, 166);

    /**
     * Constructor for the Player class
     *
     * @param name    the name of the player
     * @param balance the initial balance of the player
     */
    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.boardPosition = Token.getBoardPosition();
        this.token = Token.assignToPlayer(this, TokenIcons.values()[0]);
        this.mortgagedProperties = new ArrayList<>();
        this.ownedProperties = new ArrayList<>();
        this.mortgagedRailroads = new ArrayList<>();
        this.ownedRailroads = new ArrayList<>();
        this.mortgagedUtilities = new ArrayList<>();
        this.ownedUtilities = new ArrayList<>();
        this.monopolyPlayers = new ArrayList<>();
        this.monopolies = new HashMap<>();
        monopolies.put(LightBlue, false);
        monopolies.put(Brown, false);
        monopolies.put(Color.PINK, false);
        monopolies.put(Color.ORANGE, false);
        monopolies.put(Color.RED, false);
        monopolies.put(Color.YELLOW, false);
        monopolies.put(Color.GREEN, false);
        monopolies.put(DarkBlue, false);


    }


    /**
     * check if a player has a monopoly from the properties they own
     */
    public void checkMonopoly() {
        int lightBlueCount = 0;
        int brownCount = 0;
        int pinkCount = 0;
        int orangeCount = 0;
        int redCount = 0;
        int yellowCount = 0;
        int greenCount = 0;
        int darkBlueCount = 0;

        for (Property property : ownedProperties) {

            if (property.getColor().equals(LightBlue)) {
                lightBlueCount++;
            }
            if (property.getColor().equals(Brown)) {
                brownCount++;
            }
            if (property.getColor().equals(Color.PINK)) {
                pinkCount++;
            }
            if (property.getColor().equals(Color.ORANGE)) {
                orangeCount++;
            }
            if (property.getColor().equals(Color.RED)) {
                redCount++;
            }
            if (property.getColor().equals(Color.YELLOW)) {
                yellowCount++;
            }
            if (property.getColor().equals(Color.GREEN)) {
                greenCount++;
            }
            if (property.getColor().equals(DarkBlue)) {
                darkBlueCount++;
            }

        }

        if (lightBlueCount == 3) {
            monopolies.put(LightBlue, true);
        }
        if (brownCount == 2) {
            monopolies.put(Brown, true);
        }
        if (pinkCount == 3) {
            monopolies.put(Color.PINK, true);
        }
        if (orangeCount == 3) {
            monopolies.put(Color.ORANGE, true);
        }
        if (redCount == 3) {
            monopolies.put(Color.RED, true);
        }
        if (yellowCount == 3) {
            monopolies.put(Color.YELLOW, true);
        }
        if (greenCount == 3) {
            monopolies.put(Color.GREEN, true);
        }
        if (darkBlueCount == 2) {
            monopolies.put(DarkBlue, true);
        }

    }

    /**
     * Gets the Board Position of the player
     *
     * @return the Position of the player
     */
    public int getBoardPosition() {
        return boardPosition;
    }

    /**
     * Sets the Board Position of the player
     *
     * @param boardPosition the position to set
     */
    public void setBoardPosition(int boardPosition) {
        this.boardPosition = boardPosition;
    }


    /**
     * Gets the token for the player
     *
     * @return token
     */
    public Token getToken() {
        return token;
    }

    /**
     * Sets the token to the player
     *
     * @param token the token to set
     */
    public void setToken(Token token) {
        this.token = token;
    }




    /**
     * Updates the player's balance by a specified amount
     *
     * @param amount the amount to update the balance by
     */
    public void updateBalance(int amount) {
        this.balance += amount;
    }

    /**
     * Gets the player's current balance
     *
     * @return the player's balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Deposits a specified amount to the player's balance
     *
     * @param amount the amount to deposit
     */
    public void deposit(int amount) {
        balance += amount;
    }

    /**
     * Withdraws a specified amount from the player's balance
     *
     * @param amount the amount to withdraw
     */
    public void withdraw(int amount) {
        balance -= amount;
    }


    public void mortgageProperty(Property property) {
        if (ownedProperties.contains(property) && !mortgagedProperties.contains(property)) {
            mortgagedProperties.add(property);
            ownedProperties.remove(property);
            updateBalance(property.getMortgageValue());
        }
    }

    /**
     * Unmortgages a property for the player
     *
     * @param property the property to unmortgage
     */
    public void unmortgageProperty(Property property) {
        mortgagedProperties.remove(property);
    }

    /**
     * Gets the list of mortgaged properties for the player
     *
     * @return the list of mortgaged properties
     */
    public List<Property> getMortgagedProperties() {
        return mortgagedProperties;
    }

    /**
     * Gets the list of owned properties for the player
     *
     * @return the list of owned properties
     */
    public List<Property> getOwnedProperties() {
        return ownedProperties;
    }

    /**
     * Gets the list of owned railroads for the player
     *
     * @return the list of owned railroads
     */

    public List<Railroad> getOwnedRailroads() {
        return ownedRailroads;

    }



    /**
     * Gets the list of owned utilities for the player
     *
     * @return the list of owned utilities
     */

    public List<Utility> getOwnedUtilities() {
        return ownedUtilities;
    }

    /**
     * Gets the name of the player
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Get the monopolies a player has
     */
    public HashMap<Color, Boolean> getMonopolies() {
        return monopolies;
    }

    /**
     * Moves the player by a specified number of spaces
     * @param spaces the number of spaces to move
     * @return true if the player passed Go during this move
     */
    public boolean move(int spaces) {
        int oldPosition = this.boardPosition;
        this.boardPosition = (oldPosition + spaces) % 40;

        return oldPosition + spaces >= 40;
    }
}