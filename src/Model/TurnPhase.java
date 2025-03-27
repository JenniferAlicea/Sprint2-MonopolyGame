/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

/**
 * This enum represents the different phases of a player's turn
 */
public enum TurnPhase {
    ROLL_DICE,
    MOVE_TOKEN,
    HANDLE_SQUARE_ACTION,
    PLAYER_ACTIONS,
    AUCTION_PHASE,
    END_TURN
}