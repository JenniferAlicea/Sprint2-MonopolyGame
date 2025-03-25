package Model;

public class GoToJailSpace extends BoardSquare {

    public GoToJailSpace(String name, int position) {
        super(name, position);
    }

    @Override
    public void landedOn(Player player, GameState gameState) {
        sendToJail(player.getToken());
    }
    public void sendToJail(Token token){
        token.sendToJail(true);
    }



}
