package PokemonKantoAdventure;
//package pokemon_assignment;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
public class SaveGameManager {

    private static Player currentPlayer;
    // Function to save a game process
    public static void saveGame(Player player, String filename) {

//        JSONArray personArray = new JSONArray();
//        for (int i = 0; i < names.length; i++) {
//            JSONObject personObject = new JSONObject();
//            personObject.put("name", names[i]);
//            personObject.put("age", ages[i]);
//            personObject.put("email", emails[i]);
//            personArray.add(personObject);
//        }

        //TO LOAD JSON
//        public Player (String playerName, List<Pokemon> pokemon)
//        ID = ID;
//        this.name = name;
//        this.type = type;
//        this.level = level;
//        this.move[0] = move1;
//        this.damage[0] = damage1;
//        this.move[1] = move2;
//        this.damage[1] = damage2;
//        this.strength[0] = strength1;
//        this.strength[1] = strength2;
//        this.strength[2] = strength3;
//        this.weakness[0] = weakness1;
//        this.weakness[1] = weakness1;
//        this.weakness[2] = weakness


        JSONObject saveData = new JSONObject();
        JSONArray savePokemon = new JSONArray();
        JSONObject pokemon = new JSONObject();
        JSONArray saveDefeated = new JSONArray();
        JSONObject defeated = new JSONObject();
        JSONArray saveBadges = new JSONArray();
        JSONObject badges = new JSONObject();
        saveData.put("trainerName", player.getPlayerName());
        saveBadges.add("to be added in the class");
        saveData.put("earnedBadges",saveBadges);
        saveDefeated.add("to be added in the class");
        saveData.put("defeatedGymLeaders", saveDefeated);
        saveData.put("currentLocation", player.getLocation().getName());
        for (int i=0; i<player.getPokemon().size(); i++){
            savePokemon.add(player.getPokemon().get(i).getName());
            // FOR NOW JUST NAME, LATER ADD LEVELS TOO
        }
        saveData.put("pokemonTeam", savePokemon);





        try (FileWriter file = new FileWriter(filename)) {
            file.write(saveData.toJSONString());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    static List<Player> savedPlayers = new ArrayList<>();

    // Function to display saved games
//    public static void displaySavedGames() {
//        List<Player> savedPlayers = SaveGameManager.getSavedPlayers();
//        System.out.println("+---------------------------------------------------------------------------------+");
//        System.out.println("Saved Games ...");
//        System.out.println("+---------------------------------------------------------------------------------+");
//        for(int i = 0; i < savedPlayers.size(); i++) {
//            Player player = savedPlayers.get(i);
//            System.out.println("        " + (i + 1) + ". " + player.getPlayerName());
//        }
//    }

    //Function to load save game
    /**public static List<Player> loadGame() {
     File folder = new File("saves/");
     File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));
     List<Player> savedPlayers = new ArrayList<>();

     for (File file : files) {
     try {
     String jsonString = new String(Files.readAllBytes(file.toPath()));
     Player player = new GsonBuilder().create().fromJson(jsonString, PokemonKantoAdventure.Player.class);
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
            JSONArray earnedBadges = (JSONArray) saveData.get("earnedBadges");
            JSONArray pokemonTeam = (JSONArray) saveData.get("pokemonTeam");
            JSONArray defeatedGymLeaders = (JSONArray) saveData.get("defeatedGymLeaders");
            String currentLocation = (String) saveData.get("currentLocation");

            // Create Player object from loaded data

            List<Pokemon> tempPokemonList =  new ArrayList<>();
            for (int j=0; j<pokemonTeam.size(); j++) {
                for (int i = 0; i < GameFlow.pokemons.length; i++) {
                    if (pokemonTeam.get(j).equals(GameFlow.pokemons[i].getName())){
                        tempPokemonList.add(GameFlow.pokemons[i]);
                        //ADD ON LEVEL BERAPA HERE USING SETLEVEL METHOD
                    }
                }
            }

            player = new Player(trainerName, tempPokemonList);
            
            City tempLoc = null;

            for (Map.Entry<String, City> entry : CityManager.cities.entrySet()) {
                String cityName = entry.getKey();
                City city = entry.getValue();
                if (currentLocation.equalsIgnoreCase(cityName)){
                    tempLoc = city;
                }
            }
            player.setLocation(tempLoc);

//            player.setPokemonTeam((ArrayList<Pokemon>) pokemonTeam);
//            player.setDefeatedGymLeaders((ArrayList<String>) defeatedGymLeaders);
//            player.setEarnedBadges((ArrayList<String>) earnedBadges);
        } catch (IOException | ParseException e) {
            //System.out.println("Error loading game : " + e.getMessage());
            // Handling error loading game
        }

        return player;
    }

    // Function to add new player to the saved game list
//    public static void addNewPlayer(Player player) {
//        //savedPlayers = new ArrayList<>();
//        savedPlayers.add(player);
//
//        // Save the updates saved game list
//        saveSavedPlayers(savedPlayers);
//    }

    public static void addNewPlayer(Player player) {
        if (savedPlayers == null) {
            savedPlayers = new ArrayList<>();
        }
        savedPlayers.add(player);

        // Save the updated saved game list
        //saveSavedPlayers(savedPlayers);
    }

    // Function to load saved games
    /**public static List<PokemonKantoAdventure.Player> loadSaveGames() {
     JSONParser parser = new JSONParser();
     List<PokemonKantoAdventure.Player> savedPlayers = new ArrayList<>();

     try (FileReader reader = new FileReader("savedPlayers.json")) {
     Object obj = parser.parse(reader);
     JSONArray saveData = (JSONArray) obj;

     for (Object save : saveData) {
     JSONObject saveObj = (JSONObject) save;
     String trainerName = (String) saveObj.get("trainerName");
     String currentLocation = (String) saveObj.get("currentLocation");

     // Create PokemonKantoAdventure.Player object form loaded data
     PokemonKantoAdventure.Player player = new PokemonKantoAdventure.Player(trainerName, currentLocation);
     savedPlayers.add(player);
     }
     } catch (IOException | ParseException e) {
     System.out.println("Error loading saved games : " + e.getMessage());
     }
     return savedPlayers;
     }*/

    // Function to get the list of saved players
    public static List<Player> getSavedPlayers() {

        List<Player> tempPlayerList = new ArrayList<>();

        for (int saveNumber=0; saveNumber<3 ; saveNumber++) {
            String filename = "save" + saveNumber + ".json";
            Player loadedPlayer = SaveGameManager.loadGame(filename);
            if (loadedPlayer == null) {
                //GameFlow.switchToLoadedPlayerGame(loadedPlayer);
                tempPlayerList.add(null);
            }
            else
                tempPlayerList.add(loadedPlayer);
        }

        savedPlayers = tempPlayerList;

        return tempPlayerList;
    }

//    public static void updateSavedPlayers() {
//        // Save the updated saved games list
//        //SaveGameManager.saveSavedPlayers(SaveGameManager.loadSaveGames());
//        saveSavedPlayers(getSavedPlayers());
//    }
}