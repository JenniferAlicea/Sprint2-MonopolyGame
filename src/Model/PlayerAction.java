/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

/**
 * This enum represents the different actions a player can take during their turn
 */
public enum PlayerAction {
    BUY_PROPERTY,
    AUCTION_PROPERTY,
    PLACE_BID,
    PASS_AUCTION,
    BUILD_HOUSE,
    BUILD_HOTEL,
    MORTGAGE_PROPERTY,
    UNMORTGAGE_PROPERTY,
    TRADE,
    END_TURN
}