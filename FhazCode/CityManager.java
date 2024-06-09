package FhazCode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CityManager extends HashMap<String, City>
{
    public static Map<String, City> cities;
    static String currentCity = "Pallet Town"; // Start at Pallet Town

    public CityManager()
    {
        cities = new HashMap<>();
        initializeCities();
    }

    public void initializeCities()
    {
        cities.put("Pallet Town", new City("Pallet Town", Arrays.asList("Viridian City", "Cinnabar Island"), "null", "",Arrays.asList("null"),  Arrays.asList("Pidgey", "Meowth", "Scyther")));
        cities.put("Viridian City", new City("Viridian City", Arrays.asList("Pallet Town", "Pewter City"), "Giovanni", "Ground", Arrays.asList("Rhyhorn", "Rhydon"),  Arrays.asList("Sandshrew", "Diglett", "Cubone")));
        cities.put("Cinnabar Island", new City("Cinnabar Island", Arrays.asList("Pallet Town", "Fuschia City"), "Blaine", "Fire", Arrays.asList("Ninetales", "Rhydon", "Magmar"), Arrays.asList("Charmander", "Vulpix")));
        cities.put("Fuschia City", new City("Fuschia City", Arrays.asList("Cinnabar Island", "Celadon City", "Lavender Town", "Vermillion City"), "Koga", "Poison", Arrays.asList("Venonat", "Rhydon", "Scyther"),  Arrays.asList("Nidoran", "Koffing", "Ekans")));
        cities.put("Celadon City", new City("Celadon CIty", Arrays.asList("Fuschia City", "Saffron City"), "Erika", "Grass",Arrays.asList("Tangela", "Weepinbell", "Gloom"),  Arrays.asList("Tangela", "Belossom", "Bayleef")));
        cities.put("Vermillion City", new City("Vermillion City", Arrays.asList("Fuschia City", "Saffron City", "Lavender Town"), "Lt. Surge", "Electric",Arrays.asList("Raichu"),  Arrays.asList("Pikachu", "Voltorb", "Pichu")));
        //LAVENDER TOWN BELUM ADA WILD POKEMON
        cities.put("Lavender Town", new City("Lavender Town", Arrays.asList("Fuschia City", "Saffron City", "Vermillion City", "Cerulean City"), "null", "null",Arrays.asList("null"),  Arrays.asList("null")));
        cities.put("Cerulean City", new City("Cerulean City", Arrays.asList("Lavender Town", "Saffron City", "Pewter City"), "Misty", "Water",Arrays.asList("Staryu", "Starmie", "Corsola", "Psyduck"),  Arrays.asList("Poliwag", "Psyduck", "Krabby")));
        cities.put("Pewter City", new City("Pewter city", Arrays.asList("Cerulean City", "Viridian City"), "Brock", "Rock",Arrays.asList("Geodude", "Onix"),  Arrays.asList("Roggenrola", "Regirock")));
        cities.put("Saffron City", new City("Saffron City", Arrays.asList("Cerulean City", "Lavender Town", "Celadon City", "Vermillion City"), "Sabrina", "Psychic", Arrays.asList("Alakazam"),  Arrays.asList("Abra", "Drowzee", "Mew", "Mewtwo")));
    }
}