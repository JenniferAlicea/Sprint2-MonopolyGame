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
    squares.add(new BoardSquare("Go", 0));
    squares.add(new Property("Mediterranean Avenue", new Color(58, 6, 6)));
    squares.add(new BoardSquare("Community Chest Card", 0));
    squares.add(new Property("Baltic Avenue", new Color(58, 6, 6)));
    squares.add(new BoardSquare("Income Tax", 0));
    squares.add(new Railroad("Reading Railroad"));
    squares.add(new Property("Oriental Avenue", new Color(3, 255, 255)));
    squares.add(new BoardSquare("Chance Card", 0));
    squares.add(new Property("Vermont Avenue", new Color(3, 255, 255)));
    squares.add(new Property("Connecticut Avenue", new Color(3, 255, 255)));
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
    squares.add(new Property("Park Place", new Color(16, 41, 166)));
    squares.add(new BoardSquare("Luxury Tax", 0));
    squares.add(new Property("Boardwalk", new Color(16, 41, 166)));

    }


    public void placeChanceCard(ChanceCards card) {

    }

    public void placeCommunityChestCard(CommunityChestCards card) {
        // place the community chest card on the bottom of the deck

    }

    public void assignTokens() {
        // assign tokens to the board squares
    }

    public void giveStartingMoney(Player player) {
        // give the players starting money
    }

    public void moveToken(Player player, int steps) {
        // move the token a certain number of spaces
    }

    public void luxuryTax(Player player) {
        // deduct $100 from the player's balance
        player.withdraw(100);
    }

    public void incomeTax(Player player) {
        // deduct $200 from the player's balance
        player.withdraw(200);
    }
}
