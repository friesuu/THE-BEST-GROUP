/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon_assignment;

/**
 *
 * @author user
 */
import java.util.Scanner;
import java.util.List;
import org.json.simple.JSONObject;
import pokemon_assignment.SaveGameManager;

public class MemoryCartridge {
    private static Player player;
    private static JSONObject gameData;
    private static String trainerName;
    private static Player currentPlayer;
    private static int index;
    
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //boolean exitGame = false;
        //Player player = null;
        
        //Game game = new Game();
        Scanner sc = new Scanner(System.in);
        
        // Display main menu
        while (true) {
            displayMainMenu();
            getUserSelection();
        }
    }
    
    // Function to display main menu
    public static void displayMainMenu() {
        System.out.println("+---------------------------------------------------------------------------------+");
        System.out.println("Welcome to Pokémon - Kanto Adventures");
        System.out.println("+---------------------------------------------------------------------------------+");
        System.out.println("[1] Load Game");
        //System.out.println("        a. Save1-Amaan    b.Save2-empty       c.Save3-empty");
        System.out.println("[2] Start a New Adventure");
        //System.out.println("        a.Save1-Override    b.Save2-new         c.Save3-new");
        System.out.println("[3] Exit");
        System.out.println("+---------------------------------------------------------------------------------+");
    }
    
    public static void getUserSelection() {
        Game game = new Game();
        Scanner sc = new Scanner(System.in);
        System.out.print("Your choice : ");
        int selection = sc.nextInt();
        
        switch (selection) {
            case 1 :
                SaveGameManager.displaySavedGames();
                
                // Load game
                System.out.println("+---------------------------------------------------------------------------------+");
                System.out.print("Enter the number of the saved game you want to load : ");
                int saveNumber = sc.nextInt();
                String filename = "save" + (saveNumber - 1) + ".json";
                Player loadedPlayer = SaveGameManager.loadGame(filename);
                if (loadedPlayer != null) {
                    game.switchToLoadedPlayerGame(loadedPlayer);
                }
                
                break;
                
            case 2 :
                // Start new adventure
                game.startNewAdventure();
                // Save the new player's game data
                Player newPlayer = game.getCurrentPlayer();
                SaveGameManager.addNewPlayer(newPlayer);
                SaveGameManager.saveGame(newPlayer, "save" + (SaveGameManager.getSavedPlayers().size() - 1) + ".json");
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
