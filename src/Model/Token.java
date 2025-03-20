package Model;


public class Token {
    private Tokens type;
    private Player owner;
    private int boardPosition;

    // Constructor
    public Token(Tokens type) {
        this.type = type;
        this.owner = null;
        this.boardPosition = 0;
    }


    // Method to assign a token to a player
    public void assignToPlayer(Player player) {
        this.owner = player;
    }

    // Method to get the owner of the token
    public Player getOwner() {
        return owner;
    }

    // Method to get the current position of the token on the board
    public int getBoardPosition(){
        return boardPosition;
    }

    // Method to set the position of the token on the board
    public void setBoardPosition(int position) {
        this.boardPosition = position;
    }

    // Method to get the type of the token
    public Tokens getType() {
        return type;
    }
    
}
