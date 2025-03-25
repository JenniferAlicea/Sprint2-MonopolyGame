package Model;

import java.util.List;

public class CommunityChestCardSpace extends BoardSquare {
    private CommunityChestCards communityChestCards;

    public CommunityChestCardSpace(String name, int position, List<CommunityChestCards> communityChestCards) {
        super(name, position);
    }

    @Override
    public void landedOn(Player player, GameState gameState) {
        String card = communityChestCards.drawCard();
        communityChestCards.applyEffect(player);
        System.out.println(player.getName() + " drew a Community Chest card: " + card);
    }
}