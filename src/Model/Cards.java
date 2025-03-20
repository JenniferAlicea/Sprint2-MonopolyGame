/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

public abstract class Cards {
    private final String description;
    private final int effect;

    public Cards(String description, int effect) {
        this.description = description;
        this.effect = effect;
    }

    public String getDescription() {
        return description;
    }

    public int getEffect() {
        return effect;
    }

    public abstract void applyEffect(Player player);
}