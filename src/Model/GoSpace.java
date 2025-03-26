package Model;

public class GoSpace extends BoardSquare {
    public static final int GO_MONEY = 200;
    private int goMoney = GO_MONEY;

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