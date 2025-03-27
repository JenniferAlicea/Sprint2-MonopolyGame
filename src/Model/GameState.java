package Model;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private static final int MAX_PLAYERS = 4;
    private static final int MIN_PLAYERS = 2;
    private List<Player> players;
    private int currentPlayerIndex;
    private Banker banker;
    private Gameboard board;
    private TurnPhase currentPhase;
    private BoardSquare propertyUnderAuction;
    private int currentBid;
    private Player highestBidder;
    private boolean auctionInProgress = false;
    private List<Player> remainingBidders;
    private ChanceCards chanceDeck;
    private CommunityChestCards communityChestDeck;


    /**
     * Constructor for the GameState class
     */
    public GameState() {
        players = new ArrayList<>();
        currentPlayerIndex = 0;
        currentPhase = TurnPhase.ROLL_DICE;


    }

    /**
     * This method adds a player to the game
     * @param player the player to be added
     * @return true if the player was added, false otherwise
     */
    public boolean addPlayer(Player player) {
        if (players.size() < MAX_PLAYERS) {
            players.add(player);
            return true;
        } else {
            System.out.println("Cannot add more than " + MAX_PLAYERS + " players.");
            return false;
        }
    }

    /**
     * This method checks if the game can start
     * @return true if the game can start, false otherwise
     */
    public boolean canStartGame() {
        return players.size() >= MIN_PLAYERS;
    }

    /**
     * This method gets the current player
     * @return the current player
     */
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    /**
     * this method gets the next player in the list
     */
    public void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    /**
     * This method sets the current phase of the game
     * @param phase the phase to be set
     */
    public void setTurnPhase(TurnPhase phase) {
        currentPhase = phase;
    }

    /**
     * this method sets the chance deck
     */
    public void setChanceDeck(ChanceCards chanceDeck) {
        this.chanceDeck = chanceDeck;
    }
    /**
     * this method sets the community chest deck
     */
    public void setCommunityChestDeck(CommunityChestCards communityChestDeck) {
        this.communityChestDeck = communityChestDeck;
    }

    /**
     * this method returns the chance deck
     * @return the chance deck
     */
    public ChanceCards getChanceDeck() {
        return chanceDeck;
    }

    /**
     * this method returns the community chest deck
     * @return the community chest deck
     */
    public CommunityChestCards getCommunityChestDeck() {
        return communityChestDeck;
    }


    /**
     * This method sets the banker
     * @param banker
     */
    public void setBanker(Banker banker) {
        this.banker = banker;
    }

    /**
     * This method sets the game board
     * @param board
     */
    public void setBoard(Gameboard board) {
        this.board = board;
    }

    /**
     * this method rolls the dice
     * @return the total of the dice roll
     */
    // STEP 1: Roll Dice
    public int rollDice() {
        if (currentPhase != TurnPhase.ROLL_DICE) {
            throw new IllegalStateException("Not in dice rolling phase");
        }

        Dice.roll();
        int roll = Dice.getTotal();
        System.out.println(getCurrentPlayer().getName() + " rolled a " + roll);

        currentPhase = TurnPhase.MOVE_TOKEN;
        return roll;
    }

    /**
     * this method moves the token
     * @param spaces the number of spaces to move the token
     */
    // STEP 2: Move Token
    public void moveToken(int spaces) {
        if (currentPhase != TurnPhase.MOVE_TOKEN) {
            throw new IllegalStateException("Not in token moving phase");
        }

        Player currentPlayer = getCurrentPlayer();
        Token playerToken = currentPlayer.getToken();

        int currentPosition = playerToken.getBoardPosition();
        int newPosition = (currentPosition + spaces) % 40; // Assuming 40 spaces

        // Check if passing GO
        if (newPosition < currentPosition) {
            if (banker != null) {
                banker.paySalary(currentPlayer);
            } else {
                currentPlayer.updateBalance(200); // Default GO salary
            }
        }

        playerToken.setBoardPosition(newPosition);
        System.out.println(currentPlayer.getName() + " moved to position " + newPosition);

        currentPhase = TurnPhase.HANDLE_SQUARE_ACTION;
    }

    /**
     * this method handles the square action
     */
    // STEP 3: Handle Square Action
    public void handleSquareAction() {
        if (currentPhase != TurnPhase.HANDLE_SQUARE_ACTION) {
            throw new IllegalStateException("Not in square handling phase");
        }

        Player currentPlayer = getCurrentPlayer();
        int position = currentPlayer.getToken().getBoardPosition();
        BoardSquare square = board.getSquare(position);

        // Use the polymorphic landedOn method
        square.landedOn(currentPlayer, this);

        currentPhase = TurnPhase.PLAYER_ACTIONS;
    }

    /**
     * this method offers property purchase to the current player
     * @param property the property to be offered
     */
    // Offer property purchase to current player
    public void offerPropertyPurchase(Property property) {
        // This method would be expanded to interact with UI
        System.out.println(getCurrentPlayer().getName() + " can buy " + property.getName() + " for $" + property.getPrice());
        // Player can choose to buy via performAction(PlayerAction.BUY_PROPERTY, property)
        // Or auction via performAction(PlayerAction.AUCTION_PROPERTY, property)
    }

    /**
     * this method performs an action
     * @param action the action to be performed
     * @param params the parameters for the action
     */

    // STEP 4: Player Actions
    public void performAction(PlayerAction action, Object... params) {
        if (currentPhase != TurnPhase.PLAYER_ACTIONS) {
            throw new IllegalStateException("Not in player actions phase");
        }

        Player currentPlayer = getCurrentPlayer();

        switch (action) {
            case BUY_PROPERTY:
                if (params.length > 0 && params[0] instanceof Property) {
                    buyProperty(currentPlayer, (Property) params[0]);
                }
                break;
            case AUCTION_PROPERTY:
                if (params.length > 0 && params[0] instanceof Property) {
                    if (banker != null) {
                        banker.auctionProperty((Property) params[0]);
                    }
                }
                break;
            case BUILD_HOUSE:
                if (params.length > 0 && params[0] instanceof Property) {
                    buildHouse(currentPlayer, (Property) params[0]);
                }
                break;
            case BUILD_HOTEL:
                if (params.length > 0 && params[0] instanceof Property) {
                    buildHotel(currentPlayer, (Property) params[0]);
                }
                break;
            case MORTGAGE_PROPERTY:
                if (params.length > 0 && params[0] instanceof Property) {
                    mortgageProperty(currentPlayer, (Property) params[0]);
                }
                break;
            case UNMORTGAGE_PROPERTY:
                if (params.length > 0 && params[0] instanceof Property) {
                    unmortgageProperty(currentPlayer, (Property) params[0]);
                }
                break;
            case TRADE:
                if (params.length > 1 && params[0] instanceof Player && params[1] instanceof Property) {
                    trade(currentPlayer, (Player) params[0], (Property) params[1]);
                }
                break;
            case END_TURN:
                currentPhase = TurnPhase.END_TURN;
                break;
        }
    }

    /**
     * this method ends the turn
     */
    // STEP 5: End Turn
    public void endTurn() {
        if (currentPhase != TurnPhase.END_TURN) {
            throw new IllegalStateException("Not in end turn phase");
        }



        currentPhase = TurnPhase.ROLL_DICE;
        nextTurn();
    }

    /**
     * this method buys a property
     * @param player
     * @param property
     */
    // Action implementation methods
    private void buyProperty(Player player, Property property) {
        if (property.getOwner() == null && player.getBalance() >= property.getPrice()) {
            player.updateBalance(-property.getPrice());
            property.setOwner(player);
            player.getOwnedProperties().add(property);
            player.checkMonopoly();

            if (banker != null) {
                banker.sellProperty(property, player);
            }
        }
    }

    /**
     * this method builds a house
     * @param player
     * @param property
     */
    private void buildHouse(Player player, Property property) {
        if (property.getOwner() == player && player.getMonopolies().get(property.getColor())) {
            int houseCost = property.getPrice() / 2; // Simplified house cost
            if (player.getBalance() >= houseCost) {
                player.updateBalance(-houseCost);
                property.addHouse();

                if (banker != null) {
                    banker.sellHouse(player);
                }
            }
        }
    }
    /**
     * this method builds a hotel
     * @param player
     * @param property
     */
    private void buildHotel(Player player, Property property) {
        if (property.getOwner() == player && property.getHouses() == 4) {
            int hotelCost = property.getPrice() / 2; // Simplified hotel cost
            if (player.getBalance() >= hotelCost) {
                player.updateBalance(-hotelCost);
                property.addHotel();

                if (banker != null) {
                    banker.sellHotel(player);
                }
            }
        }
    }


    /**
     * this method mortgages a property
     * @param player
     * @param property
     */
    private void mortgageProperty(Player player, Property property) {
        if (property.getOwner() == player && !property.isMortgaged()) {
            property.setMortgaged(true);
            player.updateBalance(property.getMortgageValue());
            player.mortgageProperty(property);
        }
    }

    private void unmortgageProperty(Player player, Property property) {
        if (property.getOwner() == player && property.isMortgaged()) {
            int unmortgageAmount = (int) (property.getMortgageValue() * 1.1); // 10% interest
            if (player.getBalance() >= unmortgageAmount) {
                player.updateBalance(-unmortgageAmount);
                property.setMortgaged(false);
                player.unmortgageProperty(property);
            }
        }
    }

    /**
     * this method trades a property
     * @param player
     * @param otherPlayer
     * @param property
     */
    private void trade(Player player, Player otherPlayer, Property property) {
        // Trade logic would be implemented here
        // Simple version: if other player owns property, transfer it
        if (property.getOwner() == otherPlayer) {
            // This is just a placeholder for actual trading UI and logic
            property.setOwner(player);
            otherPlayer.getOwnedProperties().remove(property);
            player.getOwnedProperties().add(property);
            player.checkMonopoly();
            otherPlayer.checkMonopoly();
        }
    }

    /**
     * this method starts an auction
     * @param property
     */
    public void startAuction(BoardSquare property) {
        if (auctionInProgress) {
            return;
        }
        propertyUnderAuction = property;
        currentBid = 0;
        highestBidder = null;
        auctionInProgress = true;

        remainingBidders = new ArrayList<>(players);

        System.out.println("Auction started for " + property.getName());
        System.out.println("Starting bid is $" + currentBid);

        currentPhase = TurnPhase.AUCTION_PHASE;
    }


    /**
     * this method determines the turn order
     */
    public void firstRollForTurnOrder() {
        for (Player player : players) {
            Dice.roll();
            System.out.println("Player " + player.getName() + " rolled a " + Dice.getTotal());
        }
    }

    /**
     * this method places a bid for an auction
     * @param player
     * @param bidAmount
     */
    public void placeBid(Player player, int bidAmount) {
        if (!auctionInProgress || !remainingBidders.contains(player)) {
            return;
        }

        if (bidAmount <= currentBid) {
            System.out.println(player.getName() + " bid too low. Must be higher than $" + currentBid);
            return;
        }

        if (bidAmount > player.getBalance()) {
            System.out.println(player.getName() + " cannot afford this bid");
            return;
        }

        currentBid = bidAmount;
        highestBidder = player;
        System.out.println(player.getName() + " bids $" + currentBid);
    }

    /**
     * this method passes on an auction
     * @param player
     */
    public void passAuction(Player player) {
        if (!auctionInProgress || !remainingBidders.contains(player)) {
            return;
        }

        remainingBidders.remove(player);
        System.out.println(player.getName() + " passes on the auction");

        if (remainingBidders.size() == 1) {
            // Last player automatically wins at current bid
            completeAuction();
        } else if (remainingBidders.isEmpty()) {
            // No bidders left
            cancelAuction();
        }
    }

    /**
     * this method completes an auction when it ends
     */
    private void completeAuction() {
        if (!auctionInProgress) {
            return;
        }

        if (highestBidder != null && currentBid > 0) {
            System.out.println(highestBidder.getName() + " wins the auction for $" + currentBid);

            // Update the player's balance and property ownership
            highestBidder.updateBalance(-currentBid);

            if (propertyUnderAuction instanceof Property) {
                Property property = (Property) propertyUnderAuction;
                property.setOwner(highestBidder);
                highestBidder.getOwnedProperties().add(property);
            } else if (propertyUnderAuction instanceof Railroad) {
                Railroad railroad = (Railroad) propertyUnderAuction;
                railroad.setOwner(highestBidder);
                highestBidder.getOwnedRailroads().add(railroad);
            } else if (propertyUnderAuction instanceof Utility) {
                Utility utility = (Utility) propertyUnderAuction;
                utility.setOwner(highestBidder);
                highestBidder.getOwnedUtilities().add(utility);
            }

            highestBidder.checkMonopoly();
        } else if (remainingBidders.size() == 1) {
            // Last player standing gets the property at minimum price (can be configured)
            Player winner = remainingBidders.get(0);
            int minimumPrice = getMinimumPrice(propertyUnderAuction);
            System.out.println(winner.getName() + " wins the auction at minimum price $" + minimumPrice);

            winner.updateBalance(-minimumPrice);
            if (propertyUnderAuction instanceof Property) {
                Property property = (Property) propertyUnderAuction;
                property.setOwner(winner);
                winner.getOwnedProperties().add(property);
            } else if (propertyUnderAuction instanceof Railroad) {
                Railroad railroad = (Railroad) propertyUnderAuction;
                railroad.setOwner(winner);
                winner.getOwnedRailroads().add(railroad);
            } else if (propertyUnderAuction instanceof Utility) {
                Utility utility = (Utility) propertyUnderAuction;
                utility.setOwner(winner);
                winner.getOwnedUtilities().add(utility);
            }
            winner.checkMonopoly();
        }

        resetAuction();
        currentPhase = TurnPhase.PLAYER_ACTIONS; // Return to normal game flow
    }

    /**
     * this method gets the minimum price for a property
     * @param property
     * @return the minimum price
     */
    private int getMinimumPrice(BoardSquare property) {
        if (property instanceof Property) {
            return ((Property) property).getPrice() / 2;
        } else if (property instanceof Railroad) {
            return ((Railroad) property).getCost() / 2;
        } else if (property instanceof Utility) {
            return ((Utility) property).getCost() / 2;
        }
        return 0;
    }

    /**
     * this method cancels an auction if nobody gets the property
     */
    private void cancelAuction() {
        System.out.println("Auction canceled - no buyers for " + propertyUnderAuction.getName());
        resetAuction();
        currentPhase = TurnPhase.PLAYER_ACTIONS; // Return to normal game flow
    }

    /**
     * this method resets the auction
     */
    private void resetAuction() {
        propertyUnderAuction = null;
        currentBid = 0;
        highestBidder = null;
        auctionInProgress = false;
        remainingBidders = null;
    }

    /**
     * this method processes an auction turn
     * @param player
     * @param placeBid
     * @param bidAmount
     */
    // Add this method to handle the auction flow
    public void processAuctionTurn(Player player, boolean placeBid, int bidAmount) {
        if (!auctionInProgress || currentPhase != TurnPhase.AUCTION_PHASE) {
            return;
        }

        if (placeBid) {
            placeBid(player, bidAmount);
        } else {
            passAuction(player);
        }

        // Move to next bidder if auction still in progress
        if (auctionInProgress && !remainingBidders.isEmpty()) {

        }
    }

    /**
     * this method sets the turn order for the players
     */
    public void playerTurnOrder() {
        int max = 0;
        int index = 0;
        for (int i = 0; i < players.size(); i++) {
            if (Dice.getTotal() > max) {
                max = Dice.getTotal();
                index = i;
            }
        }
        currentPlayerIndex = index;
    }

    /**
     * this method gets the current phase of the game
     * @return the current phase
     */
    public TurnPhase getCurrentPhase() {
        return currentPhase;
    }

    /**
     * this method gets the players in the game
     * @return the players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * this method gets the current player index/turn
     * @return the current player index
     */
    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    /**
     * this method determines if the game is over
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        int solventPlayers = 0;
        for (Player player : players) {
            if (player.getBalance() > 0) {
                solventPlayers++;
            }
        }
        return solventPlayers <= 1;
    }

    /**
     * this method gets the winner of the game
     * @return the winner
     */
    public Player getWinner() {
        for (Player player : players) {
            if (player.getBalance() > 0) {
                return player;
            }
        }
        return null;
    }

    /**
     * this method gets the banker
     * @return the banker
     */
    public Banker getBank() {
        return banker;
    }


    public void removePlayer(Player player) {
        players.remove(player);
    }
}