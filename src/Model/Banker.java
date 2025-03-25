package Model;

public class Banker {
    private TitleDeedCard[] titleDeedCards;
    private int houses = 32;
    private int hotels = 12;

    public Banker(TitleDeedCard[] titleDeedCards) {
        this.titleDeedCards = titleDeedCards;
    }

    public void auctionProperty(BoardSquare property) {
    }

    public void sellProperty(BoardSquare property, Player player) {

    }

    public void paySalary(Player player) {

    }

    public void sellHouse(Player player) {

    }

    public void sellHotel(Player player) {

    }

    public void loanMoney(Player player, int amount) {

    }
}
