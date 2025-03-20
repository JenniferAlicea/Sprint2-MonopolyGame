/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Gameboard {
    private List<BoardSquare> squares;
    private List<ChanceCards> chanceCards;
    private List<CommunityChestCards> communityChestCards;

    /**
     * Constructor for the Gameboard class
     */
    public Gameboard() {
        squares = new ArrayList<>();
        initializeBoard();
        this.chanceCards = new ArrayList<>();
        this.communityChestCards = new ArrayList<>();
    }

    /**
     * Initializes the game board with all the squares
     */
    private void initializeBoard() {
        Color Brown = new Color(58, 6, 6);
        Color LightBlue = new Color(3, 255, 255);
        Color DarkBlue = new Color(16, 41, 166);
        squares.add(new BoardSquare("Go", 0));
        squares.add(new Property("Mediterranean Avenue", Brown));
        squares.add(new BoardSquare("Community Chest Card", 0));
        squares.add(new Property("Baltic Avenue", Brown));
        squares.add(new BoardSquare("Income Tax", 0));
        squares.add(new Railroad("Reading Railroad"));
        squares.add(new Property("Oriental Avenue", LightBlue));
        squares.add(new BoardSquare("Chance Card", 0));
        squares.add(new Property("Vermont Avenue", LightBlue));
        squares.add(new Property("Connecticut Avenue", LightBlue));
        squares.add(new BoardSquare("Jail/Just Visiting", 0));
        squares.add(new Property("St. Charles Place", Color.PINK));
        squares.add(new Utility("Electric Company"));
        squares.add(new Property("States Avenue", Color.PINK));
        squares.add(new Property("Virginia Avenue", Color.PINK));
        squares.add(new Railroad("Pennsylvania Railroad"));
        squares.add(new Property("St. James Place", Color.ORANGE));
        squares.add(new BoardSquare("Community Chest Card", 0));
        squares.add(new Property("Tennessee Avenue", Color.ORANGE));
        squares.add(new Property("New York Avenue", Color.ORANGE));
        squares.add(new BoardSquare("Free Parking", 0));
        squares.add(new Property("Kentucky Avenue", Color.RED));
        squares.add(new BoardSquare("Chance Card", 0));
        squares.add(new Property("Indiana Avenue", Color.RED));
        squares.add(new Property("Illinois Avenue", Color.RED));
        squares.add(new Railroad("B&O Railroad"));
        squares.add(new Property("Atlantic Avenue", Color.YELLOW));
        squares.add(new Property("Ventnor Avenue", Color.YELLOW));
        squares.add(new Utility("Water Works"));
        squares.add(new Property("Marvin Gardens", Color.YELLOW));
        squares.add(new BoardSquare("Go to Jail", 0));
        squares.add(new Property("Pacific Avenue", Color.GREEN));
        squares.add(new Property("North Carolina Avenue", Color.GREEN));
        squares.add(new BoardSquare("Community Chest Card", 0));
        squares.add(new Property("Pennsylvania Avenue", Color.GREEN));
        squares.add(new Railroad("Short Line"));
        squares.add(new BoardSquare("Chance Card", 0));
        squares.add(new Property("Park Place", DarkBlue));
        squares.add(new BoardSquare("Luxury Tax", 0));
        squares.add(new Property("Boardwalk", DarkBlue));
    }

    public void placeChanceCard(ChanceCards card) {
        chanceCards.add(card);
    }

    public void placeCommunityChestCard(CommunityChestCards card) {
        communityChestCards.add(card);
    }


    public List<BoardSquare> getSquares() {
        return squares;
    }


    public void giveStartingMoney(Player player) {
        player.deposit(1500);
    }

    public int getSpacesMoved(Player player, int steps) {
        int newPosition = (player.getBoardPosition() + steps) % squares.size();
        player.setBoardPosition(newPosition);
        return newPosition;
    }

    public void luxuryTax(Player player) {
        player.withdraw(100);
    }

    public void incomeTax(Player player) {
        player.withdraw(200);
    }

    public List<ChanceCards> getChanceCards() {
        return chanceCards;
    }

    public List<CommunityChestCards> getCommunityChestCards() {
        return communityChestCards;
    }
}