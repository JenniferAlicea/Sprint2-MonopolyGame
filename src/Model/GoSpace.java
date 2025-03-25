package Model;

public class GoSpace extends BoardSquare {
    private int goMoney;

    public GoSpace(String go, int i) {
        super(go, i);
        goMoney = 200;
    }

    @Override
    public void landedOn(Player player, GameState gameState) {
        player.updateBalance(goMoney);
    }

    public int getGoMoney() {
        return goMoney;
    }
}