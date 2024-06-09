package PokemonKantoRegion;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityManager extends HashMap<String, Cities>
{
    public Map<String, Cities> cities;
    //private static String currentCity = "Pallet Town"; // Start at Pallet Town

    public CityManager()
    {
        cities = new HashMap<>();
        initializeCities();
    }    

    public void initializeCities() 
    {
        cities.put("Pallet Town", new Cities("Pallet Town", Arrays.asList("Viridian City", "Cinnabar Island"), "", "", Collections.emptyList()));
        cities.put("Viridian City", new Cities("Viridian City", Arrays.asList("Pallet Town", "Pewter City"), "Giovanni", "Ground", Arrays.asList("Pidgey", "Ratata", "Spearow")));
        cities.put("Cinnabar Island", new Cities("Cinnabar Island", Arrays.asList("Pallet Town", "Fuschia City"), "Blaine", "Fire", Arrays.asList("null")));
        cities.put("Fuschia City", new Cities("Fuschia City", Arrays.asList("Cinnabar Island", "Celadon City", "Lavender Town", "Vermillion City"), "Koga", "Poison", Arrays.asList("null")));
        cities.put("Celadon City", new Cities("Celadon CIty", Arrays.asList("Fuschia City", "Saffron City"), "Erika", "Grass", Arrays.asList("null")));
        cities.put("Vermillion City", new Cities("Vermillion City", Arrays.asList("Fuschia City", "Saffron City", "Lavender Town"), "Lt. Surge", "Electric", Arrays.asList("null")));
        cities.put("Lavender Town", new Cities("Lavender Town", Arrays.asList("Fuschia City", "Saffron City", "Vermillion City", "Cerulean City"), "null", "null", Arrays.asList("null")));
        cities.put("Cerulean City", new Cities("Cerulean City", Arrays.asList("Lavender Town", "Saffron City", "Pewter City"), "Misty", "Water", Arrays.asList("null")));
        cities.put("Pewter City", new Cities("Pewter city", Arrays.asList("Cerulean City", "Viridian City"), "Brock", "Rock", Arrays.asList("null")));
        cities.put("Saffron City", new Cities("Saffron City", Arrays.asList("Cerulean City", "Lavender Town", "Celadon City", "Vermillion City"), "Sabrina", "Psychic", Arrays.asList("null")));
        // Add more cities and their properties as needed...
    }
}
