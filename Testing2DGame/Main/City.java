package Testing2DGame.Main;

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
    private String badge;

    public City(String name,String badge, List<String> adjacentCities, String gymLeader, String gymType, List<List<String>> gymLeaderPokemon, List<List<String>> wildPokemons)
    {
        this.name = name;
        this.badge = badge;
        this.adjacentCities = adjacentCities;
        this.gymLeader = gymLeader;
        this.gymType = gymType;


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

    public void setWildPokemon(List<List<String>> wildPokemonNames) {
        int i=0;
        this.wildPokemon.clear(); // Ensure the list is empty before adding new Pokemon
        for (List<String> name : wildPokemonNames) {
            for (Pokemon pokemon : GameFlow.pokemons) {
                if (pokemon.getName().equalsIgnoreCase(name.get(0))) {
                    this.wildPokemon.add(pokemon);
                    this.wildPokemon.get(i).setLevel(Integer.parseInt(name.get(1)));
                    break; // Break the inner loop once a match is found
                }
            }
        }
    }

    public void setGymLeaderPokemon(List<List<String>> gymLeaderPokemon) {
        int i=0;
        this.gymLeaderPokemon.clear(); // Ensure the list is empty before adding new Pokemon
        for (List<String> name : gymLeaderPokemon) {
            for (Pokemon pokemon : GameFlow.pokemons) {
                if (pokemon.getName().equalsIgnoreCase(name.get(0))) {
                    this.gymLeaderPokemon.add(pokemon);
                    this.gymLeaderPokemon.get(i).setLevel(Integer.parseInt(name.get(1)));
                    break; // Break the inner loop once a match is found
                }
            }
        }
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
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