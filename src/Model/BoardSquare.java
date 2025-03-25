package Model;

public abstract class BoardSquare {
    protected String name;
    protected int position;
    protected Player owner;
    
    public BoardSquare(String name, int position) {
        this.name = name;
        this.position = position;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPosition() {
        return position;
    }


    
    // Method to handle landing on this square
    public abstract void landedOn(Player player, GameState gameState);
    
    // Default implementation for non-ownable squares
    public Player getOwner() {
        return owner;
    }
}