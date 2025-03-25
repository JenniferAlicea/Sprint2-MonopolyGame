/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

public class Token{
    private final TokenIcons type;
    private static Player owner;
    private static int boardPosition;
    private static Gameboard gameboard = new Gameboard();



    public Token(TokenIcons type, Player owner) {
        this.type = type;
        Token.owner = owner;
        boardPosition = gameboard.getSpacesMoved(owner, 0);
    }


    public static Token assignToPlayer(Player player) {
        owner = player;
        return owner.getToken();
    }

    public Player getOwner() {
        return owner;
    }

    public static int getBoardPosition(){
        return boardPosition;
    }

    public void sendToJail(boolean b) {
        boardPosition = 10;
    }

    public void payLuxuryTax() {
        owner.updateBalance(-75);
    }

    public void payIncomeTax() {
        owner.updateBalance(-200);
    }

    public void setBoardPosition(int position) {
        boardPosition = position;
    }

    public TokenIcons getType() {
        return type;
    }
    
}
