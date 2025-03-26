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

    public void auctionProperty(BoardSquare property) {
        // Auction logic to be implemented
        System.out.println("Auctioning property: " + property.getName());
    }

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

    public void paySalary(Player player) {
        updateBalance(player, 200, "Passed GO");
    }

    public void sellHouse(Player player) {
        if (houses > 0) {
            houses--;
            // House cost logic would be handled in GameState
            System.out.println("House sold to " + player.getName() + ". " + houses + " houses left.");
        } else {
            System.out.println("No houses available for sale.");
        }
    }

    public void sellHotel(Player player) {
        if (hotels > 0) {
            hotels--;
            // Hotel cost logic would be handled in GameState
            System.out.println("Hotel sold to " + player.getName() + ". " + hotels + " hotels left.");
        } else {
            System.out.println("No hotels available for sale.");
        }
    }

    public void loanMoney(Player player, int amount) {
        updateBalance(player, amount, "Bank loan");
    }

    public void collectMortgage(Player player, Property property) {
        updateBalance(player, property.getMortgageValue(), "Mortgage: " + property.getName());
    }

    public int getHousesAvailable() {
        return houses;
    }

    public int getHotelsAvailable() {
        return hotels;
    }

    public void buyBackHouse() {
        houses++;
    }

    public void buyBackHotel() {
        hotels++;
    }
}