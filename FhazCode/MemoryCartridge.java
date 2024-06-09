package FhazCode;

import org.json.simple.JSONObject;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class MemoryCartridge {
    private static Player player;
    private static JSONObject gameData;
    private static String trainerName;
    //private static Player currentPlayer;
    private static int index;

//    public static void main(String[] args) {
//        //Scanner sc = new Scanner(System.in);
//        //boolean exitGame = false;
//        //Player player = null;
//
//        //Game game = new Game();
//        Scanner sc = new Scanner(System.in);
//
//        // Display main menu
//        while (true) {
//            displayMainMenu();
//            getUserSelection();
//        }
//    }


    public static void getUserSelection() {
        //Game game = new Game();
        Scanner sc = new Scanner(System.in);
        System.out.print("Your choice : ");
        int selection = sc.nextInt();
        GameFlow gameFlow = new GameFlow();

        switch (selection) {
            case 1 :
                //SaveGameManager.displaySavedGames();

                // Load game
                System.out.println("+---------------------------------------------------------------------------------+");
                System.out.print("Enter the number of the saved game you want to load : ");
                int saveNumber = sc.nextInt();

                String filename = "save" + (saveNumber - 1) + ".json";
                Player loadedPlayer = SaveGameManager.loadGame(filename);

                while (loadedPlayer == null){
                    System.out.println("\nThe game is empty. Please enter another game.");
                    System.out.print("Enter the number of the saved game you want to load : ");
                    saveNumber = sc.nextInt();

                    filename = "save" + (saveNumber - 1) + ".json";
                    loadedPlayer = SaveGameManager.loadGame(filename);
                }

                GameFlow.switchToLoadedPlayerGame(loadedPlayer);



                System.out.println("\nWelcome back " + loadedPlayer.getPlayerName() + "!\n");

                System.out.println("+--------------------------------------------------------------------------------------------+");

                break;

            case 2 :
                // Start new adventure
                // GameFlow.start();
                // Save the new player's game data
                //Player newPlayer = Main.currentPlayer;
                System.out.println("+---------------------------------------------------------------------------------+");
                System.out.print("Enter the number of the saved game you want to override : ");
                int input = sc.nextInt();
                System.out.println("+--------------------------------------------------------------------------------------------+");

                switch (input){
                    case 1:
                        Main.player1 = new Player(gameFlow.enterName(), List.of(gameFlow.choosePokemon()));
                        Main.currentPlayer = Main.player1;
                        //while (true) {
                        gameFlow.intermediate(Main.player1);
                        break;

                    case 2:

                        Main.player2 = new Player(gameFlow.enterName(), List.of(gameFlow.choosePokemon()));
                        Main.currentPlayer = Main.player2;
                        //while (true) {
                        gameFlow.intermediate(Main.player2);

                        break;

                    case 3:

                        Main.player3 = new Player(gameFlow.enterName(), List.of(gameFlow.choosePokemon()));
                        Main.currentPlayer = Main.player3;
                        //while (true) {
                        gameFlow.intermediate(Main.player3);

                        break;

                }
//                GameFlow gameFlow = new GameFlow();
//                Main.player1 = new Player(gameFlow.enterName(), List.of(gameFlow.choosePokemon()));
//                currentPlayer = Main.player1;
//                //while (true) {
//                    gameFlow.intermediate(Main.player1);
//                //}

                //Player newPlayer = Main.currentPlayer;
                //SaveGameManager.addNewPlayer(newPlayer);
                //SaveGameManager.saveGame(newPlayer, "save" + (SaveGameManager.getSavedPlayers().size() - 1) + ".json");
                break;

            case 3 :
                // Exit
                System.out.println("See ya!");
                System.exit(0);
                break;

            default :
                // Invalid selection
                System.out.println("Invalid selection.");
        }
    }
}
