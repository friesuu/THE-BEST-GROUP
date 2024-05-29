package FhazCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityManager extends HashMap<String, City>
{
    public static Map<String, City> cities;
    public static String currentCity = "Pallet Town"; // Start at Pallet Town

    public CityManager()
    {
        cities = new HashMap<>();
        initializeCities();
    }    

    public void initializeCities() 
    {
        cities.put("Pallet Town", new City("Pallet Town", Arrays.asList("Viridian City", "Cinnabar Island"), "", "", Collections.emptyList()));
        cities.put("Viridian City", new City("Viridian City", Arrays.asList("Pallet Town", "Pewter City"), "Giovanni", "Ground", Arrays.asList("Pidgey", "Ratata", "Spearow")));
        cities.put("Cinnabar Island", new City("Cinnabar Island", Arrays.asList("Pallet Town", "Fuschia City"), "Blaine", "Fire", Arrays.asList("null")));
        cities.put("Fuschia City", new City("Fuschia City", Arrays.asList("Cinnabar Island", "Celadon City", "Lavender Town", "Vermillion City"), "Koga", "Poison", Arrays.asList("null")));
        cities.put("Celadon City", new City("Celadon CIty", Arrays.asList("Fuschia City", "Saffron City"), "Erika", "Grass", Arrays.asList("null")));
        cities.put("Vermillion City", new City("Vermillion City", Arrays.asList("Fuschia City", "Saffron City", "Lavender Town"), "Lt. Surge", "Electric", Arrays.asList("null")));
        cities.put("Lavender Town", new City("Lavender Town", Arrays.asList("Fuschia City", "Saffron City", "Vermillion City", "Cerulean City"), "null", "null", Arrays.asList("null")));
        cities.put("Cerulean City", new City("Cerulean City", Arrays.asList("Lavender Town", "Saffron City", "Pewter City"), "Misty", "Water", Arrays.asList("null")));
        cities.put("Pewter City", new City("Pewter city", Arrays.asList("Cerulean City", "Viridian City"), "Brock", "Rock", Arrays.asList("null")));
        cities.put("Saffron City", new City("Saffron City", Arrays.asList("Cerulean City", "Lavender Town", "Celadon City", "Vermillion City"), "Sabrina", "Psychic", Arrays.asList("null")));
        // Add more cities and their properties as needed...
    }
}
