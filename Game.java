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

public class Game {
    private Player currentPlayer;
    
    // Function to start a new adventure
    public void startNewAdventure() {
        // Prompt user to enter their name
        Scanner sc = new Scanner(System.in);
        
        System.out.println("OAK :   Hello there! Welcome to the world of Pokémon! My name is Oak! "
                + "\nPeople call me the Pokémon Prof! This world is inhabited by creatures called Pokémon! "
                + "\nFor some people, Pokémon are pets. Others use them for fights. "
                + "\nMyself... I study Pokémon as a profession.");
        System.out.println("\nOAK :   First, what is your name?");
        System.out.println("+---------------------------------------------------------------------------------+");
        System.out.print("Enter your name : ");
        String trainerName = sc.nextLine();
        
        // Create a new player
        Player player = new Player(trainerName, "Pallet Town");
        
        // Prompt user to choose a starter pokemon
        System.out.println("+---------------------------------------------------------------------------------+");
         System.out.println("OAK :   Right! so your name is " + trainerName + "! "
                + "\nWelcome to the world of Pokémon. It's time to choose your starting Pokémon.");
        System.out.println("+---------------------------------------------------------------------------------+");
        System.out.println("[1] Bulbasaur [Grass - Level 5]");
        System.out.println("[2] Squirtle [Water - Level 5]");
        System.out.println("[3] Charmander [Fire - Level 5]");
        System.out.println("+---------------------------------------------------------------------------------+");
        System.out.print("Your choice : ");
        int choice = sc.nextInt();
        System.out.println("+---------------------------------------------------------------------------------+");
        
        // Create a new Pokemon object for the selected starter
        Pokemon starter = null;
        switch (choice) {
            case 1 :
                starter = new Pokemon("Bulbasaur","Grass", 5);
                break;
               
            case 2 :
                starter = new Pokemon("Squirtle", "Water", 5);
                break;
                
            case 3 :
                starter = new Pokemon("Charmander", "Fire", 5);
                break;
               
            default :
                System.out.println("Invalid choice.");
                return;
        }
        
        System.out.println("OAK :   You chose " + starter.getName() + ", an amazing choice. Best of luck!");
        System.out.println("+---------------------------------------------------------------------------------+");
        
        System.out.println("You are currently in " + player.getCurrentLocation() + " :");
        System.out.println("+---------------------------------------------------------------------------------+");
        System.out.println("[1] Move to : ");
        System.out.println("    a. Viridian City    b. Cinnabar Island");
        System.out.println("[2] Talk to Mom [Your hometown has no Gym]");
        System.out.println("[3] Fight Wild Pokémon [Pidgey, Meowth, Sycther are common]");
        System.out.println("[4] Player Options");
        System.out.println("    a.Show map  b.Show My Pokémon   c.Show my badges    d.Save and Exit");
        System.out.println("+---------------------------------------------------------------------------------+");
        System.out.print("Your choice : ");
        int nextChoice = sc.nextInt();
        System.out.println("+---------------------------------------------------------------------------------+");
        
        if (nextChoice == 1) {
            
        } else if (nextChoice == 2) {
            talkToMom(trainerName);
        } else if (nextChoice == 3) {
            
        } else if (nextChoice == 4) {
            
        } else {
            System.out.println("Invalid choice.");
        }
        
        // Add the starter Pokemon to the player's team
        player.getPokemonTeam().add(starter);
        
        // Save the new player to the saved games list
        SaveGameManager.addNewPlayer(player);
        
        // Switch to the new's player game
        switchToLoadedPlayerGame(player);
        
        // Update the saved players list
        SaveGameManager.updateSavedPlayers();
    }
    
    // Function to switch to the loaded player's game
    public void switchToLoadedPlayerGame(Player player) {
        // Switch to the loaded player's game
        this.currentPlayer = player;
    }
    
    // Function to get the current player
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }
    
    // Method to display about Talk to Mom
    public static void talkToMom(String trainerName) {
        System.out.println("MOM :   \"Oh, " + trainerName + "! You're leaving on your adventure with Pokémon? How exciting! "
                + "\nI know you've alwways dreamed of this day. Remember, the bond you share with your Pokémon is the most "
                + "\nimportang thing. Take care of them, and they'll take care of you. Don't worry about me; I'll be just fine "
                + "\nhere. I can't wait to hear all about your adventures and the new friends you're going to make. "
                + "\nRemember, no matter how far you go, I'm always here for you. Be brave, be kink, and everything will turn "
                + "\nout just fine. I'm so proud of you already! Now, go on, your adventure awaits! Oh, and don't forget to "
                + "\nchange your underwear every day! Safe travels, my dear!\"");
        System.out.println("+---------------------------------------------------------------------------------+");
    }
}
