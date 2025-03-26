/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package View;

import Model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== MONOPOLY GAME DEMONSTRATION ===");

        // Initialize game components
        Gameboard gameboard = new Gameboard();
        GameState gameState = new GameState();
        gameState.setBoard(gameboard);

        // Create Dice
        Dice dice = new Dice();

        // Create banker with title deed cards
        TitleDeedCard[] titleDeedCards = createTitleDeedCards();
        Banker banker = new Banker(titleDeedCards);
        gameState.setBanker(banker);

        // Create players
        Player player1 = new Player("Player 1", 1500);
        Player player2 = new Player("Player 2", 1500);
        Player player3 = new Player("Player 3", 1500);
        Player player4 = new Player("Player 4", 1500);

        // Add players to game
        gameState.addPlayer(player1);
        gameState.addPlayer(player2);
        gameState.addPlayer(player3);
        gameState.addPlayer(player4);

        // Set up tokens
        player1.setToken(new Token(TokenIcons.BOOT, player1));
        player2.setToken(new Token(TokenIcons.BATTLESHIP, player2));
        player3.setToken(new Token(TokenIcons.THIMBLE, player3));
        player4.setToken(new Token(TokenIcons.TOP_HAT, player4));

        // Determine player order
        System.out.println("\n=== DETERMINING PLAYER ORDER ===");
        for (Player player : gameState.getPlayers()) {
            dice.roll();
            System.out.println(player.getName() + " rolled a " + dice.getTotal());
        }
        gameState.playerTurnOrder();

        // Initialize ChanceCards and CommunityChestCards
        ChanceCards chanceCards = new ChanceCards("", 0);
        chanceCards.ChanceDeck();

        CommunityChestCards communityChestCards = new CommunityChestCards("", 0);
        communityChestCards.CommunityChestDeck();

        // Demo a few rounds of gameplay
        Scanner scanner = new Scanner(System.in);
        int roundCount = 0;

        while (roundCount < 3) { // Limit to 3 rounds for demo
            System.out.println("\n=== ROUND " + (roundCount + 1) + " ===");

            // Loop through all players
            for (int i = 0; i < gameState.getPlayers().size(); i++) {
                Player currentPlayer = gameState.getCurrentPlayer();
                System.out.println("\n" + currentPlayer.getName() + "'s turn");
                System.out.println("Current balance: $" + currentPlayer.getBalance());
                System.out.println("Current position: " + currentPlayer.getBoardPosition());

                // PHASE 1: Roll dice
                System.out.println("\nRolling dice...");
                dice.roll();
                int roll = dice.getTotal();
                System.out.println("Rolled: " + roll + " (Dice 1: " + dice.getDie1() + ", Dice 2: " + dice.getDie2() + ")");

                if (dice.isDouble()) {
                    System.out.println("Rolled doubles!");
                }

                // PHASE 2: Move token
                System.out.println("\nMoving token...");
                boolean passedGo = currentPlayer.move(roll);
                System.out.println("New position: " + currentPlayer.getBoardPosition());

                if (passedGo) {
                    System.out.println("Passed GO! Collecting $200");
                    currentPlayer.updateBalance(200);
                }

                // PHASE 3: Handle square action
                System.out.println("\nHandling square action...");
                BoardSquare landedSquare = gameboard.getSquare(currentPlayer.getBoardPosition());
                System.out.println("Landed on: " + landedSquare.getName());
                landedSquare.landedOn(currentPlayer, gameState);

                // PHASE 4: Player actions
                System.out.println("\nPlayer actions phase");

                // Check if player landed on property
                if (landedSquare instanceof Property) {
                    Property property = (Property) landedSquare;
                    if (property.getOwner() == null) {
                        System.out.println("Property is unowned: " + property.getName());
                        System.out.println("Price: $" + property.getPrice());

                        // Demo purchase or auction based on position
                        if (i % 2 == 0) {
                            if (currentPlayer.getBalance() >= property.getPrice()) {
                                System.out.println("Buying property...");
                                currentPlayer.updateBalance(-property.getPrice());
                                property.setOwner(currentPlayer);
                                currentPlayer.getOwnedProperties().add(property);
                                currentPlayer.checkMonopoly();
                                System.out.println("New balance: $" + currentPlayer.getBalance());
                            } else {
                                System.out.println("Cannot afford property, going to auction...");
                                gameState.startAuction(property);
                                demoAuction(gameState);
                            }
                        } else {
                            System.out.println("Auctioning property...");
                            gameState.startAuction(property);
                            demoAuction(gameState);
                        }
                    } else {
                        System.out.println("Property owned by: " + property.getOwner().getName());
                        // Handle rent payment
                        int rent = property.calculateRent();
                        System.out.println("Paying rent: $" + rent);
                        currentPlayer.updateBalance(-rent);
                        property.getOwner().updateBalance(rent);
                        System.out.println("New balance: $" + currentPlayer.getBalance());
                    }
                } else if (landedSquare instanceof Railroad) {
                    Railroad railroad = (Railroad) landedSquare;
                    System.out.println("Landed on railroad: " + railroad.getName());

                    if (railroad.getOwner() == null) {
                        if (currentPlayer.getBalance() >= railroad.getCost()) {
                            System.out.println("Buying railroad...");
                            currentPlayer.updateBalance(-railroad.getCost());
                            railroad.setOwner(currentPlayer);
                            currentPlayer.getOwnedRailroads().add(railroad);
                            System.out.println("New balance: $" + currentPlayer.getBalance());
                        } else {
                            System.out.println("Cannot afford railroad, going to auction...");
                            gameState.startAuction(railroad);
                            demoAuction(gameState);
                        }
                    } else {
                        System.out.println("Railroad owned by: " + railroad.getOwner().getName());
                        // Handle rent payment
                        int rent = railroad.getRent();
                        System.out.println("Paying rent: $" + rent);
                        currentPlayer.updateBalance(-rent);
                        railroad.getOwner().updateBalance(rent);
                        System.out.println("New balance: $" + currentPlayer.getBalance());
                    }
                } else if (landedSquare instanceof Utility) {
                    Utility utility = (Utility) landedSquare;
                    System.out.println("Landed on utility: " + utility.getName());

                    if (utility.getOwner() == null) {
                        if (currentPlayer.getBalance() >= utility.getCost()) {
                            System.out.println("Buying utility...");
                            currentPlayer.updateBalance(-utility.getCost());
                            utility.setOwner(currentPlayer);
                            currentPlayer.getOwnedUtilities().add(utility);
                            System.out.println("New balance: $" + currentPlayer.getBalance());
                        } else {
                            System.out.println("Cannot afford utility, going to auction...");
                            gameState.startAuction(utility);
                            demoAuction(gameState);
                        }
                    } else {
                        System.out.println("Utility owned by: " + utility.getOwner().getName());
                        // Handle rent calculation based on dice roll
                        dice.roll();
                        int diceRoll = dice.getTotal();
                        int rent = utility.getRent();
                        System.out.println("Rolled " + diceRoll + " for utility rent calculation");
                        System.out.println("Paying rent: $" + rent);
                        currentPlayer.updateBalance(-rent);
                        utility.getOwner().updateBalance(rent);
                        System.out.println("New balance: $" + currentPlayer.getBalance());
                    }
                }

                // Demo mortgage if player owns properties
                if (!currentPlayer.getOwnedProperties().isEmpty() && roundCount > 0) {
                    Property propertyToMortgage = currentPlayer.getOwnedProperties().get(0);
                    System.out.println("\nMortgaging property: " + propertyToMortgage.getName());
                    int mortgageValue = propertyToMortgage.getMortgageValue();
                    currentPlayer.mortgageProperty(propertyToMortgage);
                    System.out.println("Received: $" + mortgageValue);
                    System.out.println("New balance: $" + currentPlayer.getBalance());
                    System.out.println("Mortgaged properties: " + currentPlayer.getMortgagedProperties().size());
                }

                // Demo building houses if player has monopoly
                boolean hasMonopoly = false;
                for (boolean monopoly : currentPlayer.getMonopolies().values()) {
                    if (monopoly) {
                        hasMonopoly = true;
                        break;
                    }
                }

                if (hasMonopoly) {
                    // Find a property in a monopoly group
                    for (Property property : currentPlayer.getOwnedProperties()) {
                        if (currentPlayer.getMonopolies().get(property.getColor())) {
                            System.out.println("\nBuilding house on: " + property.getName());
                            int houseCost = property.getPrice() / 2;
                            if (currentPlayer.getBalance() >= houseCost) {
                                currentPlayer.updateBalance(-houseCost);
                                property.addHouse();
                                System.out.println("House built! Houses now: " + property.getHouses());
                                System.out.println("New balance: $" + currentPlayer.getBalance());

                                // Demo hotel building if we have 4 houses
                                if (property.getHouses() == 4) {
                                    System.out.println("\nUpgrading to hotel on: " + property.getName());
                                    int hotelCost = property.getPrice() / 2;
                                    if (currentPlayer.getBalance() >= hotelCost) {
                                        currentPlayer.updateBalance(-hotelCost);
                                        property.addHotel();
                                        System.out.println("Hotel built! Houses returned to bank");
                                        System.out.println("New balance: $" + currentPlayer.getBalance());
                                    }
                                }
                            }
                            break;
                        }
                    }
                }

                // PHASE 5: End turn
                System.out.println("\nEnding turn...");

                // Check if player is bankrupt
                if (currentPlayer.getBalance() < 0) {
                    System.out.println(currentPlayer.getName() + " is bankrupt!");
                    // Handle bankruptcy - in a real game this would be more complex
                }

                gameState.endTurn();

                // Pause for readability
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }

            roundCount++;
        }

        // Display final game state
        System.out.println("\n=== GAME SUMMARY ===");
        for (Player player : gameState.getPlayers()) {
            System.out.println(player.getName() + ":");
            System.out.println("  Balance: $" + player.getBalance());
            System.out.println("  Properties: " + player.getOwnedProperties().size());
            System.out.println("  Railroads: " + player.getOwnedRailroads().size());
            System.out.println("  Utilities: " + player.getOwnedUtilities().size());
            System.out.println("  Mortgaged Properties: " + player.getMortgagedProperties().size());

            System.out.println("  Monopolies:");
            for (java.awt.Color color : player.getMonopolies().keySet()) {
                if (player.getMonopolies().get(color)) {
                    System.out.println("    - " + colorToString(color));
                }
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void demoAuction(GameState gameState) {
        // Mock auction with random bids
        for (Player bidder : gameState.getPlayers()) {
            // Randomly decide to bid or pass
            if (Math.random() > 0.4) {
                int bidAmount = (int)(bidder.getBalance() * 0.1) + 10; // Random bid amount
                System.out.println(bidder.getName() + " bids $" + bidAmount);
                gameState.processAuctionTurn(bidder, true, bidAmount);
            } else {
                System.out.println(bidder.getName() + " passes");
                gameState.processAuctionTurn(bidder, false, 0);
            }
        }
    }

    private static TitleDeedCard[] createTitleDeedCards() {
        // Create a simplified array of title deed cards for the banker
        TitleDeedCard[] cards = new TitleDeedCard[28]; // 28 properties in standard Monopoly

        // Initialize each card (simplified version)
        for (int i = 0; i < cards.length; i++) {
            String name = "Property " + (i + 1);
            java.awt.Color color = java.awt.Color.BLUE; // Default color
            int price = 100 + (i * 20);
            cards[i] = new TitleDeedCard(name, color, price, i, i*2, i*5, i*15, i*30, i*45, i*60, 50, 50, price/2);
        }

        return cards;
    }

    private static String colorToString(java.awt.Color color) {
        if (color.equals(new java.awt.Color(58, 6, 6))) return "Brown";
        if (color.equals(new java.awt.Color(3, 255, 255))) return "Light Blue";
        if (color.equals(java.awt.Color.PINK)) return "Pink";
        if (color.equals(java.awt.Color.ORANGE)) return "Orange";
        if (color.equals(java.awt.Color.RED)) return "Red";
        if (color.equals(java.awt.Color.YELLOW)) return "Yellow";
        if (color.equals(java.awt.Color.GREEN)) return "Green";
        if (color.equals(new java.awt.Color(16, 41, 166))) return "Dark Blue";
        return "Unknown";
    }
}