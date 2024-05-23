package Main;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static Player player1;
    public static Player player2;
    public static Player player3;

    // private static Map<String, City> cities = new HashMap<>();
    private static CityManager cityManager;// = new CityManager();
    private static String currentCity = "Pallet Town"; // Start at Pallet Town
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

    public static Player currentPlayer;

    public static void main(String[] args) {

        cityManager = new CityManager();
        Scanner scanner = new Scanner(System.in);

        GameFlow gameFlow = new GameFlow();
        gameFlow.setPokemon();
        gameFlow.start();


        // need to make condition checking if input is not 1a,1b,1c,2a,2b,2c, or 3
        if (gameFlow.choice().equalsIgnoreCase("2a")) {
            player1 = new Player(gameFlow.enterName(), gameFlow.choosePokemon());
            currentPlayer = player1;
            while (true) {
                gameFlow.intermediate(player1);
            }
        } else if (gameFlow.choice().equalsIgnoreCase("2b")) {

            Player player2 = new Player(gameFlow.enterName(), gameFlow.choosePokemon());
            //intermediate(player2) ;

        } else if (gameFlow.choice().equalsIgnoreCase("2c")) {
            Player player3 = new Player(gameFlow.enterName(), gameFlow.choosePokemon());
            //intermediate(player3) ;
        }



//


//        while (true)
//        {
//            System.out.println("+----------------------------------------------------------------------+");
//            System.out.println("You are currently in " + currentCity + ":");
//            System.out.println("+----------------------------------------------------------------------+");
//            System.out.println("[1] Move to:");
//
//            List<String> adjacentCities = (cityManager.cities).get(currentCity).getAdjacentCities();
//
//            for (int i = 0; i < adjacentCities.size(); i++)
//            {
//                System.out.println("    " + (i + 1) + ". " + adjacentCities.get(i));
//            }
//
//            System.out.println("[2] Challenge Gym Leader [" + (cityManager.cities).get(currentCity).getGymLeader() + " - " + (cityManager.cities).get(currentCity).getGymType() + " type]");
//            System.out.println("[3] Fight Wild Pokémon [" + String.join(", ", (cityManager.cities).get(currentCity).getWildPokemon()) + " are common]");
//            System.out.println("[4] Player Options");
//            System.out.println("[5] PokeMaze");
//            System.out.print("+----------------------------------------------------------------------+\nYour choice: ");
//
//            int choice = scanner.nextInt();
//
//            switch (choice)
//            {
//                case 1:
//                {
//                    System.out.print("Move to: ");
//                    int cityChoice = scanner.nextInt();
//                    if (cityChoice >= 1 && cityChoice <= adjacentCities.size())
//                    {
//                        currentCity = adjacentCities.get(cityChoice - 1);
//                        System.out.println("Moving to " + currentCity + "...");
//                    }
//                    else
//                    {
//                        System.out.println("Invalid choice.");
//                    }
//                    break;
//                }
//                case 2:
//                {
//                    System.out.println("Challenging Gym Leader " + (cityManager.cities).get(currentCity).getGymLeader() + "...");
//                    // Implement Gym Leader battle logic here
//                    break;
//                }
//                case 3:
//                {
//                    System.out.println("Encountering wild Pokémon...");
//                    // Implement wild Pokémon encounter logic here
//                    break;
//                }
//                case 4:
//                {
//                    System.out.println("Player Options:");
//                    System.out.println("a. Show map");
//                    System.out.println("b. Show My Pokémon");
//                    System.out.println("c. Show My badges");
//                    System.out.println("d. Save and Exit");
//                    System.out.println("e. Exit");
//                    System.out.print("Your choice: ");
//                    String playerOption = scanner.next();
//                    switch (playerOption)
//                    {
//                        case "a":
//                        {
//                            displayMap();
//                            break;
//                        }
//                        case "b":
//                        {
//                            // Implement showing player's Pokémon
//                            break;
//                        }
//                        case "c":
//                        {
//                            // Implement showing player's badges
//                            break;
//                        }
//                        case "d":
//                        {
//                            System.out.println("Saving game and exiting..."); // Implement game saving code
//                            System.exit(0);
//                        }
//                        case "e":
//                        {
//                            break;
//                        }
//                        default:
//                            System.out.println("Invalid option.");
//                    }
//                    break;
//                }
//                case 5:
//                {
//                    int[] start = {1, 1};
//                    int[] end = {8, 15};
//
//                    MazeGame game = new MazeGame(maze, start, end);
//                    Scanner keyboard = new Scanner(System.in);
//
//                    System.out.println("Welcome to the PokeMaze Challenge!");
//                    while (true)
//                    {
//                        game.displayMaze();
//                        System.out.print("Enter direction (up, down, left, right): ");
//                        String direction = keyboard.nextLine();
//
//                        if (game.move(direction))
//                        {
//                            if (game.isCaughtByGhost(game.currentPosition))
//                            {
//                                game.displayMaze();
//                                System.out.println("Oh no! You encountered a Ghastly and got caught.");
//                                System.out.println("Game Over.");
//                                break;
//                            }
//                            if (game.hasReachedEnd())
//                            {
//                                game.displayMaze();
//                                System.out.println("Congratulations! You've reached the end of the maze.");
//                                break;
//                            }
//                        }
//                    }
//
//                    break;
//                }
//                default:
//                {
//                    System.out.println("Invalid choice. Please try again.");
//                }
//            }
//        }


    }

//    private static void displayMap() {
//        System.out.println("+----------------------------------------------------------------------+");
//        System.out.println("Map of Kanto");
//        for (String cityName : cityManager.keySet()) {
//            if (cityName.equals(currentCity)) {
//                System.out.println("[**" + cityName + "**]");
//            } else {
//                System.out.println("[" + cityName + "]");
//            }
//        }
//        System.out.println("+----------------------------------------------------------------------+");
//    }
}