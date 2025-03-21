package View;/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
import Model.*;

import java.awt.Color;

public class Main {
    public static void main(String[] args) {



        Player player = new Player("John Doe", 1500);

        Token token = new Token(TokenIcons.BOOT, player);
        player.setToken(token);

        Property property = new Property("Boardwalk", Color.BLUE);


        player.updateBalance(-200);

        Dice dice = new Dice();
        int rollResult = dice.roll();

        Gameboard gameboard = new Gameboard();
        gameboard.getSpacesMoved(player, rollResult);

        System.out.println("Dice roll result: " + rollResult);
        System.out.println("Dice 1: " + Dice.getDie1());
        System.out.println("Dice 2: " + Dice.getDie2());

        System.out.println("Player Name: " + player.getName());
        System.out.println("Player Balance: " + player.getBalance());
        System.out.println("Player Token: " + player.getToken().getType());
        System.out.println("Player Board Position: " + player.getBoardPosition());
    }
}