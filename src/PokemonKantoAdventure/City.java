package PokemonKantoAdventure;

import javax.swing.plaf.FontUIResource;
import java.util.ArrayList;
import java.util.List;

public class City
{
    private String name;
    private List<String> adjacentCities;
    private String gymLeader;
    private String gymType;
    private List<Pokemon> wildPokemon = new ArrayList<>();
    private List<Pokemon> gymLeaderPokemon = new ArrayList<>();

    public City(String name, List<String> adjacentCities, String gymLeader, String gymType, List<String> gymLeaderPokemon, List<String> wildPokemons)
    {
        this.name = name;
        this.adjacentCities = adjacentCities;
        this.gymLeader = gymLeader;
        this.gymType = gymType;
        //CHANGE TO ANOTHER ARRAY DONT USE WILDPOKEMON
//        for(int j=0; j<wildPokemon.size(); j++) {
//            for (int i = 0; i < GameFlow.pokemons.length; i++) {
//                if (GameFlow.pokemons[i].getName().equalsIgnoreCase(wildPokemon.get(j))){
//                    this.wildPokemon.add(GameFlow.pokemons[i]);
//                }
//            }
//        }

        setWildPokemon(wildPokemons);
        setGymLeaderPokemon(gymLeaderPokemon);



    }

    public String getName()
    {
        return name;
    }

    public List<String> getAdjacentCities()
    {
        return adjacentCities;
    }

    public String getGymLeader()
    {
        return gymLeader;
    }

    public String getGymType()
    {
        return gymType;
    }

    public List<Pokemon> getWildPokemon()
    {
        return wildPokemon;
    }

    public List<Pokemon> getGymLeaderPokemon() {
        return gymLeaderPokemon;
    }

    public void setWildPokemon(List<String> wildPokemonNames) {
        this.wildPokemon.clear(); // Ensure the list is empty before adding new Pokemon
        for (String name : wildPokemonNames) {
            for (Pokemon pokemon : GameFlow.pokemons) {
                if (pokemon.getName().equalsIgnoreCase(name)) {
                    this.wildPokemon.add(pokemon);
                    break; // Break the inner loop once a match is found
                }
            }
        }
    }

    public void setGymLeaderPokemon(List<String> gymLeaderPokemon) {
        this.gymLeaderPokemon.clear(); // Ensure the list is empty before adding new Pokemon
        for (String name : gymLeaderPokemon) {
            for (Pokemon pokemon : GameFlow.pokemons) {
                if (pokemon.getName().equalsIgnoreCase(name)) {
                    this.gymLeaderPokemon.add(pokemon);
                    break; // Break the inner loop once a match is found
                }
            }
        }
    }

    public String printWildPokemon() {
        StringBuilder fullString = new StringBuilder();

        for (int i = 0; i < this.wildPokemon.size(); i++) {
            if (i > 0) {
                fullString.append(", ");
            }
            fullString.append(wildPokemon.get(i).getName());
        }

        return fullString.toString();
    }

    @Override
    public String toString() {
        return name;
    }
}
