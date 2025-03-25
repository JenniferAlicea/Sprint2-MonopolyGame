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



    public Token(TokenIcons type, Player owner) {
        this.type = type;
        Token.owner = owner;
        boardPosition = gameboard.getSpacesMoved(owner, 0);
        this.icon = loadTokenIcon();
    }

    private ImageIcon loadTokenIcon() {
        String path = type.getPath();
        ImageIcon icon = new ImageIcon(path);
        icon.setImage(icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        return icon;
    }


    public static Token assignToPlayer(Player player, TokenIcons iconType) {
        Token token = new Token(iconType, player);
        player.setToken(token);
        return token;
    }

    public ImageIcon getIcon() {
        return icon;
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
