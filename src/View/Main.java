package View;/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
import Model.*;

import java.awt.Color;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Player player = new Player("John Doe", 1500);

        Token token = new Token(TokenIcons.BOOT, player);
        player.setToken(token);



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

        List<BoardSquare> list = gameboard.getSquares();
        for (BoardSquare square : list) {
            System.out.print("Square "+ square.getPosition() + ": ");
            System.out.println(square.getName());

        }
        player.buyProperty((Property) list.get(1));
        player.buyProperty((Property) list.get(3));
        System.out.println("Properties owned by player: ");
        for(int i = player.getOwnedProperties().size() - 1; i >= 0; i--){
            System.out.println(player.getOwnedProperties().get(i).getName());
        }
        player.checkMonopoly();
        for (Color color : player.getMonopolies().keySet()) {
            if (player.getMonopolies().get(color))
                System.out.println("Player has a monopoly in " + color);
        }

        System.out.println("Player Balance: " + player.getBalance());
        System.out.print("Mortgage value of " + player.getOwnedProperties().get(1).getName() + ": ");
        System.out.println(player.getOwnedProperties().get(1).getMortgageValue());
        player.mortgageProperty((Property) list.get(1));
        System.out.println("Player Balance after mortgaging: " + player.getBalance());


    }
}