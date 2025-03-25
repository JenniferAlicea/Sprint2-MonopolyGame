package Model;

public class JailSpace extends BoardSquare {

    public JailSpace() {
        super("Jail", 10);
    }

    public void sendToJail(Token token){
        token.sendToJail(true);
    }
}
