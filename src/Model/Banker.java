/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

public class Banker {
    private TitleDeedCard[] titleDeedCards;
    private int houses = 32;
    private int hotels = 12;

    public Banker(TitleDeedCard[] titleDeedCards) {
        this.titleDeedCards = titleDeedCards;
    }

    /**
     * Updates the player's balance and performs banking operations
     *
     * @param player The player whose balance will be updated
     * @param amount The amount to add (positive) or deduct (negative)
     * @param reason Description of the transaction for logging purposes
     */
    public void updateBalance(Player player, int amount, String reason) {
        // Update the player's balance
        player.updateBalance(amount);

        // Log the transaction
        System.out.println(reason + ": " + player.getName() +
                (amount >= 0 ? " received $" : " paid $") +
                Math.abs(amount));
    }

    /**
     * Auctions a property to the players
     *
     * @param property The property to be auctioned
     */
    public void auctionProperty(BoardSquare property) {
        // Auction logic to be implemented
        System.out.println("Auctioning property: " + property.getName());
    }

    /**
     * Sells a property to a player
     *
     * @param property The property to be sold
     * @param player   The player who is buying the property
     */
    public void sellProperty(BoardSquare property, Player player) {
        if (property instanceof Property) {
            Property prop = (Property) property;
            updateBalance(player, -prop.getPrice(), "Property purchase: " + prop.getName());
        } else if (property instanceof Railroad) {
            Railroad railroad = (Railroad) property;
            updateBalance(player, -railroad.getCost(), "Railroad purchase: " + railroad.getName());
        } else if (property instanceof Utility) {
            Utility utility = (Utility) property;
            updateBalance(player, -utility.getCost(), "Utility purchase: " + utility.getName());
        }
    }

    /**
     * Pays the player a salary for passing GO
     *
     * @param player The player who passed GO
     */
    public void paySalary(Player player) {
        updateBalance(player, 200, "Passed GO");
    }

    /**
     * Sells a house to a player
     *
     * @param player The player who is buying the house
     */
    public void sellHouse(Player player) {
        if (houses > 0) {
            houses--;
            // House cost logic would be handled in GameState
            System.out.println("House sold to " + player.getName() + ". " + houses + " houses left.");
        } else {
            System.out.println("No houses available for sale.");
        }
    }

    /**
     * Sells a hotel to a player
     *
     * @param player The player who is buying the hotel
     */
    public void sellHotel(Player player) {
        if (hotels > 0) {
            hotels--;
            // Hotel cost logic would be handled in GameState
            System.out.println("Hotel sold to " + player.getName() + ". " + hotels + " hotels left.");
        } else {
            System.out.println("No hotels available for sale.");
        }
    }

    /**
     * Auctions a property to the players
     *
     * @param property  The property to be auctioned
     * @param gameState The current game state
     */
    public void auctionProperty(BoardSquare property, GameState gameState) {
        if (property instanceof Property || property instanceof Railroad || property instanceof Utility) {
            System.out.println("The banker is auctioning " + property.getName());
            gameState.startAuction(property);
        }
    }

    /**
     * Loans money to a player
     *
     * @param player The player who is receiving the loan
     * @param amount The amount of the loan
     */
    public void loanMoney(Player player, int amount) {
        updateBalance(player, amount, "Bank loan");
    }

    /**
     * Collects the mortgage from a player
     *
     * @param player   The player who is paying the mortgage
     * @param property The property being mortgaged
     */
    public void collectMortgage(Player player, Property property) {
        updateBalance(player, property.getMortgageValue(), "Mortgage: " + property.getName());
    }

    /**
     * Buys back a house from the bank
     */
    public int getHousesAvailable() {
        return houses;
    }

    /**
     * Buys back a hotel from the bank
     */
    public int getHotelsAvailable() {
        return hotels;
    }

    /**
     * Buys back a house from the bank
     */
    public void buyBackHouse() {
        houses++;
    }

    /**
     * Buys back a hotel from the bank
     */
    public void buyBackHotel() {
        hotels++;
    }
}