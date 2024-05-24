/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon_assignment;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author user
 */
public class SaveGameManager {

    private static Player currentPlayer;
    // Function to save a game process
    public static void saveGame(Player player, String filename) {
        JSONObject saveData = new JSONObject();
        saveData.put("trainerName", player.getTrainerName());
        saveData.put("currentLocation", player.getCurrentLocation());
        saveData.put("pokemonTeam", player.getPokemonTeam());
        saveData.put("defeatedGymLeaders", player.getDefeatedGymLeaders());
        saveData.put("earnedBadges", player.getEarnedBadges());
        
        try (FileWriter file = new FileWriter(filename)) {
            file.write(saveData.toJSONString());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    private static List<Player> savedPlayers = new ArrayList<>();
    
    // Function to display saved games
    public static void displaySavedGames() {
        List<Player> savedPlayers = SaveGameManager.getSavedPlayers();
        System.out.println("+---------------------------------------------------------------------------------+");
        System.out.println("Saved Games ...");
        System.out.println("+---------------------------------------------------------------------------------+");
        for(int i = 0; i < savedPlayers.size(); i++) {
            Player player = savedPlayers.get(i);
            System.out.println("        " + (i + 1) + ". " + player.getTrainerName());
        }
    }
    
    //Function to load save game
    /**public static List<Player> loadGame() {
        File folder = new File("saves/");
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));
        List<Player> savedPlayers = new ArrayList<>();
        
        for (File file : files) {
            try {
                String jsonString = new String(Files.readAllBytes(file.toPath()));
                Player player = new GsonBuilder().create().fromJson(jsonString, Player.class);
                savedPlayers.add(player);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return savedPlayers;
    }**/
    
    // Function to load save game
    public static Player loadGame(String filename) {
        JSONParser parser = new JSONParser();
        Player player = null;
        
        try (FileReader reader = new FileReader(filename)) {
            Object obj = parser.parse(reader);
            JSONObject saveData = (JSONObject) obj;
            
            String trainerName = (String) saveData.get("trainerName");
            String currentLocation = (String) saveData.get("currentLocation");
            JSONArray pokemonTeam = (JSONArray) saveData.get("pokemonTeam");
            JSONArray defeatedGymLeaders = (JSONArray) saveData.get("defeatedGymLeaders");
            JSONArray earnedBadges = (JSONArray) saveData.get("earnedBsdges");
            
            // Create Player object from loaded data
            player = new Player(trainerName, currentLocation);
            player.setPokemonTeam((ArrayList<Pokemon>) pokemonTeam);
            player.setDefeatedGymLeaders((ArrayList<String>) defeatedGymLeaders);
            player.setEarnedBadges((ArrayList<String>) earnedBadges);
        } catch (IOException | ParseException e) {
            System.out.println("Error loading game : " + e.getMessage());
            // Handling error loading game
        }
        
        return player;
    }
    
    // Function to add new player to the saved game list
    public static void addNewPlayer(Player player) {
        savedPlayers = new ArrayList<>();
        savedPlayers.add(player);
        
        // Save the updates saved game list
        saveSavedPlayers(savedPlayers);
    }
    
    // Function to save the list of saved players
    public static void saveSavedPlayers(List<Player> savedPlayers) {
        JSONArray saveData = new JSONArray();
        for (Player player : savedPlayers) {
            JSONObject playerData = new JSONObject();
            playerData.put("trainerName", player.getTrainerName());
            playerData.put("currentLocation", player.getCurrentLocation());
            saveData.add(playerData);
        }
        
        try(FileWriter file = new FileWriter("savedPlayers.json")) {
            file.write(saveData.toJSONString());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    // Function to load saved games
    /**public static List<Player> loadSaveGames() {
        JSONParser parser = new JSONParser();
        List<Player> savedPlayers = new ArrayList<>();
        
        try (FileReader reader = new FileReader("savedPlayers.json")) {
            Object obj = parser.parse(reader);
            JSONArray saveData = (JSONArray) obj;
            
            for (Object save : saveData) {
                JSONObject saveObj = (JSONObject) save;
                String trainerName = (String) saveObj.get("trainerName");
                String currentLocation = (String) saveObj.get("currentLocation");
                
                // Create Player object form loaded data
                Player player = new Player(trainerName, currentLocation);
                savedPlayers.add(player);
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error loading saved games : " + e.getMessage());
        }
        return savedPlayers;
    }*/
    
    // Function to get the list of saved players
    public static List<Player> getSavedPlayers() {
        return savedPlayers;
    }
    
    public static void updateSavedPlayers() {
        // Save the updated saved games list
        //SaveGameManager.saveSavedPlayers(SaveGameManager.loadSaveGames());
        saveSavedPlayers(getSavedPlayers());
    }
}
