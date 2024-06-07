package PokemonKantoAdventure;

import java.sql.SQLOutput;

public class Pokemon {

    //THIS CLASS SHOULD BE STRICLY FOR SIMPAN DATAS ABOUT ALL THE POKEMONS, NOT THE PLAYER'S POKEMON

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

    private int ID, level;
    private String name, type;
    private int hp;
    private int xp;
    private String[] move = new String[2];
    private int[] damage = new int[2];
    private String[] strength = new String[3];
    private String[] weakness = new String[3];


    public Pokemon(int ID, String name, String type, int level, String move1, int damage1, String move2, int damage2, String strength1, String strength2, String strength3, String weakness1, String weakness2, String weakness3){
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = 100; //STARTING HP SHOULD BE 100 RIGHT???
        this.xp = 0;
        this.move[0] = move1;
        this.damage[0] = damage1;
        this.move[1] = move2;
        this.damage[1] = damage2;
        this.strength[0] = strength1;
        this.strength[1] = strength2;
        this.strength[2] = strength3;
        this.weakness[0] = weakness1;
        this.weakness[1] = weakness1;
        this.weakness[2] = weakness3;

    }

    public Pokemon(String name, String type, int level, int hp, int xp) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = hp;
        this.xp = xp;
    }

    public void gainXp(int amount) {
        xp += amount;
        if (xp >= 100) {
            levelUp();
            xp = xp - 100;
        }
    }

    private void levelUp() {
        level++;
        hp += 10;
        System.out.println(name + " leveled up to level " + level + "!");
    }


    public int calculateDamage(int index, Pokemon oppponent) {
        int baseDamage = damage[index];

        for (int i=0; i<3; i++) {
            if (strength[i].equalsIgnoreCase(oppponent.getType())) {             // 20% increase damage
                baseDamage *= 1.2;
                System.out.println("It's super effective!");
                System.out.printf("%s's HP drops significantly. [%s HP: %d/100]\n", oppponent.getName(), oppponent.getName(), oppponent.hp-baseDamage);
                break;
            } else if (weakness[i].equalsIgnoreCase(oppponent.getType())) {        // 20% decrease damage
                baseDamage *= 0.8;
                System.out.printf("%s's dHP drops slightly. [%s HP: %d/100]\n", oppponent.getName(), oppponent.getName(), oppponent.hp-baseDamage);
                break;
            } else{
                System.out.printf("%s take some damage. [%s HP: %d/100]\n", oppponent.getName(), oppponent.getName(), oppponent.hp-baseDamage);
                break;
            }
        }

        return baseDamage;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0)
            hp = 0;
    }

    public boolean isFaintedChecker() {
        return hp <= 0;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nLevel: %d\nType: %s\nHP: %d\nXP: %d/100\nMoves: %s, %s\nStrong Against: %s, %s, %s\nWeak Against: %s, %s, %s",
                name, level, type, hp, xp, move[0], move[1], strength[0], strength[1], strength[2], weakness[0], weakness[1], weakness[2]);
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

    public void printMove() {
        System.out.println("1.  " + move[0] );
        System.out.println("2.  " + move[1] );
    }

    public String[] getMove(){
        return move;
    }

    public void setMove(String[] move) {
        this.move = move;
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

    public String[] getWeakness() {
        return weakness;
    }

    public void setWeakness(String[] weakness) {
        this.weakness = weakness;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
