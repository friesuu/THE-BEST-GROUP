package PokemonKantoAdventure;

import PokemonKantoAdventure.City;

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

            cities.put("Pallet Town", new City("Pallet Town", null, Arrays.asList("Viridian City", "Cinnabar Island"), "null", "", Arrays.asList(Arrays.asList("null", "0")), Arrays.asList(Arrays.asList("Pidgey", "2"), Arrays.asList("Meowth", "3"), Arrays.asList("Scyther", "3"))));
            cities.put("Viridian City", new City("Viridian City", "Earth Badge", Arrays.asList("Pallet Town", "Pewter City"), "Giovanni", "Ground", Arrays.asList(Arrays.asList("Rhyhorn", "12"), Arrays.asList("Rhydon", "13")), Arrays.asList(Arrays.asList("Sandshrew", "12"), Arrays.asList("Diglett", "13"), Arrays.asList("Cubone", "14"))));
            cities.put("Cinnabar Island", new City("Cinnabar Island", "Volcano Badge", Arrays.asList("Pallet Town", "Fuschia City"), "Blaine", "Fire", Arrays.asList(Arrays.asList("Ninetales", "9"), Arrays.asList("Rhydon", "10"), Arrays.asList("Magmar", "11")), Arrays.asList(Arrays.asList("Charmander", "10"), Arrays.asList("Vulpix", "11"))));
            cities.put("Fuschia City", new City("Fuschia City", "Soul Badge", Arrays.asList("Cinnabar Island", "Celadon City", "Lavender Town", "Vermillion City"), "Koga", "Poison", Arrays.asList(Arrays.asList("Venonat", "6"), Arrays.asList("Rhydon", "7"), Arrays.asList("Scyther", "8")), Arrays.asList(Arrays.asList("Nidoran","7"), Arrays.asList("Koffing", "8"), Arrays.asList("Ekans", "8"))));
            cities.put("Celadon City", new City("Celadon CIty", "Rainbow Badge", Arrays.asList("Fuschia City", "Saffron City"), "Erika", "Grass", Arrays.asList(Arrays.asList("Tangela","5"), Arrays.asList("Weepinbell", "6"), Arrays.asList("Gloom", "7")), Arrays.asList(Arrays.asList("Tangela", "6"), Arrays.asList("Belossom","7"), Arrays.asList("Bayleef","7"))));
            cities.put("Vermillion City", new City("Vermillion City", "Thunder Badge", Arrays.asList("Fuschia City", "Saffron City", "Lavender Town"), "Lt. Surge", "Electric", Arrays.asList(Arrays.asList("Raichu","5")), Arrays.asList(Arrays.asList("Pikachu","5"), Arrays.asList("Voltorb", "5"), Arrays.asList("Pichu", "6"))));
            cities.put("Lavender Town", new City("Lavender Town", null, Arrays.asList("Fuschia City", "Saffron City", "Vermillion City", "Cerulean City"), "null", "null", Arrays.asList(Arrays.asList("null", "0")), Arrays.asList(Arrays.asList("Staryu", "2"), Arrays.asList("Drowzee", "1"))));
            cities.put("Cerulean City", new City("Cerulean City", "Cascade Badge", Arrays.asList("Lavender Town", "Saffron City", "Pewter City"), "Misty", "Water", Arrays.asList(Arrays.asList("Staryu","2"), Arrays.asList("Starmie","3"), Arrays.asList("Corsola","3"), Arrays.asList("Psyduck", "4")), Arrays.asList(Arrays.asList("Poliwag","3"), Arrays.asList("Psyduck", "4"),Arrays.asList( "Krabby", "5"))));
            cities.put("Pewter City", new City("Pewter city", "Boulder Badge", Arrays.asList("Cerulean City", "Viridian City"), "Brock", "Rock", Arrays.asList(Arrays.asList("Geodude", "1"), Arrays.asList("Onix", "2")), Arrays.asList(Arrays.asList("Roggenrola","1"), Arrays.asList("Regirock","2"))));
            cities.put("Saffron City", new City("Saffron City", "Marsh Badge", Arrays.asList("Cerulean City", "Lavender Town", "Celadon City", "Vermillion City"), "Sabrina", "Psychic", Arrays.asList(Arrays.asList("Alakazam", "9")), Arrays.asList(Arrays.asList("Abra", "8"), Arrays.asList("Drowzee", "8"), Arrays.asList("Mew","9"), Arrays.asList("Mewtwo", "10"))));

    }
}
