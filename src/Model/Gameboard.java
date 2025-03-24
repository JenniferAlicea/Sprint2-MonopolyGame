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

        // square 0
        squares.add(new BoardSquare("Go", 0));
        // square 1
        TitleDeedCard mediterraneanAvenue = new TitleDeedCard("Mediterranean Avenue", Brown, 60, 2, 4, 10, 30, 90, 160, 250, 50, 50, 30);
        squares.add(new Property("Mediterranean Avenue", Brown, mediterraneanAvenue, 1));
        // square 2
        squares.add(new BoardSquare("Community Chest Card", 2));
        // square 3
        TitleDeedCard balticAvenue = new TitleDeedCard("Baltic Avenue", Brown, 60, 4, 8, 20, 60, 180, 320, 450, 50, 50, 30);
        squares.add(new Property("Baltic Avenue", Brown, balticAvenue, 3));
        // square 4
        squares.add(new BoardSquare("Income Tax", 4));
        // square 5
        squares.add(new Railroad("Reading Railroad", 25, 100, 5, 50, 100, 200));
        // square 6
        TitleDeedCard orientalAvenue = new TitleDeedCard("Oriental Avenue", LightBlue, 100, 6, 12, 30, 90, 270, 400, 550, 50, 50, 50);
        squares.add(new Property("Oriental Avenue", LightBlue, orientalAvenue, 6));
        //square 7
        squares.add(new BoardSquare("Chance Card", 0));
        //square 8
        TitleDeedCard vermontAvenue = new TitleDeedCard("Vermont Avenue", LightBlue, 100, 6, 12, 30, 90, 270, 400, 550, 50, 50, 50);
        squares.add(new Property("Vermont Avenue", LightBlue, vermontAvenue, 8));
        //square 9
        TitleDeedCard connecticutAvenue = new TitleDeedCard("Connecticut Avenue", LightBlue, 120, 8, 16, 40, 100, 300, 450, 600, 50, 50, 60);
        squares.add(new Property("Connecticut Avenue", LightBlue, connecticutAvenue, 9));
        //square 10
        squares.add(new BoardSquare("Jail/Just Visiting", 0));
        //square 11
        TitleDeedCard stCharlesPlace = new TitleDeedCard("St. Charles Place", Color.PINK, 140, 10, 20, 50, 150, 450, 625, 750, 100, 100, 70);
        squares.add(new Property("St. Charles Place", Color.PINK, stCharlesPlace, 11));

        //square 12
        squares.add(new Utility("Electric Company", 150, 75, 12, false));

        //square 13
        TitleDeedCard statesAvenue = new TitleDeedCard("States Avenue", Color.PINK, 140, 10, 20, 50, 150, 450, 625, 750, 100, 100, 70);
        squares.add(new Property("States Avenue", Color.PINK, statesAvenue, 13));

        //square 14
        TitleDeedCard virginiaAvenue = new TitleDeedCard("Virginia Avenue", Color.PINK, 160, 12, 24, 60, 180, 500, 700, 900, 100, 100, 80);
        squares.add(new Property("Virginia Avenue", Color.PINK, virginiaAvenue, 14));

        //square 15
        squares.add(new Railroad("Pennsylvania Railroad", 25, 100, 15, 50, 100, 200));

        //square 16
        TitleDeedCard stJamesPlace = new TitleDeedCard("St. James Place", Color.ORANGE, 180, 14, 28, 70, 200, 550, 750, 950, 100, 100, 90);
        squares.add(new Property("St. James Place", Color.ORANGE, stJamesPlace, 16));

        //square 17
        squares.add(new BoardSquare("Community Chest Card", 0));

        //square 18
        TitleDeedCard tennesseeAvenue = new TitleDeedCard("Tennessee Avenue", Color.ORANGE, 180, 14, 28, 70, 200, 550, 750, 950, 100, 100, 90);
        squares.add(new Property("Tennessee Avenue", Color.ORANGE, tennesseeAvenue, 18));

        //square 19
        TitleDeedCard newYorkAvenue = new TitleDeedCard("New York Avenue", Color.ORANGE, 200, 16, 32, 80, 220, 600, 800, 1000, 100, 100, 100);
        squares.add(new Property("New York Avenue", Color.ORANGE, newYorkAvenue, 19));

        //square 20
        squares.add(new BoardSquare("Free Parking", 0));

        //square 21
        TitleDeedCard kentuckyAvenue = new TitleDeedCard("Kentucky Avenue", Color.RED, 220, 18, 36, 90, 250, 700, 875, 1050, 150, 150, 110);
        squares.add(new Property("Kentucky Avenue", Color.RED, kentuckyAvenue, 21));

        //square 22
        squares.add(new BoardSquare("Chance Card", 0));

        //square 23
        TitleDeedCard indianaAvenue = new TitleDeedCard("Indiana Avenue", Color.RED, 220, 18, 36, 90, 250, 700, 875, 1050, 150, 150, 110);
        squares.add(new Property("Indiana Avenue", Color.RED, indianaAvenue, 23));

        //square 24
        TitleDeedCard illinoisAvenue = new TitleDeedCard("Illinois Avenue", Color.RED, 240, 20, 40, 100, 300, 750, 925, 1100, 150, 150, 120);
        squares.add(new Property("Illinois Avenue", Color.RED, illinoisAvenue, 24));

        //square 25
        squares.add(new Railroad("B&O Railroad", 25, 100, 25, 50, 100, 200));

        //square 26
        TitleDeedCard atlanticAvenue = new TitleDeedCard("Atlantic Avenue", Color.YELLOW, 260, 22, 44, 110, 330, 800, 975, 1150, 150, 150, 130);
        squares.add(new Property("Atlantic Avenue", Color.YELLOW, atlanticAvenue, 26));

        //square 27
        TitleDeedCard ventnorAvenue = new TitleDeedCard("Ventnor Avenue", Color.YELLOW, 260, 22, 44, 110, 330, 800, 975, 1150, 150, 150, 130);
        squares.add(new Property("Ventnor Avenue", Color.YELLOW, ventnorAvenue, 27));

        //square 28
        squares.add(new Utility("Water Works", 150, 75, 28, false));

        //square 29
        TitleDeedCard marvinGardens = new TitleDeedCard("Marvin Gardens", Color.YELLOW, 280, 24, 48, 120, 360, 850, 1025, 1200, 150, 150, 140);
        squares.add(new Property("Marvin Gardens", Color.YELLOW, marvinGardens, 29));

        //square 30
        squares.add(new BoardSquare("Go to Jail", 0));

        //square 31
        TitleDeedCard pacificAvenue = new TitleDeedCard("Pacific Avenue", Color.GREEN, 300, 26, 52, 130, 390, 900, 1100, 1275, 200, 200, 150);
        squares.add(new Property("Pacific Avenue", Color.GREEN, pacificAvenue, 31));

        //square 32
        TitleDeedCard northCarolinaAvenue = new TitleDeedCard("North Carolina Avenue", Color.GREEN, 300, 26, 52, 130, 390, 900, 1100, 1275, 200, 200, 150);
        squares.add(new Property("North Carolina Avenue", Color.GREEN, northCarolinaAvenue, 32));

        //square 33
        squares.add(new BoardSquare("Community Chest Card", 0));

        //square 34
        TitleDeedCard pennsylvaniaAvenue = new TitleDeedCard("Pennsylvania Avenue", Color.GREEN, 320, 28, 56, 150, 450, 1000, 1200, 1400, 200, 200, 160);
        squares.add(new Property("Pennsylvania Avenue", Color.GREEN, pennsylvaniaAvenue, 34));

        //square 35
        squares.add(new Railroad("Short Line", 25, 100, 35, 50, 100, 200));

        //square 36
        squares.add(new BoardSquare("Chance Card", 0));

        //square 37
        TitleDeedCard parkPlace = new TitleDeedCard("Park Place", DarkBlue, 350, 35, 70, 175, 500, 1100, 1300, 1500, 200, 200, 175);
        squares.add(new Property("Park Place", DarkBlue, parkPlace, 37));

        //square 38
        squares.add(new BoardSquare("Luxury Tax", 0));

        //square 39
        TitleDeedCard boardwalk = new TitleDeedCard("Boardwalk", DarkBlue, 400, 50, 100, 200, 600, 1400, 1700, 2000, 200, 200, 200);
        squares.add(new Property("Boardwalk", DarkBlue, boardwalk, 39));
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