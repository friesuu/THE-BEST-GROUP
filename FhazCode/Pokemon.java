package FhazCode;

import java.sql.SQLOutput;

public class Pokemon {

    private int ID, level, speed;
    private String name, type;
    private int hp;
    private int xp;
    private String[] move = new String[2];
    private int[] damage = new int[2];
    private String[] strength = new String[3];
    private String[] weakness = new String[3];


    public Pokemon(int ID, String name, String type, int level, String move1, int damage1, String move2, int damage2, String strength1, String strength2, String strength3, String weakness1, String weakness2, String weakness3, int speed){
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = 100;
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
        this.speed = speed;
    }

    public Pokemon(String name, String type, int level, int hp, int xp) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = hp;
        this.xp = xp;
    }

    public void gainXp(int amount) {
        System.out.printf("%s gained %dxp.\n", name, amount);
        xp += amount;

        if (level>=1 && level<=10) {

            if (xp>=100){
                levelUp();
                xp = xp - 100;
            }

            System.out.printf("%s [XP: %d/100]\n\n", name, xp );

        } else if (level>=11 && level<=30){

            if (xp>=200){
                levelUp();
                xp = xp - 200;
            }
            System.out.printf("%s [XP: %d/200]\n\n", name, xp );
        } else{
            if (xp>=300){
                levelUp();
                xp = xp - 300;
            }
            System.out.printf("%s [XP: %d/300]\n\n", name, xp );
        }
    }

    private void levelUp() {
        level++;
        hp += 10;
        System.out.println(name + " leveled up!");
        System.out.printf("%s [Level %d ---> Level %d]", name, level-1, level);
        updateDamage();

    }


    // DAMAGE INCREASE BY 2 EVERYTIME POKEMON LEVEL UP
    public void updateDamage (){
        for (int i=0; i<damage.length; i++){
            damage[i]+=2;
        }
    }


    public int calculateDamage(int index, Pokemon oppponent) {
        int baseDamage = damage[index];

        for (int i=0; i<3; i++) {
            if (strength[i].equalsIgnoreCase(oppponent.getType())) {             // 20% increase damage
                baseDamage *= 1.2;
                System.out.println("It's super effective!");
                System.out.printf("%s's HP drops significantly. ",oppponent.getName());
                if (oppponent.hp-baseDamage>=0){
                    System.out.printf("[%s HP: %d/100]\n",  oppponent.getName(), oppponent.hp-baseDamage);
                }
                System.out.println();
                break;
            } else if (weakness[i].equalsIgnoreCase(oppponent.getType())) {        // 20% decrease damage
                baseDamage *= 0.8;
                System.out.printf("%s's HP drops slightly. ", oppponent.getName());
                if (oppponent.hp - baseDamage >= 0) {
                    System.out.printf("[%s HP: %d/100]\n", oppponent.getName(), oppponent.hp - baseDamage);
                }
                System.out.println();
                break;
            }
        }

        if (baseDamage== damage[index]){
            System.out.printf("%s take some damage. ",oppponent.getName());
            if (oppponent.hp-baseDamage>=0){
                System.out.printf("[%s HP: %d/100]\n", oppponent.getName(), oppponent.hp-baseDamage);
            }
            System.out.println();
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}