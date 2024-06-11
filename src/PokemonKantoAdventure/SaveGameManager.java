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

        JSONObject saveData = new JSONObject();
        JSONArray savePokemon = new JSONArray();
        JSONArray savePokemonLevel = new JSONArray();
        JSONArray savePokemonHP = new JSONArray();
        JSONArray savePokemonXP = new JSONArray();
        JSONObject pokemon = new JSONObject();
        JSONArray saveDefeated = new JSONArray();
        JSONObject defeated = new JSONObject();
        JSONArray saveBadges = new JSONArray();
        JSONObject badges = new JSONObject();
        saveData.put("trainerName", player.getPlayerName());
        saveData.put("currentLocation", player.getLocation().getName());
        for (int i=0; i<player.getPokemon().size(); i++) {
            savePokemon.add(player.getPokemon().get(i).getName());
            savePokemonLevel.add(player.getPokemon().get(i).getLevel());
            savePokemonHP.add(player.getPokemon().get(i).getHp());
            savePokemonXP.add(player.getPokemon().get(i).getXp());
        }

        for(int j = 0; j < player.getBadges().size(); j++){
            saveBadges.add(player.getBadges().get(j));
        }

        for (int k=0;k < player.getDefeatedGym().size(); k++){
            saveDefeated.add(player.getDefeatedGym().get(k));
        }

        saveData.put("earnedBadges",saveBadges);
        saveData.put("pokemonTeam", savePokemon);
        saveData.put("pokemonLevel", savePokemonLevel);
        saveData.put("pokemonHP", savePokemonHP);
        saveData.put("pokemonXP", savePokemonXP);
        saveData.put("defeatedGymLeaders", saveDefeated);



        try (FileWriter file = new FileWriter(filename)) {
            file.write(saveData.toJSONString());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    static List<Player> savedPlayers = new ArrayList<>();



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
            JSONArray pokemonLevel = (JSONArray) saveData.get("pokemonLevel");
            JSONArray pokemonHP = (JSONArray) saveData.get("pokemonHP");
            JSONArray pokemonXP = (JSONArray) saveData.get("pokemonXP");
            JSONArray defeatedGymLeaders = (JSONArray) saveData.get("defeatedGymLeaders");
            String currentLocation = (String) saveData.get("currentLocation");

            // Create Player object from loaded data

            List<Pokemon> tempPokemonList =  new ArrayList<>();
            for (int j=0; j<pokemonTeam.size(); j++) {
                for (int i = 0; i < GameFlow.pokemons.length; i++) {
                    if (pokemonTeam.get(j).equals(GameFlow.pokemons[i].getName())){
                        tempPokemonList.add(GameFlow.pokemons[i]);
                        tempPokemonList.get(j).setLevel(Integer.parseInt( pokemonLevel.get(j).toString()));
                        tempPokemonList.get(j).setHp(Integer.parseInt( pokemonHP.get(j).toString()));
                        tempPokemonList.get(j).setXp(Integer.parseInt( pokemonXP.get(j).toString()));
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

            List<String> tempBadges = new ArrayList<>();
            for (int i=0; i<earnedBadges.size(); i++){
                tempBadges.add(earnedBadges.get(i).toString());
            }
            player.setBadges(tempBadges);


        } catch (IOException | ParseException e) {

        }

        return player;
    }



    public static void addNewPlayer(Player player) {
        if (savedPlayers == null) {
            savedPlayers = new ArrayList<>();
        }
        savedPlayers.add(player);

        // Save the updated saved game list
        //saveSavedPlayers(savedPlayers);
    }

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


}