/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

import javax.swing.*;
import java.awt.*;

public class Token{
    private final TokenIcons type;
    private static Player owner;
    private static int boardPosition;
    private static Gameboard gameboard = new Gameboard();
    private ImageIcon icon;
    private boolean inJail = false;


    /**
     * Constructor for the Token class
     * @param type
     * @param owner
     */
    public Token(TokenIcons type, Player owner) {
        this.type = type;
        Token.owner = owner;
        boardPosition = gameboard.getSpacesMoved(owner, 0);
        this.icon = loadTokenIcon();
    }

    /**
     * This method loads the icon for the token
     * @return the icon for the token
     */
    private ImageIcon loadTokenIcon() {
        String path = type.getPath();
        ImageIcon icon = new ImageIcon(path);
        icon.setImage(icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        return icon;
    }


    /**
     * This method assigns a token to a player
     * @param player the player that the token is being assigned to
     * @param iconType the type of token that is being assigned
     * @return the token that was assigned to the player
     */
    public static Token assignToPlayer(Player player, TokenIcons iconType) {
        Token token = new Token(iconType, player);
        player.setToken(token);
        return token;
    }

    /**
     * This method returns the icon for the token
     * @return the icon for the token
     */
    public ImageIcon getIcon() {
        return icon;
    }

    public TokenIcons getTokenType() {
        return type;
    }

    /**
     * This method returns the owner of the token
     * @return the owner of the token
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * This method returns the board position of the token
     * @return the board position of the token
     */
    public static int getBoardPosition(){
        return boardPosition;
    }

    /**
     * This method moves the token to jail
     * @param b changes the boolean value of inJail
     */
    public void sendToJail(boolean b) {
        boardPosition = 10;
        inJail = b;
    }

    /**
     * This method pays the luxury tax
     */
    public void payLuxuryTax() {
        owner.updateBalance(-75);
    }

    /**
     * This method pays the income tax
     */
    public void payIncomeTax() {
        owner.updateBalance(-200);
    }

    /**
     * This method sets the board position of the token
     * @param position the position to set
     */
    public void setBoardPosition(int position) {
        boardPosition = position;
    }

    /**
     * this method gets the type of token
     * @return the type of token
     */
    public TokenIcons getType() {
        return type;
    }
    
}
