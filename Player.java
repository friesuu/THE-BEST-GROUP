/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon_assignment;

/**
 *
 * @author user
 */
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String trainerName;
    private String currentLocation;
    private List<Pokemon> pokemonTeam;
    private List<String> defeatedGymLeaders;
    private List<String> earnedBadges;
    
    // Constructor
    public Player(String trainerName, String currentLocation) {
        this.trainerName = trainerName;
        this.currentLocation = currentLocation;
        this.pokemonTeam = new ArrayList();
        this.defeatedGymLeaders = new ArrayList();
        this.earnedBadges = new ArrayList();
    }
    
    // Getter method for trainerName
    public String getTrainerName() {
        return trainerName;
    }
    
    // Setter method for trainerName
    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
    
    // Getter method for currentLocation
    public String getCurrentLocation() {
        return currentLocation;
    }
    
    // Setter method for currentLocation
    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
    
    // Getter method for pokemonTeam
    public List<Pokemon> getPokemonTeam() {
        return pokemonTeam;
    }
    
    // Setter method for pokemonTeam
    public void setPokemonTeam(ArrayList<Pokemon> pokemonTeam) {
        this.pokemonTeam = pokemonTeam;
    }
    
    // Getter method for defeatedGymLeaders
    public List<String> getDefeatedGymLeaders() {
        return defeatedGymLeaders;
    }
    
    // Setter method for defeatedGymLeaders
    public void setDefeatedGymLeaders(List<String> defeatedGymLeaders) {
        this.defeatedGymLeaders = defeatedGymLeaders;
    }
    
    // Getter method for earnedBadges
    public List<String> getEarnedBadges() {
        return earnedBadges;
    }
    
    // Setter method for earnedBadges
    public void setEarnedBadges(List<String> earnedBadges) {
        this.earnedBadges = earnedBadges;
    }
    
    public void addPokemon(Pokemon pokemon) {
        pokemonTeam.add(pokemon);
    }
    
    public void addEarnedBadge(String earnedBadge) {
        earnedBadges.add(earnedBadge);
    }
}
