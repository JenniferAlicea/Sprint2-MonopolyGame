package Model;

public class LuxuryTaxSpace extends BoardSquare {

    public LuxuryTaxSpace() {
        super("Luxury Tax", 38);
    }

    public void payLuxuryTax(Token token){
        token.payLuxuryTax();
    }
}
