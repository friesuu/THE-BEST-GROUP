package Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Pokemons {

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
    private String[] move = new String[2];
    private int[] damage = new int[2];
    private String[] strength = new String[3];
    private String[] weakness = new String[3];


    public Pokemons (int ID, String name, String type, int level, String move1,int damage1, String move2,int damage2, String strength1, String strength2, String strength3, String weakness1, String weakness2, String weakness3){
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.level = level;
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
}
