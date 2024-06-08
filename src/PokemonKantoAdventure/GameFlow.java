package PokemonKantoAdventure;

import PokemonKantoAdventure.Battle;
import PokemonKantoAdventure.CityManager;
import PokemonKantoAdventure.Player;
import PokemonKantoAdventure.Pokemon;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class GameFlow {

    static Pokemon[] pokemons = new Pokemon[54];

    public static char[][] maze =
            {
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                    {'#', 'S', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
                    {'#', '#', '#', '#', '#', '.', '#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                    {'#', '.', '.', '.', '#', '.', '#', '.', '#', '.', '.', '.', 'G', '.', '.', '.', '#'},
                    {'#', '#', '#', '.', '#', '.', '#', '.', '#', 'G', '#', '#', '#', '.', '#', '.', '#'},
                    {'#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'G', '.', '#'},
                    {'#', '#', '#', '#', '#', 'G', '#', '.', '#', '#', '#', '#', '#', '#', '#', '.', '#'},
                    {'#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '#'},
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', 'E', '#'}
            };


    // 1. STARTING METHOD
    // player choose either to load saved games, start new game or exit
    public static void start() {

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
        System.out.println("Welcome to Pokemon Kanto Advetures");
        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("[1] Load Game:");
        String tempPlayer1, tempPlayer2, tempPlayer3;
        String override1, override2, override3;
        if (SaveGameManager.getSavedPlayers().get(0)==null){
            tempPlayer1 = "empty";
            override1 ="new";
        } else {
            tempPlayer1 = SaveGameManager.getSavedPlayers().get(0).getPlayerName();
            override1 ="Override";
        }
        if (SaveGameManager.getSavedPlayers().get(1)==null){
            tempPlayer2 = "empty";
            override2 ="new";
        }else {
            tempPlayer2 = SaveGameManager.getSavedPlayers().get(1).getPlayerName();
            override2 ="Override";
        }
        if (SaveGameManager.getSavedPlayers().get(2)==null){
            tempPlayer3 = "empty";
            override3 ="new";
        }else {
            tempPlayer3 = SaveGameManager.getSavedPlayers().get(2).getPlayerName();
            override3 ="Override";
        }
        System.out.printf("    %-20s %-20s %-20s%n", "[1] Save 1 - " + tempPlayer1,  "[2] Save 2 - "+ tempPlayer2, "[3] Save 3 - " + tempPlayer3) ;
        System.out.println("[2] Start a new Adventure:");
        System.out.printf("    %-20s %-20s %-20s%n", "[1] Save 1 - "+ override1 , "[2] Save 2 - " + override2, "[3] Save 3 - " + override3);
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

        int counter =1;
        System.out.println("You are currently in " + player.getLocation().getName());
        System.out.println("+--------------------------------------------------------------------------------------------+");
        List<String> adjacentCities = (CityManager.cities).get(CityManager.currentCity).getAdjacentCities();
        City currentCity = player.getLocation();
        System.out.println("[" + counter++ + "] Move to:");

        for (int i = 0; i < adjacentCities.size(); i++) {
            System.out.println("    " + (i + 1) + ". " + adjacentCities.get(i));
        }
        if (!currentCity.getName().equalsIgnoreCase("Pallet Town") && !currentCity.getName().equalsIgnoreCase("Lavender Town") ) {
            System.out.println("[" + counter++ + "] Challenge Gym leader [" + currentCity.getGymLeader() + " - " + currentCity.getGymType() + " type]");
        }
        else if (currentCity.getName().equalsIgnoreCase("Pallet Town")){
            System.out.println("[" + counter++ + "] Talk to Mom [Your hometown has no gym]");
        }

        System.out.println("[" + counter++ + "] Fight Wild Pokémon [" + player.getLocation().printWildPokemon() + " are common]");
        System.out.println("[" + counter++ + "] Player Options");
        System.out.printf("    %-20s %-20s %-20s %-20s%n", "a. Show map", "b. Show My Pokemon", "c.Show My Badges", "d.Save and Exit");
        if (player.getLocation().getName().equalsIgnoreCase("Lavender Town")) {
            System.out.println("[" + counter++ + "] PokeMaze");
        }
        if (player.getLocation().getName().equalsIgnoreCase("Saffron City")) {
            System.out.println("[" + counter++ + "] Rival's Race");
        }
        System.out.println("+--------------------------------------------------------------------------------------------+");
        nextStep(player, choice(), adjacentCities);
        //i dont remember wat this was for?
    }

    // 4. ENTERNAME METHOD
    // method to enter player's name and also set it in [PokemonKantoAdventure.Player] CLASS
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

        return namePlayer;
    }


    // 5. CHOOSE POKEMON
    // method to choose their initial pokemon and set it in PokemonKantoAdventure.Player class
    /// UPDATE: i changed return type String-> class Pokemons
    public Pokemon choosePokemon (){
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
                pokemons[i] = new Pokemon(Integer.parseInt(pokemonRead[0]),pokemonRead[1], pokemonRead[2],Integer.parseInt(pokemonRead[3]), pokemonRead[4], Integer.parseInt(pokemonRead[5]), pokemonRead[6], Integer.parseInt(pokemonRead[7]), pokemonRead[8], pokemonRead[9], pokemonRead[10], pokemonRead[11], pokemonRead[12], pokemonRead[13], Integer.parseInt(pokemonRead[14]));
                i++;
            }


        } catch (IOException ignored) {
            System.out.println("Error while reading Pokemon List txt file");
        }
    }

    public  void nextStep (Player player, String decision, List<String> adjacentCities){

        Scanner scanner = new Scanner(System.in);

        switch (Integer.parseInt(decision))
            {
                case 1:
                {
                    System.out.print("Move to: ");
                    int cityChoice = scanner.nextInt();
                    if (cityChoice >= 1 && cityChoice <= adjacentCities.size())
                    {
                        CityManager.currentCity = adjacentCities.get(cityChoice - 1);
                        player.setLocation(CityManager.cities.get(CityManager.currentCity));
                        System.out.println("Moving to " + CityManager.currentCity + "...");
                    }
                    else
                    {
                        System.out.println("Invalid choice.");
                    }
                    break;
                }
                case 2:
                {
                    City currentCity = player.getLocation();
                    if (!currentCity.getName().equalsIgnoreCase("Pallet Town") && !currentCity.getName().equalsIgnoreCase("Lavender Town")) {
                        System.out.println("Challenging Gym Leader " + (CityManager.cities).get(CityManager.currentCity).getGymLeader() + "...");
                        System.out.println("+--------------------------------------------------------------------------------------------+");

                        Battle battle = new Battle(Main.currentPlayer, CityManager.cities.get(CityManager.currentCity));
                    }
                    else{
                        System.out.printf("MOM: \"Oh, %s! You're leaving on your adventure with Pokémon? How\n" +
                                "exciting! I know you've always dreamed of this day. Remember, the bond\n" +
                                "you share with your Pokémon is the most important thing. Take care of\n" +
                                "them, and they'll take care of you. Don't worry about me; I'll be just\n" +
                                "fine here. I can't wait to hear all about your adventures and the new\n" +
                                "friends you're going to make. Remember, no matter how far you go, I'm\n" +
                                "always here for you. Be brave, be kind, and everything will turn out\n" +
                                "just fine. I'm so proud of you already! Now, go on, your adventure\n" +
                                "awaits! Oh, and don’t forget to change your underwear every day! Safe\n" +
                                "travels, my dear!\"\n", player.getPlayerName());
                        System.out.println("+--------------------------------------------------------------------------------------------+");

                    }
                    break;
                }
                case 3:
                {
                    System.out.println("Encountering wild Pokémon...");
                    System.out.println("+--------------------------------------------------------------------------------------------+");
                    FightWildPokemon fight = new FightWildPokemon(Main.currentPlayer, Main.currentPlayer.getLocation());
                    break;
                }
                case 4:
                {
                    if (Main.currentPlayer.getLocation().getName().equalsIgnoreCase("Lavender Town")) {
                        int[] start = {1, 1};
                        int[] end = {8, 15};

                        MazeGame game = new MazeGame(maze, start, end);
                        Scanner keyboard = new Scanner(System.in);

                        System.out.println("Welcome to the PokeMaze Challenge!");
                        while (true) {
                            game.displayMaze();
                            System.out.print("Enter direction (up, down, left, right): ");
                            String direction = keyboard.nextLine();

                            if (game.move(direction)) {
                                if (game.isCaughtByGhost(game.currentPosition)) {
                                    game.displayMaze();
                                    System.out.println("\nOh no! You encountered a Ghastly and got caught.");
                                    System.out.println("Game Over.");
                                    System.out.println("+--------------------------------------------------------------------------------------------+");

                                    break;
                                }
                                if (game.hasReachedEnd()) {
                                    game.displayMaze();
                                    System.out.println("Congratulations! You've reached the end of the maze.");
                                    System.out.println("+--------------------------------------------------------------------------------------------+");
                                    break;
                                }
                            }
                        }

                        break;
                    }

                    System.out.println("Player Options:");
                    System.out.println("a. Show map");
                    System.out.println("b. Show My Pokémon");
                    System.out.println("c. Show My badges");
                    System.out.println("d. Save and Exit");
                    System.out.println("e. Exit");
                    System.out.print("Your choice: ");
                    String playerOption = scanner.next();
                    System.out.println("+--------------------------------------------------------------------------------------------+");

                    switch (playerOption)
                    {
                        case "a":
                        {
                            KantoMap.printMap(Main.currentPlayer.getLocation().getName());
                            break;
                        }
                        case "b":
                        {
                            Main.currentPlayer.showPokemon();
                            break;
                        }
                        case "c":
                        {
                            Main.currentPlayer.showBadges();
                            break;
                        }
                        case "d":
                        {
                            System.out.println("Saving game and exiting..."); // Implement game saving code
                            System.out.println("+--------------------------------------------------------------------------------------------+");

//                            Player newPlayer = Main.currentPlayer;
//                            SaveGameManager.addNewPlayer(newPlayer);
//                            SaveGameManager.saveGame(newPlayer, "save" + (SaveGameManager.getSavedPlayers().size() - 1) + ".json");

                            //yer newPlayer = Main.currentPlayer;
                            System.out.println("\nSee you again "+ Main.currentPlayer.getPlayerName()+ "!");

                            if (Main.currentPlayer.equals(Main.player1)){
                                SaveGameManager.addNewPlayer(Main.currentPlayer);
                                SaveGameManager.saveGame(Main.currentPlayer, "save0" + ".json");
                            }
                            else if (Main.currentPlayer.equals(Main.player2)){
                                SaveGameManager.addNewPlayer(Main.currentPlayer);
                                SaveGameManager.saveGame(Main.currentPlayer, "save1" + ".json");
                            }
                            else if (Main.currentPlayer.equals(Main.player3)){
                                SaveGameManager.addNewPlayer(Main.currentPlayer);
                                SaveGameManager.saveGame(Main.currentPlayer, "save2" + ".json");
                            }


                            System.exit(0);
                        }
                        case "e":
                        {
                            break;
                        }
                        default:
                            System.out.println("Invalid option.");
                    }
                    break;
                }
                case 5:
                {
                    if (Main.currentPlayer.getLocation().getName().equalsIgnoreCase("Saffron City")) {
                        Dijkstra dijkstra = new Dijkstra();
                        String tt = dijkstra.getRandomTargetTown();
                        String sp = dijkstra.getShortestPath();

                        System.out.println("\nThe battle has begun! Your rival Gary has challenged you to a race to\n" + tt + "\n\n" + sp + "\n\nGoodluck on your race!");

                    }
                    break;

                }
                default:
                {
                    System.out.println("Invalid choice. Please try again.");
                }
            }



    }

    private static void displayMap() {
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("Map of Kanto");
        for (String cityName : CityManager.cities.keySet()) {
            if (cityName.equals(CityManager.currentCity)) {
                System.out.println("[**" + cityName + "**]");
            } else {
                System.out.println("[" + cityName + "]");
            }
        }
        System.out.println("+----------------------------------------------------------------------+");
    }


    // Function to switch to the loaded player's game
    public static void switchToLoadedPlayerGame(Player player) {
        // Switch to the loaded player's game
        Main.currentPlayer = player;
    }




}


