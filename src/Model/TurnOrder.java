/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

import java.util.ArrayList;
import java.util.List;

public class TurnOrder {
    private static final int MAX_PLAYERS = 4;
    private List<Player> players;
    private int currentPlayerIndex;

    public TurnOrder() {
        players = new ArrayList<>();
        currentPlayerIndex = 0;
    }

    public boolean addPlayer(Player player) {
        if (players.size() < MAX_PLAYERS) {
            players.add(player);
            return true;
        } else {
            System.out.println("Cannot add more than " + MAX_PLAYERS + " players.");
            return false;
        }
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public void firstRollForTurnOrder(){
        for (Player player : players) {
            Dice.roll();
            System.out.println("Player " + player.getName() + " rolled a " + Dice.getTotal());
        }
    }

    public void playerTurnOrder(){
        int max = 0;
        int index = 0;
        for (int i = 0; i < players.size(); i++) {
            if (Dice.getTotal() > max) {
                max = Dice.getTotal();
                index = i;
            }
        }
        currentPlayerIndex = index;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }
}