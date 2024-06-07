package PokemonKantoAdventure;

import PokemonKantoAdventure.City;
import PokemonKantoAdventure.CityManager;
import PokemonKantoAdventure.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Player {

    // VARIABLES
    private String playerName;
    private List<Pokemon> pokemon;
    private int HP;
    private int XP;
    private List<String> badges;

    //private String location;  //should we make another class for location?

    ///UPDATE: use PokemonKantoAdventure.City class for location
    private City location;


    // 1. CONSTRUCTOR
    // receive: 1.PokemonKantoAdventure.Player name, 2. chosen pokemon, ??
    public Player (String playerName, List<Pokemon> pokemon){
        this.playerName = playerName;
        this.pokemon = pokemon;
        HP = 0;
        XP = 0;
        location = CityManager.cities.get("Pallet Town");
        this.badges = new ArrayList<>();

    }

    public List<String> getBadges() {
        return badges;
    }

    public void addBadge(String badge) {
        badges.add(badge);
    }

    public void showBadges() {
        if (badges.isEmpty()) {
            System.out.println("Your Badges:- None");
        } else {
            System.out.println("Your Badges:- " + String.join(", ", badges));
        }
    }

//    public void showPokemon() { // method to show all pokemon yang wujud
//        if (pokemonTeam.isEmpty()) {
//            System.out.println("You have no Pokémon.");
//        }
//        else {
//            System.out.println("Your Pokemon: ");
//            for (int i = 0; i < pokemonTeam.size();i++) {
//                System.out.println("Pokemon " + (i+1)+ ":");
//                System.out.println(pokemonTeam.get(i));
//            }
//        }
//    }

//    public void displayPokemon(String name){
//        for(int i=0 ; i<pokemonTeam.size() ; i++){
//            if(name.equalsIgnoreCase(pokemonTeam.get(i).getName())){
//                System.out.println(pokemonTeam.get(i));
//            }
//        }
//    }


    // GETTER SETTER METHODS


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List <Pokemon> getPokemon() {
        return pokemon;
    }

    public String printPokemon (){
        String listed = "[";

        for (int i=0; i<pokemon.size(); i++){
            if (i == pokemon.size()-1){
                listed += pokemon.get(i).getName()+ "]";
                break;
            }
            listed += pokemon.get(i).getName() + ",";
        }

        return listed;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public City getLocation() {
        return location;
    }



    public void setLocation(City location) {
        this.location = location;
    }


}
