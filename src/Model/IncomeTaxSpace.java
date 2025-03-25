package Model;

public class IncomeTaxSpace extends BoardSquare{

    public IncomeTaxSpace() {
        super("Income Tax", 4);
    }

    public void payIncomeTax(Token token){
        token.payIncomeTax();
    }
}
