package Testing2DGame.Main;

import java.util.ArrayList;
import java.util.List;

public class Player1 
{

    // VARIABLES
    private String playerName;
    private List<Pokemon> pokemon;
    private int HP;
    private int XP;
    private List<String> badges;
    private List<String> defeatedGym;

    //private String location;  //should we make another class for location?

    ///UPDATE: use PokemonKantoAdventure.City class for location
    private City location;


    // 1. CONSTRUCTOR
    // receive: 1.PokemonKantoAdventure.Player name, 2. chosen pokemon, ??
    public Player1 (String playerName, List<Pokemon> pokemon){
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

    public void addDefeatedGym(String gym) {
        defeatedGym.add(gym);
    }


    public void showBadges() {
        System.out.println("Your Badges:");

        if (badges.size() != 0) {
            for (int i = 0; i < getBadges().size(); i++) {
                System.out.printf("- %s\n", getBadges().get(i));
            }
        }
        else {
            System.out.println("- None");
        }
        System.out.println("+--------------------------------------------------------------------------------------------+");

    }

    public void showPokemon() { // method to show all pokemon yang wujud
        System.out.println("Your Pokémon:");
        for (int i=0; i<getPokemon().size(); i++){
            System.out.println(pokemon.get(i));
            System.out.println();
        }
        System.out.println("+--------------------------------------------------------------------------------------------+");

    }




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


    public void setBadges(List<String> badges) {
        this.badges = badges;
    }

    public void setLocation(City location) {
        this.location = location;
    }

    public List<String> getDefeatedGym() {
        return defeatedGym;
    }

    public void setDefeatedGym(List<String> defeatedGym) {
        this.defeatedGym = defeatedGym;
    }
}


















//     // GETTER SETTER METHODS


//     public String getPlayerName() {
//         return playerName;
//     }

//     public void setPlayerName(String playerName) {
//         this.playerName = playerName;
//     }

//     public Pokemons getPokemon() {
//         return pokemon;
//     }

//     public void setPokemon(Pokemons pokemon) {
//         this.pokemon = pokemon;
//     }

//     public int getHP() {
//         return HP;
//     }

//     public void setHP(int HP) {
//         this.HP = HP;
//     }

//     public int getXP() {
//         return XP;
//     }

//     public void setXP(int XP) {
//         this.XP = XP;
//     }

//     public City getLocation() {
//         return location;
//     }

//     public void setLocation(City location) {
//         this.location = location;
//     }
// }