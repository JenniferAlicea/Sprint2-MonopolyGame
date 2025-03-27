/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;


/**
 * Enum class to represent the different types of tokens in the game
 */
public enum TokenIcons {
    TOP_HAT("tokens/tophat.png"),
    THIMBLE("tokens/thimble.png"),
    IRON("tokens/iron.png"),
    BOOT("tokens/boot.png"),
    BATTLESHIP("tokens/battleship.png"),
    CANNON("tokens/cannon.png"),
    RACE_CAR("tokens/racecar.png"),
    SCOTTIE_DOG("tokens/scottiedog.png"),
    WHEELBARROW("tokens/wheelbarrow.png");

    private final String path;

    TokenIcons(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
    }
