package Main;

public class PlayersPokemon {

//    private int[] ID = new int[4];
//    private String[] pokemonName = new String[4];
//    private String[] type = new String[4];
//    private int[] level = new int[4];
//    private String[] move1 = new String[4];
//    private int[] damage1 = new int[4];
//    private String[] move2 = new String[4];
//    private int[] damage2 = new int[4];
//    private String[] strength1 = new String[4];
//    private String[] strength2 = new String[4];
//    private String[] strength3 = new String[4];
//    private String[] weakness1 = new String[4];
//    private String[] weakness2 = new String[4];
//    private String[] weakness3 = new String[4];


    // CONSTRUCTOR
    // receive:

    private int ID, level;
    private String name, type;
    private String[] move = new String[2];
    private int[] damage = new int[2];
    private String[] strength = new String[3];
    private String[] weakness = new String[3];


    public PlayersPokemon (Pokemons pokemons){
        this.ID = pokemons.getID();
        this.name = pokemons.getName();
        this.type = pokemons.getType();
        this.level = pokemons.getLevel();
        this.move = pokemons.getMove();
        this.damage = pokemons.getDamage();
        this.strength = pokemons.getStrength();
        this.weakness = pokemons.getWeakness();
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getMove() {
        return move;
    }

    public void setMove(String[] move) {
        this.move = move;
    }

    public String printMove (int index){
        return move[index];
    }

    public int[] getDamage() {
        return damage;
    }

    public void setDamage(int[] damage) {
        this.damage = damage;
    }

    public String[] getStrength() {
        return strength;
    }

    public void setStrength(String[] strength) {
        this.strength = strength;
    }
}
