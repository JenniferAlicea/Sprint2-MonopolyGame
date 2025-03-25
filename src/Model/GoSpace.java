package Model;

public class GoSpace extends BoardSquare {
    private int goMoney;


    public GoSpace() {
        super("Go", 0);
        goMoney = 200;

    }

    public int getGoMoney() {
        return goMoney;
    }
}
