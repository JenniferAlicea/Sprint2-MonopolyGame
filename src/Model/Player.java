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
     * @param name the name of the player
     * @param balance the initial balance of the player
     */
    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.boardPosition = Token.getBoardPosition();
        this.token = Token.assignToPlayer(this);
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

    public void setMonopolyPlayers(List<Player> monopolyPlayers) {
        this.monopolyPlayers = monopolyPlayers;
    }

    public List<Player> getMonopolyPlayers() {
        return monopolyPlayers;
    }

    /**
     * check if a player has a monopoly from the properties they own
     */
    public void checkMonopoly () {
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
     * @return the Position of the player
     */
    public int getBoardPosition() {
        return boardPosition;
    }

    /**
     * Sets the Board Position of the player
     * @param boardPosition the position to set
     */
    public void setBoardPosition(int boardPosition) {
        this.boardPosition = boardPosition;
    }


    /**
     * Gets the token for the player
     * @return token
     */
    public Token getToken() {
        return token;
    }

    /**
     * Sets the token to the player
     * @param token the token to set
     */
    public void setToken(Token token) {
        this.token = token;
    }


    /**
     * Updates the player's balance by a specified amount
     * @param amount the amount to update the balance by
     */
    public void updateBalance(int amount) {
        this.balance += amount;
    }

    /**
     * Gets the player's current balance
     * @return the player's balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Deposits a specified amount to the player's balance
     * @param amount the amount to deposit
     */
    public void deposit(int amount) {
        balance += amount;
    }

    /**
     * Withdraws a specified amount from the player's balance
     * @param amount the amount to withdraw
     */
    public void withdraw(int amount) {
        balance -= amount;
    }

    /**
     * Buys a property for the player
     * @param titleDeedCards the property to buy
     */
    public void buyProperty(Property titleDeedCards) {
        if (balance >= titleDeedCards.getCost()) {
            ownedProperties.add(titleDeedCards);
            updateBalance(-titleDeedCards.getCost());
        }
    }

    /**
     * Buys a railroad for the player
     * @param railroad the railroad to buy
     */
    public void buyRailroad(Railroad railroad) {
        if (balance >= railroad.getCost()) {
            ownedRailroads.add(railroad);
            updateBalance(-railroad.getCost());
        }

    }

    /**
     * Buys a utility for the player
     * @param utility the utility to buy
     */

    public void buyUtility(Utility utility) {
        if (balance >= utility.getCost()) {
            ownedUtilities.add(utility);
            updateBalance(-utility.getCost());
        }
    }
    /**
     * Pays rent to another player
     * @param owner the owner of the property
     * @param titleDeedCards the property for which rent is being paid
     */
    public void payRentProperty(Player owner, Property titleDeedCards) {
        updateBalance(-titleDeedCards.getRent());
        owner.updateBalance(titleDeedCards.getRent());
    }

    /**
     * Pays rent to another player
     * @param owner the owner of the property
     * @param railroad the railroad for which rent is being paid
     */
    public void payRentRailroad(Player owner, Railroad railroad) {
        updateBalance(-railroad.getRent());
        owner.updateBalance(railroad.getRent());
    }

    /**
     * Pays rent to another player
     * @param owner the owner of the property
     * @param utility the utility for which rent is being paid
     */
    public void payRentUtility(Player owner, Utility utility) {
        updateBalance(-utility.getRent());
        owner.updateBalance(utility.getRent());
    }


    /**
     * Mortgages a property for the player
     * @param property the property to mortgage
     */
    public void mortgageProperty(Property property) {
        if (ownedProperties.contains(property) && !mortgagedProperties.contains(property)) {
            mortgagedProperties.add(property);
            ownedProperties.remove(property);
            updateBalance(property.getMortgageValue());
        }
    }

    /**
     * Unmortgages a property for the player
     * @param property the property to unmortgage
     */
    public void unmortgageProperty(Property property) {
        mortgagedProperties.remove(property);
    }


    /**
     * Mortgages a railroad for the player
     * @param railroad the railroad to mortgage
     */
    public void mortgageRailroad(Railroad railroad) {
        if (ownedRailroads.contains(railroad) && !mortgagedRailroads.contains(railroad)) {
            mortgagedRailroads.add(railroad);
            ownedRailroads.remove(railroad);
            updateBalance(railroad.getMortgageValue());
        }
    }

    /**
     * Unmortgages a railroad for the player
     * @param railroad the railroad to unmortgage
     */
    public void unmortgageRailroad(Railroad railroad) {
        mortgagedRailroads.remove(railroad);
    }

    /**
     * Mortgages a utility for the player
     * @param utility the utility to mortgage
     */
    public void mortgageUtility(Utility utility) {
        if (ownedUtilities.contains(utility) && !mortgagedUtilities.contains(utility)) {
            mortgagedUtilities.add(utility);
            ownedUtilities.remove(utility);
            updateBalance(utility.getMortgageValue());
        }
    }

    /**
     * Unmortgages a utility for the player
     * @param utility the utility to unmortgage
     */

    public void unmortgageUtility(Utility utility) {
        mortgagedUtilities.remove(utility);
    }

    /**
     * Checks if a mortgaged property is paid off
     * @param property the property to check
     * @return true if the property is paid off, false otherwise
     */
    public boolean isMortgagePropertyPaidOff(Property property) {
        return !mortgagedProperties.contains(property);
    }

    /**
     * Checks if a mortgaged railroad is paid off
     * @param railroad the railroad to check
     * @return true if the railroad is paid off, false otherwise
     */
    public boolean isMortgageRailroadPaidOff(Railroad railroad) {
        return !mortgagedRailroads.contains(railroad);
    }

    /**
     * Checks if a mortgaged utility is paid off
     * @param utility the utility to check
     * @return true if the utility is paid off, false otherwise
     */
    public boolean isMortgageUtilityPaidOff(Utility utility) {
        return !mortgagedUtilities.contains(utility);
    }


    /**
     * Gets the list of mortgaged properties for the player
     * @return the list of mortgaged properties
     */
    public List<Property> getMortgagedProperties() {
        return mortgagedProperties;
    }

    /**
     * Gets the list of owned properties for the player
     * @return the list of owned properties
     */
    public List<Property> getOwnedProperties() {
        return ownedProperties;
    }

    /**
     * Gets the list of mortgaged railroads for the player
     * @return the list of mortgaged railroads
     */

    public List<Railroad> getMortgagedRailroads() {
        return mortgagedRailroads;

    }

    /**
     * Gets the list of owned railroads for the player
     * @return the list of owned railroads
     */

    public List<Railroad> getOwnedRailroads() {
        return ownedRailroads;

    }

    /**
     * Gets the list of mortgaged utilities for the player
     * @return the list of mortgaged utilities
     */

    public List<Utility> getMortgagedUtilities() {
        return mortgagedUtilities;

    }

    /**
     * Gets the list of owned utilities for the player
     * @return the list of owned utilities
     */

    public List<Utility> getOwnedUtilities() {
        return ownedUtilities;
    }

    /**
     * Gets the name of the player
     * @return the name of the player
     */
    public String getName() {
        return name;
    }
}