package Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class GameFlow {

    static Pokemons[] pokemons = new Pokemons[3];


    // 1. STARTING METHOD
    // player choose either to load saved games, start new game or exit
    public void start () {

        System.out.println("                                  ,'\\\n" +
                "    _.----.        ____         ,'  _\\   ___    ___     ____\n" +
                "_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.\n" +
                "\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |\n" +
                " \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |\n" +
                "   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |\n" +
                "    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |\n" +
                "     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |\n" +
                "      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |\n" +
                "       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |\n" +
                "        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |\n" +
                "                                `'                            '-._|");
        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("Welcome to Pokemon - Kanto Advetures");
        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("[1] Load Game:");
        System.out.printf("    %-20s %-20s %-20s%n", "a. Save 1 - empty", "b. Save 2 - empty", "c. Save 3 - empty");
        System.out.println("[2] Start a new Adventure:");
        System.out.printf("    %-20s %-20s %-20s%n", "a. Save 1 - empty", "b. Save 2 - empty", "c. Save 3 - empty");
        System.out.println("[3] Exit");
        System.out.println("+--------------------------------------------------------------------------------------------+");
    }


    // 2. CHOICE INPUT AND RETURN METHOD
    //  method to get input for player's next move
    public String choice () { //make function return which class to call to ?? [change void -> class name (??)]
        Scanner scanner =  new Scanner(System.in);

        String decision;
        System.out.print("Your choice: ");
        decision = scanner.next();
        System.out.println("+--------------------------------------------------------------------------------------------+");
        return decision;
        //do conditional checking which class should be called based on decision

    }

    // 3. INTERMEDIATE METHOD
    // this method is to print out player's choices for their next move
    public void intermediate (Player player){

        System.out.println("You are currently in " + player.getLocation());
        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("[1] Move to:");

        //later need to make the cities to be dynamic based on where the player is.
        System.out.printf("    %-20s %-20s %n", "a. Cerulean City", "b. Viridian City");
        System.out.println("[2] Challenge Gym leader [Brock - Rock Type]");
        System.out.println("[3] Fight Wild Pokemon [Pidgey, Meowth, Sycther are common]");
        System.out.println("[4] Player Options");
        System.out.printf("    %-20s %-20s %-20s %-20s%n", "a. Show map", "b. Show My Pokemon", "c.Show My Badges", "d.Save and Exit");
        System.out.println("+--------------------------------------------------------------------------------------------+");
        nextStep(player, choice());
        //i dont remember wat this was for?
    }

    // 4. ENTERNAME METHOD
    // method to enter player's name and also set it in [Player] CLASS
    public String enterName(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("OAK:    Hello there! Welcome to the world of Pokémon! My name is Oak! " +
                "\nPeople call me the Pokémon Prof! This world is inhabited by creatures \n" +
                "called Pokémon! For some people, Pokémon are pets. Others use them for " +
                "\nfights. Myself... I study Pokémon as a profession.\n" +
                "\nOAK:     First, what is your name?");
        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.print("Enter your name:");
        String namePlayer = scanner.next();

        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.printf("OAK: Right! So your name is %s! Welcome to the world of Pokemon. It's time to choose your starting pokemon.\n", namePlayer);
        System.out.println("+--------------------------------------------------------------------------------------------+");
        for (int i=0; i<3; i++){
            System.out.printf("[%d] %s [%s - Level %d]\n", i+1, pokemons[i].getName(), pokemons[i].getType(), pokemons[i].getLevel());
        }
        System.out.println("+--------------------------------------------------------------------------------------------+");
//        System.out.print("Your choice: ");
//        String decision = choice();
//        int chosenID=0;
//
//        for (int i=0; i<3; i++){
//            if (decision.equalsIgnoreCase(Integer.toString(TESTER.ID[i]))){
//                chosenID=i;
//                System.out.printf("OAK:     You chose %s, an amazing choice. Best of luck!\n", TESTER.name[chosenID]);
//            }
//        }

//        player1 = new Player(namePlayer, TESTER.name[chosenID], "Pallet Town");
//        System.out.println("+--------------------------------------------------------------------------------------------+");

        return namePlayer;
    }


    // 5. CHOOSE POKEMON
    // method to choose their initial pokemon and set it in Player class
    /// UPDATE: i changed return type String-> class Pokemons
    public Pokemons choosePokemon (){
        String decision = choice();
        int chosenID=0;

        for (int i=0; i<3; i++){
            if (decision.equalsIgnoreCase(Integer.toString(pokemons[i].getID()))){
                chosenID=i;
                System.out.printf("OAK:     You chose %s, an amazing choice. Best of luck!\n", pokemons[chosenID].getName());
                System.out.println("+--------------------------------------------------------------------------------------------+");
            }
        }
        return pokemons[chosenID];
    }


    // 6. METHOD TO SET ALL POKEMONS IN A CLASS ARRAY

    public void setPokemon () {

        int i = 0;
        try {
            Scanner pokemonlist = new Scanner(new FileInputStream("D:\\DEGREE\\1ST YEAR\\intellij\\POKEMONDRAFT\\src\\POKEMONLIST"));
            //FileReader pokemonlist = new FileReader ("D:\\DEGREE\\1ST YEAR\\net code\\DUITRIA\\LOCATIONS.txt");

            while (pokemonlist.hasNextLine()) {


                String[] pokemonRead = pokemonlist.nextLine().split(",");

                // array size to be changed or array change to arraylist

                pokemons[i] = new Pokemons(Integer.parseInt(pokemonRead[0]),pokemonRead[1], pokemonRead[2],Integer.parseInt(pokemonRead[3]), pokemonRead[4], Integer.parseInt(pokemonRead[5]), pokemonRead[6], Integer.parseInt(pokemonRead[7]), pokemonRead[8], pokemonRead[9], pokemonRead[10], pokemonRead[11], pokemonRead[12], pokemonRead[13]);

//                id[i] = Integer.parseInt(pokemonRead[0]);
//                name[i] = pokemonRead[1];
//                type[i] = pokemonRead[2];
//                level[i] = Integer.parseInt(pokemonRead[3]);
//                move1[i] = pokemonRead[4];
//                damage1[i] = Integer.parseInt(pokemonRead[5]);
//                move2[i] = pokemonRead[6];
//                damage2[i] = Integer.parseInt(pokemonRead[7]);
//                strength1[i] = pokemonRead[8];
//                strength2[i] = pokemonRead[9];
//                strength3[i] = pokemonRead[10];
//                weakness1[i] = pokemonRead[11];
//                weakness2[i] = pokemonRead[12];
//                weakness3[i] = pokemonRead[13];
//
//                System.out.println(name[i] + " " + type[i] + " " + level[i]);

                i++;
            }


        } catch (IOException ignored) {
            System.out.println("Error while reading Pokemon List txt file");
        }
    }

    public  void nextStep (Player player, String decision){

        if (decision.equalsIgnoreCase("2")){

            //later need to make the opponent to be dynamic based on where the player is.
            Battle battle = new Battle (player, "Brock");
        }


    }


}


