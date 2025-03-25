package Model;

public class GoToJailSpace extends BoardSquare {

    public GoToJailSpace(String name, int position) {
        super(name, position);
    }

    public void sendToJail(Token token){
        token.sendToJail(true);
    }



}
