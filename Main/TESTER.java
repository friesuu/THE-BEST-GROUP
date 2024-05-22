package Main;

public class TESTER {

    public static Player player1;
    public static Player player2;
    public static Player player3;

    public static Player currentPlayer;

    public static void main(String[] args) {
        GameFlow gameFlow = new GameFlow();
        gameFlow.setPokemon();
        gameFlow.start();


        // need to make condition checking if input is not 1a,1b,1c,2a,2b,2c, or 3
        if (gameFlow.choice().equalsIgnoreCase( "2a")){
            player1 = new Player(gameFlow.enterName(), gameFlow.choosePokemon());
            currentPlayer = player1;
            //intermediate(player1) ;
        }
        else if (gameFlow.choice().equalsIgnoreCase( "2b")){

            Player player2 = new Player(gameFlow.enterName(), gameFlow.choosePokemon());
            //intermediate(player2) ;

        }
        else if (gameFlow.choice().equalsIgnoreCase( "2c")){
            Player player3 = new Player(gameFlow.enterName(), gameFlow.choosePokemon());
            //intermediate(player3) ;
        }

        while (true){
            gameFlow.intermediate(currentPlayer);

        }


    }

}