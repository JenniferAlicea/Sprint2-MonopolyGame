package Model;

import java.awt.*;

public class Property extends BoardSquare {
    private TitleDeedCard titleDeed;
    private Color color;
    private Player owner;
    private boolean mortgaged;
    private int houses;
    private boolean hasHotel;
    
    public Property(String name, Color color, TitleDeedCard titleDeed, int position) {
        super(name, position);
        this.color = color;
        this.titleDeed = titleDeed;
        this.mortgaged = false;
        this.houses = 0;
        this.hasHotel = false;
    }
    
    @Override
    public void landedOn(Player player, GameState gameState) {
        if (owner == null) {
            // Property can be purchased
            gameState.offerPropertyPurchase(this);
        } else if (owner != player && !mortgaged) {
            // Pay rent to owner
            int rent = calculateRent();
            player.updateBalance(-rent);
            owner.updateBalance(rent);
        }
    }
    
    public int calculateRent() {
        if (mortgaged) {
            return 0;
        }
        
        if (hasHotel) {
            return titleDeed.getWithHotel();
        }
        
        switch (houses) {
            case 1: return titleDeed.getWithOneHouse();
            case 2: return titleDeed.getWithTwoHouses();
            case 3: return titleDeed.getWithThreeHouses();
            case 4: return titleDeed.getWithFourHouses();
            default: 
                if (owner != null && owner.getMonopolies().get(color)) {
                    return titleDeed.getMonopolyRent();
                }
                return titleDeed.getRent();
        }
    }
    
    @Override
    public Player getOwner() {
        return owner;
    }
    
    public Player setOwner(Player player) {
        this.owner = player;
        return player;
    }
    
    public boolean isMortgaged() {
        return mortgaged;
    }
    
    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
    }
    
    public int getMortgageValue() {
        return titleDeed.getMortgageValue();
    }
    
    public int getPrice() {
        return titleDeed.getCost();
    }
    
    public Color getColor() {
        return color;
    }
    
    public int getHouses() {
        return houses;
    }
    
    public void addHouse() {
        if (houses < 4) houses++;
    }
    
    public void addHotel() {
        if (houses == 4) {
            houses = 0;
            hasHotel = true;
        }
    }
    
    public String getGroup() {
        return color.toString();
    }
}