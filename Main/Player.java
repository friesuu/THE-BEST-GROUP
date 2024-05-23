package Main;

public class Player {

    // VARIABLES
    private String playerName;
    private Pokemons pokemon;
    private int HP;
    private int XP;

    //private String location;  //should we make another class for location?

    ///UPDATE: use City class for location
    private City location;


    // 1. CONSTRUCTOR
    // receive: 1.Player name, 2. chosen pokemon, ??
    public Player (String playerName, Pokemons pokemon){
        this.playerName = playerName;
        this.pokemon = pokemon;
        HP = 0;
        XP = 0;
        location = CityManager.cities.get("Pallet Town");

    }


















    // GETTER SETTER METHODS


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Pokemons getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemons pokemon) {
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
