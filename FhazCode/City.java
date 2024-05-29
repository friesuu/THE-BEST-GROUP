package FhazCode;

import java.util.List;

public class City 
{
    private String name;
    private List<String> adjacentCities;
    private String gymLeader;
    private String gymType;
    private List<String> wildPokemon;

    public City(String name, List<String> adjacentCities, String gymLeader, String gymType, List<String> wildPokemon) 
    {
        this.name = name;
        this.adjacentCities = adjacentCities;
        this.gymLeader = gymLeader;
        this.gymType = gymType;
        this.wildPokemon = wildPokemon;
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

    public List<String> getWildPokemon() 
    {
        return wildPokemon;
    }
}
