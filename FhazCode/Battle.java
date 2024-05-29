package FhazCode;

import java.util.Random;
import java.util.Scanner;

public class Battle {
    private City oppsPokemon; //could change to class of characters
    private Pokemons playersPokemon; // could change to class of characters
    private int playersPokemonLevel;
    private int oppPokemonLevel;
    public City getOppsPokemon() {
        return oppsPokemon;
    }
    public void setOppsPokemon(City oppsPokemon) {
        this.oppsPokemon = oppsPokemon;
    }
    public Pokemons getPlayersPokemon() {
        return playersPokemon;
    }
    public void setPlayersPokemon(Pokemons playersPokemon) {
        this.playersPokemon = playersPokemon;
    }


    public Battle(Player player, City opponent) {
        this.playersPokemon = player.getPokemon();
        this.oppsPokemon = opponent;

        System.out.println("You are about to challenge " + opponent.getGymLeader() + "!");
        System.out.println("Prepare yourself for an intense battle!");
        System.out.println("Your Pokemon:");
        System.out.printf("%s - Level: %d\n", playersPokemon.getName(), playersPokemonLevel);
        System.out.println("+--------------------------------------------------------------------------------------------+");
        battle(player, opponent);
        int i=1;
        while (true) {
            battleRounds(i, player, playersPokemon);
            choice();
        }


    }

    public static void battle (Player player,City Opponent) {

        Random random = new Random();
        System.out.println("Battle Start: Trainer "+ player.getPlayerName() + " vs. Gym Leader Brock!");

        // IMPLEMENT randomly select pokemon?
        // btw is this wild pokemon from the city or is this specific to each gym leader.
        // if specific to eac gym leader; then we have to implement other class for gym leaders' pokemon
        System.out.printf("%s sends out %s [Level %d]!\n\n", Opponent.getGymLeader(), Opponent.getWildPokemon().get(0), 0);

        // IMPLEMENT condition checking whether pokemon is strong or weak against opponent
        System.out.printf("%s is sent out! Its "+  player.getPokemon().getType() + " type is strong against the opponent's %s.\n\n", player.getPokemon().getName(), Opponent.getWildPokemon());
    }


    public void choice () { //make function return which class to call to ?? [change void -> class name (??)]
        Scanner scanner =  new Scanner(System.in);

        int decision;
        System.out.print("Your choice: ");
        decision = scanner.nextInt();
        System.out.println("+--------------------------------------------------------------------------------------------+");

        //do conditional checking which class should be called based on decision

    }

    public void action (int decision, PlayersPokemon pokemon){
        System.out.println(pokemon.getName()+ " used " + pokemon.printMove(decision));

        // I THINK THERE SHOULD BE CONDITION CHECKING HOW MUCH OPP'S XPHP DECREASES TO KNOW EFFECTIVE OR NOT
        System.out.println("It's super effective!");





    }


    public void battleRounds (int count, Player player, Pokemons pokemons){
        System.out.printf("Round %d: \n", count);
        System.out.printf("%s's Moves:\n", pokemons.getName());
        pokemons.printMove();
        System.out.println("\nWhich move will " + pokemons.getName() + " use?");
    }
}
