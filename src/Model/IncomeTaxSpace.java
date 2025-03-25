package Model;

public class IncomeTaxSpace extends BoardSquare{

    public IncomeTaxSpace(String incomeTax, int i) {
        super("Income Tax", 4);
    }

    @Override
    public void landedOn(Player player, GameState gameState) {
        payIncomeTax(player.getToken());
    }
    public void payIncomeTax(Token token){
        token.payIncomeTax();
    }
}
