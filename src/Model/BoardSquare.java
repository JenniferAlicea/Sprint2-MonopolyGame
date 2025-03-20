package Model;


public class BoardSquare {
    protected String name;
    protected int position;

    /**
     * Constructor for the BoardSquare class
     *
     * @param name the name of the board square
     * @param i
     */
    public BoardSquare(String name, int i) {
        this.name = name;
        this.position = 0;
    }

    /**
     * Returns the name of the board square
     * @return the name of the board square
     */
    public String getName() {
        return name;
    }

    /**
     * Executes the strategy of the board square
     */
    public void executeStrategy() {
    }

    /**
     * Handles the go action of the board square
     * @param player the player to handle the action for
     */
    private void handleGo(Player player) {
        int salary = 200;
        player.updateBalance(salary);
    }

    /**
     * Handles the jail action of the board square
     * @param player the player to handle the action for
     */
    private void handleJail(Player player) {
        player.isVisitingJail();
    }

    /**
     * Handles the free parking action of the board square
     * @param player the player to handle the action for
     */
    private void handleFreeParking(Player player) {
        // Free Parking does not have an action. (free resting space)
    }


    // Go to Jail is a special case where the player is sent to jail
    private void handleGoToJail(Player player) {
        player.sendToJail();
    }



    public void setSpacePosition(int i) {
        this.position = i;
    }


    public void setSpaceName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }
}



