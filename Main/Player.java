package Testing2DGame.Main;

public class Player {

    private String playersPokemon;
    private int level;
//    private String[][] moves = new String[2][2];

    private String move1, move2, playersName;


    public Player(String playersName, String playersPokemon ) {
        this.playersPokemon = playersPokemon;
        this.level = 5;
        this.playersName= playersName;
         move1 = "Tackle";
         move2 = "Vine Whip";
    }

    public String getPlayersName() {
        return playersName;
    }

    public void setPlayersName(String playersName) {
        this.playersName = playersName;
    }

    public String getPlayersPokemon() {
        return playersPokemon;
    }

    public void setPlayersPokemon(String playersPokemon) {
        this.playersPokemon = playersPokemon;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getMove1() {
        return move1;
    }

    public void setMove1(String move1) {
        this.move1 = move1;
    }

    public String getMove2() {
        return move2;
    }

    public void setMove2(String move2) {
        this.move2 = move2;
    }
    //    public String[][] getMoves() {
//        return moves;
//    }
//
//    public void setMoves(String[][] moves) {
//        this.moves = moves;
//    }
}
