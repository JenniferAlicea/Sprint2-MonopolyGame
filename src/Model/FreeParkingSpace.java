package Model;

public class FreeParkingSpace extends BoardSquare {
    public FreeParkingSpace(String freeParking, int i) {
        super("Free Parking", 20);
    }

    @Override
    public void landedOn(Player player, GameState gameState) {
        // No action needed
    }
}