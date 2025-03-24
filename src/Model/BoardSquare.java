/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;


public class BoardSquare {
    protected String name;
    protected int position;

    /**
     * Constructor for the BoardSquare class
     *
     * @param name the name of the board square
     * @param position the position of the board square
     */
    public BoardSquare(String name, int position) {
        this.name = name;
        this.position = position;
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
     * Handles the free parking action of the board square
     * @param player the player to handle the action for
     */
    private void handleFreeParking(Player player) {
        player.updateBalance(0);
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



