package Testing2DGame.Main;

import java.util.Scanner;

public class TESTER {

    static int[] ID = new int[4];
    static String[] name = new String[4];
    static String[] type = new String[4];
    static int[] level = new int[4];
    static String[] move1 = new String[4];
    static int[] damage1 = new int[4];
    static String[] move2 = new String[4];
    static int[] damage2 = new int[4];
    static String[] strength1 = new String[4];
    static String[] strength2 = new String[4];
    static String[] strength3 = new String[4];
    static String[] weakness1 = new String[4];
    static String[] weakness2 = new String[4];
    static String[] weakness3 = new String[4];

    public static void main(String[] args) {

        ThePokemon pokemonClass = new ThePokemon();



        start();
  //      Player player1 = new Player (choice());
        //add messages

        Player player1 = null;
        getLocation();
        intermediate();
        if (choice().equalsIgnoreCase( "2a")){
            enterName( player1 );
        }

        PokemonBattle battle = new PokemonBattle (player1, "Brock");






//        pokemonClass.setPokemon(ID, name,type,level,move1,damage1,move2,damage2,strength1,strength2,strength3,weakness1,weakness2,weakness3);




    }

    public static void start (){
        System.out.println("Welcome to Pokemon - Kanto Advetures");
        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("[1] Load Game:");
        System.out.printf("    %-20s %-20s %-20s%n", "a. Save 1 - empty", "b. Save 2 - empty", "c. Save 3 - empty");
        System.out.println("[2] Start a new Adventure:");
        System.out.printf("    %-20s %-20s %-20s%n", "a. Save 1 - empty", "b. Save 2 - empty", "c. Save 3 - empty");
        System.out.println("[3] Exit");
        System.out.println("+--------------------------------------------------------------------------------------------+");
    }

    public static String choice () { //make function return which class to call to ?? [change void -> class name (??)]
        Scanner scanner =  new Scanner(System.in);

        String decision;
        System.out.print("Your choice: ");
        decision = scanner.next();
        System.out.println("+--------------------------------------------------------------------------------------------+");
        return decision;
        //do conditional checking which class should be called based on decision


    }

    public static void intermediate (){
        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("[1] Move to:");
        System.out.printf("    %-20s %-20s %n", "a. Cerulean City", "b. Viridian City");
        System.out.println("[2] Challenge Gym leader [Brock - Rock Type]");
        System.out.println("[3] Fight Wild Pokemon [Pidgey, Meowth, Sycther are common]");
        System.out.println("[4] Player Options");
        System.out.printf("    %-20s %-20s %-20s %-20s%n", "a. Show map", "b. Show My Pokemon", "c.Show My Badges", "d.Save and Exit");
        System.out.println("+--------------------------------------------------------------------------------------------+");

    }

    public static void getLocation (){
        System.out.println("Your are currently in Pewter City!");
    }

    public static void enterName(Player player1 ){

        Scanner scanner = new Scanner(System.in);
        System.out.println("OAK: Hello there! Welcome to the world of Pokémon! My name is Oak! " +
                "\nPeople call me the Pokémon Prof! This world is inhabited by creatures \n" +
                "called Pokémon! For some people, Pokémon are pets. Others use them for " +
                "\nfights. Myself... I study Pokémon as a profession.\n" +
                "\nOAK: First, what is your name?");
        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.print("Enter your name:");
        String namePlayer = scanner.next();
        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.printf("OAK: Right! So your name is %s! Welcome to the world of Pokemon. It's time to choose your starting pokemon.\n", namePlayer);
        System.out.println("+--------------------------------------------------------------------------------------------+");
        for (int i=0; i<3; i++){
            System.out.printf("[%d] %s [%s - Level %d]\n", i+1, TESTER.name[i], TESTER.type[i], TESTER.level[i]);
        }
        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.print("Your choice: ");
        String decision = choice();
        int chosenID=0;

        for (int i=0; i<3; i++){
            if (decision.equalsIgnoreCase(Integer.toString(TESTER.ID[i]))){
                chosenID=i;
                System.out.printf("You chose %s, an amazing choice. Best of luck!", TESTER.name[chosenID]);
            }
        }

        player1 = new Player(namePlayer, TESTER.name[chosenID]);
        System.out.println("+--------------------------------------------------------------------------------------------+");



    }



}
