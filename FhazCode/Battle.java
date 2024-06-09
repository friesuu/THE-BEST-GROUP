package FhazCode;

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
        this.oppsPokemon = opponent.getGymLeaderPokemon();

        int i=1;    // trainer turn indicator
        int j=1;    // opponent turn
        int k=0;    // trainer pokemon index
        int l=0;    // opponent pokemon index

        for (int m=0; m<playersPokemon.size(); m++){
            playersPokemon.get(m).setHp(100);
        }
        for (int m=0; m<oppsPokemon.size(); m++){
            oppsPokemon.get(m).setHp(100);
        }

        System.out.println("You are about to challenge " + opponent.getGymLeader() + "!");
        System.out.println("Prepare yourself for an intense battle!");
        System.out.println("Your Pokemon:");
        System.out.printf("%s - Level: %d\n", playersPokemon.get(0).getName(), playersPokemon.get(0).getLevel());
        System.out.println("+--------------------------------------------------------------------------------------------+");




        System.out.println("Battle Start: Trainer "+ player.getPlayerName() + " vs. Gym Leader " + opponent.getGymLeader() + "!");
        System.out.printf("%s sends out %s [Level %d]!\n\n", opponent.getGymLeader(), oppsPokemon.get(l).getName(), oppsPokemon.get(l).getLevel());
        System.out.printf("%s is sent out!\n", player.getPokemon().get(k).getName());

        strengthChecker(player.getPokemon().get(k), opponent.getGymLeaderPokemon().get(l));


        while (k < playersPokemon.size() && l < oppsPokemon.size()) {
                // implement while all player pokemon belum habis


            //while (!playersPokemon.get(k).isFaintedChecker() && !oppsPokemon.get(l).isFaintedChecker()) {
            while (k < playersPokemon.size() && l < oppsPokemon.size()){

                if (playersPokemon.get(k).isFaintedChecker()){
                    System.out.println("\n"+playersPokemon.get(k).getName() + " faints!\n");
                    k++;
                    i=1;
                    j=1;

                    if (k<playersPokemon.size()){
                        System.out.println(playersPokemon.get(k).getName()+ " is sent out!");
                        strengthChecker(playersPokemon.get(k), oppsPokemon.get(l));


                    }
                    continue;

                }else if (oppsPokemon.get(l).isFaintedChecker()){
                    System.out.println("\n"+oppsPokemon.get(l).getName() + " faints!\n");
                    playersPokemon.get(k).gainXp(40);
                    i=1;
                    j=1;
                    l++;

                    if (l<oppsPokemon.size()){
                        System.out.println( opponent.getGymLeader()+ " sends out "+ oppsPokemon.get(l).getName() + " [Level "+ oppsPokemon.get(l).getLevel()+"]");
                        System.out.println("You have to defeat all their Pokemon.");
                        System.out.println("+--------------------------------------------------------------------------------------------+");

                    }
                    continue;
                }

                if (turnChecker(playersPokemon.get(k),oppsPokemon.get(l)) == playersPokemon.get(k)) {
                    if (i % 2 == 1) {
                        battleRounds(j, playersPokemon.get(k));
                        action(choice() - 1, playersPokemon.get(k), oppsPokemon.get(l));
                        i++;
                        i %= 2;
                        j++;
                    } else {
                        action(opponentRound(oppsPokemon.get(l)), oppsPokemon.get(l), playersPokemon.get(k));
                        i++;
                        i %= 2;
                    }
                }else{
                    if (i % 2 == 0) {
                        battleRounds(j, playersPokemon.get(k));
                        action(choice() - 1, playersPokemon.get(k), oppsPokemon.get(l));
                        i++;
                        i %= 2;
                        j++;
                    } else {
                        action(opponentRound(oppsPokemon.get(l)), oppsPokemon.get(l), playersPokemon.get(k));
                        i++;
                        i %= 2;
                    }
                }

            }

        }

        System.out.println("\nThe battle ended.");
        System.out.println("+--------------------------------------------------------------------------------------------+");


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

    public void action (int decision, Pokemon pokemon, Pokemon opponent){
        System.out.println(pokemon.getName()+ " uses " + pokemon.getMove()[decision]);

        // I THINK THERE SHOULD BE CONDITION CHECKING HOW MUCH OPP'S XPHP DECREASES TO KNOW EFFECTIVE OR NOT
        //UPDATE : ITS DONE ALREADY IN POKEMON CLASS
        //UPDATE: I AM NOT SURE IF IT CHECKS EFFECTIVE DAMAGE FOR OPPONENT
        int damage = pokemon.calculateDamage(decision,opponent);
        opponent.setHp(opponent.getHp()-damage);
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

        //for (int j=0; j<playersPokemon.size(); j++){
            for (int i=0; i<3; i++) {
                if (player.getStrength()[i].equalsIgnoreCase(opponent.getType())) {             // 20% increase damage
                    System.out.println("Its " + player.getStrength()[i].toLowerCase() + " type is strong against the opponent's " + opponent.getName() );
                    break;

                } else if (player.getWeakness()[i].equalsIgnoreCase(opponent.getType())) {        // 20% decrease damage
                    System.out.println("Its " + player.getStrength()[i].toLowerCase() + " type is weak against the opponent's " + opponent.getName() );
                    break;
                }
            }
        //}
    }

    public Pokemon turnChecker (Pokemon player, Pokemon opponent){

        if (player.getSpeed() >= opponent.getSpeed()){
            return player;
        }
        else{
            return opponent;
        }

    }

}
