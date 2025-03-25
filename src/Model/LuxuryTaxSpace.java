package Model;

public class LuxuryTaxSpace extends BoardSquare {

    public LuxuryTaxSpace(String luxuryTax, int i) {
        super("Luxury Tax", 38);
    }

    @Override
    public void landedOn(Player player, GameState gameState) {
        payLuxuryTax(player.getToken());
    }
    public void payLuxuryTax(Token token){
        token.payLuxuryTax();
    }
}
