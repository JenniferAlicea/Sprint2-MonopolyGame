package Model;

public class ChanceCardSpace extends BoardSquare {
    private ChanceCards chanceCards;

    public ChanceCardSpace(String name, int position, ChanceCards chanceCards) {
        super(name, position);
        this.chanceCards = chanceCards;
    }

    public void landOn(Player player) {
        String cardDescription = chanceCards.drawCard();
        chanceCards.applyEffect(player);
        System.out.println(player.getName() + " drew a Chance card: " + cardDescription);
    }
}
