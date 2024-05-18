package PokemonKantoAdventure;

import java.util.*;

// Class representing a city in the Kanto region
class City {
    private String name;
    private GymLeader gymLeader;
    private Set<String> wildPokemon;
    private Map<String, City> neighbors; // Map of neighboring cities (name -> city)

    public City(String name, GymLeader gymLeader, Set<String> wildPokemon) {
        this.name = name;
        this.gymLeader = gymLeader;
        this.wildPokemon = wildPokemon;
        this.neighbors = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public GymLeader getGymLeader() {
        return gymLeader;
    }

    public Set<String> getWildPokemon() {
        return wildPokemon;
    }

    public void addNeighbor(City neighbor) {
        neighbors.put(neighbor.getName(), neighbor);
    }

    public City getNeighbor(String neighborName) {
        return neighbors.get(neighborName);
    }

    public Map<String, City> getNeighbors() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNeighbors'");
    }
}

// Class representing a Gym Leader
class GymLeader {
    private String name;
    private String type;

    public GymLeader(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}

// Main class to manage the map and simulate the game
public class KantoRegion {
    private Map<String, City> cities; // Map of cities (name -> city)
    private City currentCity;

    public KantoRegion() {
        cities = new HashMap<>();
        initializeCities();
        // Set starting city (Pallet Town as an example)
        currentCity = cities.get("Pallet Town");
    }

    private void initializeCities() {
        // Define cities with gym leaders and wild Pokémon
        GymLeader brock = new GymLeader("Brock", "Rock");
        GymLeader misty = new GymLeader("Misty", "Water");
        // Define wild Pokémon sets for each city
        Set<String> palletTownPokemon = new HashSet<>(Arrays.asList("Pidgey", "Rattata"));
        Set<String> pewterCityPokemon = new HashSet<>(Arrays.asList("Geodude", "Onix"));
        // Create cities and add to map
        City palletTown = new City("Pallet Town", null, palletTownPokemon);
        City pewterCity = new City("Pewter City", brock, pewterCityPokemon);
        // Add connections between cities
        palletTown.addNeighbor(pewterCity);
        pewterCity.addNeighbor(palletTown);
        // Add cities to map
        cities.put("Pallet Town", palletTown);
        cities.put("Pewter City", pewterCity);
        // Add other cities, gym leaders, and connections similarly...
    }

    public void printCityOptions() {
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("You are currently in " + currentCity.getName() + ":");
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("[1] Move to:");
        int optionNum = 1;
        for (String neighborName : currentCity.getNeighbors().keySet()) {
            System.out.println(optionNum + ": " + neighborName);
            optionNum++;
        }
        System.out.println("[2] Challenge Gym leader [" + currentCity.getGymLeader().getName() +
                           " - " + currentCity.getGymLeader().getType() + " type]");
        System.out.println("[3] Fight Wild Pokemon " + currentCity.getWildPokemon() + " are common");
        System.out.println("[4] Player Options");
        System.out.println("a. Show map");
        System.out.println("b. Show My Pokemon");
        System.out.println("c. Show My badges");
        System.out.println("d. Save and Exit");
        System.out.println("+----------------------------------------------------------------------+");
    }

    public void moveCity(String cityName) {
        City neighbor = currentCity.getNeighbor(cityName);
        if (neighbor != null) {
            currentCity = neighbor;
            System.out.println("Moving to " + cityName + "...");
        } else {
            System.out.println("Invalid city selection.");
        }
    }

    // Main method to simulate gameplay
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KantoRegion kantoMap = new KantoRegion();

        while (true) {
            kantoMap.printCityOptions();
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("a") || choice.equals("b") || choice.equals("c") || choice.equals("d")) {
                // Handle player options
                // Implement logic based on player's choice
                System.out.println("Selected player option: " + choice);
            } else if (choice.matches("[1-9]+")) {
                // Handle city movement
                int option = Integer.parseInt(choice);
                if (option >= 1 && option <= kantoMap.currentCity.getNeighbors().size()) {
                    List<String> neighbors = new ArrayList<>(kantoMap.currentCity.getNeighbors().keySet());
                    kantoMap.moveCity(neighbors.get(option - 1));
                } else {
                    System.out.println("Invalid option.");
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
