package Model;

import java.awt.*;

public class Property extends BoardSquare {
    private Color color;

    /**
     * Constructor for the Property class
     * @param name the name of the property
     * @param color the color of the property
     */
    public Property(String name, Color color) {
        super(name, 0);
        this.color = color;
    }

    public Color getColor() { return color; }
}
