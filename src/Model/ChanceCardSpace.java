package Model;

import java.util.List;

public class ChanceCardSpace extends BoardSquare {

    private ChanceCards chanceCards;

    public ChanceCardSpace(String name, int position, List<ChanceCards> chanceCards) {
        super(name, position);
    }

    public void landOn(Player player) {
        String cardDescription = chanceCards.drawCard();
        chanceCards.applyEffect(player);
        System.out.println(player.getName() + " drew a Chance card: " + cardDescription);
    }

    @Override
    public void landedOn(Player player, GameState gameState) {
        landOn(player);
    }
}
