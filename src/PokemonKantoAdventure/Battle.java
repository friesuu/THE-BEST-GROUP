package PokemonKantoAdventure;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    private List<Pokemon> oppsPokemon; //could change to class of characters
    private List<Pokemon> playersPokemon = new ArrayList<>(); // could change to class of characters
    private int playersPokemonLevel;
    private int oppPokemonLevel;
    public List<Pokemon> getOppsPokemon() {
        return oppsPokemon;
    }
    public void setOppsPokemon(List<Pokemon> oppsPokemon) {
        this.oppsPokemon = oppsPokemon;
    }
    public List<Pokemon> getPlayersPokemon() {
        return playersPokemon;
    }
    public void setPlayersPokemon(List<Pokemon> playersPokemon) {
        this.playersPokemon = playersPokemon;
    }


    public Battle(Player player, City opponent) {
        this.playersPokemon = player.getPokemon();
        this.oppsPokemon = opponent.getWildPokemon();

        System.out.println("You are about to challenge " + opponent.getGymLeader() + "!");
        System.out.println("Prepare yourself for an intense battle!");
        System.out.println("Your Pokemon:");
        System.out.printf("%s - Level: %d\n", playersPokemon.getFirst().getName(), playersPokemonLevel);
        System.out.println("+--------------------------------------------------------------------------------------------+");
        battle(player, opponent);
        int i=1;
        int j=1;
        int k=0;
        while (k < playersPokemon.size()) {
                // implement while all player pokemon belum habis


            while (!playersPokemon.get(k).isFaintedChecker() && !oppsPokemon.get(0).isFaintedChecker()) {

                if (i % 2 == 1) {
                    battleRounds(j, playersPokemon.get(k));
                    action(choice()-1, playersPokemon.get(k));
                    i++;
                    i%=2;
                    j++;
                }else{
                    action(opponentRound(oppsPokemon.get(0)), oppsPokemon.get(0));
                    i++;
                    i%=2;
                }

            }

            if (playersPokemon.get(k).isFaintedChecker()){
                System.out.println(playersPokemon.get(k).getName() + " faints!\n");

                //GYM LEADER'S POKEMON WILL GAIN XP KA IF WON THE ROUND?
            }else if (oppsPokemon.get(0).isFaintedChecker()){
                System.out.println(oppsPokemon.get(0).getName() + " faints!\n\n");
                System.out.printf("%s gained 40xp.\n", playersPokemon.get(k).getName() );
                playersPokemon.get(k).setXp(playersPokemon.get(k).getXp()+ 40);
                System.out.printf("%s [XP: %d/100]\n\n", playersPokemon.get(k).getName(), playersPokemon.get(k).getXp());
            }

            k++;
        }

        System.out.println("\nThe battle ended.\n");

    }

    public void battle (Player player, City Opponent) {

        Random random = new Random();
        System.out.println("Battle Start: Trainer "+ player.getPlayerName() + " vs. Gym Leader " + Opponent.getGymLeader() + "!");

        // IMPLEMENT randomly select pokemon?
        // btw is this wild pokemon from the city or is this specific to each gym leader.
        // if specific to eac gym leader; then we have to implement other class for gym leaders' pokemon
        System.out.printf("%s sends out %s [Level %d]!\n\n", Opponent.getGymLeader(), Opponent.getWildPokemon().get(0).getName(), 0);

        // IMPLEMENT until wild pokemon habis too
        System.out.printf("%s is sent out!\n", player.getPokemon().get(0).getName());

        //for (int i=0; i<Opponent.getWildPokemon().size(); i++) {
            strengthChecker(player.getPokemon().get(0), Opponent.getWildPokemon().get(0));
        //}

    }


    public int choice () { //make function return which class to call to ?? [change void -> class name (??)]
        Scanner scanner =  new Scanner(System.in);

        int decision;
        System.out.print("Your choice: ");
        decision = scanner.nextInt();
        System.out.println("+--------------------------------------------------------------------------------------------+");
        return decision;
        //do conditional checking which class should be called based on decision

    }

    public void action (int decision, Pokemon pokemon){
        System.out.println("\n"+ pokemon.getName()+ " uses " + pokemon.getMove()[decision]);

        // I THINK THERE SHOULD BE CONDITION CHECKING HOW MUCH OPP'S XPHP DECREASES TO KNOW EFFECTIVE OR NOT
        //UPDATE : ITS DONE ALREADY IN POKEMON CLASS
        //UPDATE: I AM NOT SURE IF IT CHECKS EFFECTIVE DAMAGE FOR OPPONENT
        pokemon.setHp(pokemon.getHp()-pokemon.calculateDamage(decision, pokemon));
    }




    public void battleRounds (int count, Pokemon pokemons){
        System.out.printf("\nRound %d: \n", count);
        System.out.printf("%s's Moves:\n", pokemons.getName());
        pokemons.printMove();
        System.out.println("\nWhich move will " + pokemons.getName() + " use?");
    }

    public int opponentRound (Pokemon opponent){
        Random random =new Random();
        int decision =random.nextInt(2);
        return decision;
    }


    public void strengthChecker (Pokemon player, Pokemon opponent){

        for (int j=0; j<playersPokemon.size(); j++){
            for (int i=0; i<3; i++) {
                if (player.getStrength()[i].equalsIgnoreCase(opponent.getType())) {             // 20% increase damage
                    System.out.println("\nIts" + player.getStrength()[i] + " type is strong against the opponent's " + opponent.getType() );
                    break;

                } else if (player.getWeakness()[i].equalsIgnoreCase(opponent.getType())) {        // 20% decrease damage
                    System.out.println("\nIts" + player.getStrength()[i] + " type is weak against the opponent's " + opponent.getType() );
                    break;
                }
            }
        }
    }

}
