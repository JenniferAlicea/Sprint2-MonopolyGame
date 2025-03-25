package Model;

public class CommunityChestCardSpace extends BoardSquare {
    private CommunityChestCards communityChestCards;

    public CommunityChestCardSpace(String name, int position, CommunityChestCards communityChestCards) {
        super(name, position);
        this.communityChestCards = communityChestCards;
    }

    public void landOn(Player player) {
        String cardDescription = communityChestCards.drawCard();
        communityChestCards.applyEffect(player);
        System.out.println(player.getName() + " drew a Community Chest card: " + cardDescription);
    }
}