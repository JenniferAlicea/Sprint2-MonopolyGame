/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
package Model;

public abstract class Cards {
    private final String description;
    private final int effect;

    /**
     * Constructor for the Cards class
     * @param description
     * @param effect
     */
    public Cards(String description, int effect) {
        this.description = description;
        this.effect = effect;
    }

    /**
     * This method returns the description of the card
     * @return the description of the card
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method returns the effect of the card
     * @return the effect of the card
     */
    public int getEffect() {
        return effect;
    }

    /**
     * This method applies the effect of the card to the player
     * @param player the player that the card is being applied to
     */
    public abstract void applyEffect(Player player);
}