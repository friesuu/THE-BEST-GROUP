package PokemonKantoAdventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FightWildPokemon {

    public FightWildPokemon (Player player, City currentLocation){
        Random random = new Random();
        int index = random.nextInt(currentLocation.getWildPokemon().size());

        System.out.println("You are about to fight random wild Pokemon from " + currentLocation.getName() + "!");
        System.out.println("Prepare yourself for an intense battle with "+ currentLocation.getWildPokemon().get(index).getName()+  "!");
        System.out.println("\nYour Pokemon:");
        System.out.printf("%s - Level: %d\n", player.getPokemon().getFirst().getName(), player.getPokemon().getFirst().getLevel());
        System.out.println("+--------------------------------------------------------------------------------------------+");

        int k=0;
        int i=1;
        int j=1;
        while (true){

            if (player.getPokemon().get(k).isFaintedChecker()){
                System.out.println("\n"+player.getPokemon().get(k).getName() + " faints!\n");
                //k++;

                //TEMPORARY: if player lose to wild pokemon, decrease xp by one
                player.setXP(player.getXP()-1);
                System.out.println("Your XP decreases by 1 [XP: " + player.getXP()+ "/100]");

                break;

            }else if (currentLocation.getWildPokemon().get(index).isFaintedChecker()){
                System.out.println("\n"+currentLocation.getWildPokemon().get(index).getName() + " faints!\n");

                //TEMPORARY: IF PLAYER WIN GET THAT WILD POKEMON AND INCREASE XP
                player.setXP(player.getXP()+10);

                System.out.println("You won the fight!");
                System.out.println(currentLocation.getWildPokemon().get(index).getName()+ " is now one of your Pokemon.");

                List<Pokemon> playerPokemonList = new ArrayList<>(player.getPokemon());
                playerPokemonList.add(currentLocation.getWildPokemon().get(index));
                player.setPokemon(playerPokemonList);

                currentLocation.getWildPokemon().remove(index);

                System.out.println("\nYour Pokemon:");
                for (int p=0; p<player.getPokemon().size(); p++) {
                    System.out.printf("%s - Level: %d\n", player.getPokemon().get(p).getName(), player.getPokemon().get(p).getLevel());
                }
                System.out.println("+--------------------------------------------------------------------------------------------+");

                break;
            }

            if (i % 2 == 1) {
                battleRounds(j, player.getPokemon().get(k));
                action(choice()-1, player.getPokemon().get(k), currentLocation.getWildPokemon().get(index));
                i++;
                i%=2;
                j++;
            }else{
                action(opponentRound(currentLocation.getWildPokemon().get(index)), currentLocation.getWildPokemon().get(index), player.getPokemon().get(k));
                i++;
                i%=2;
            }

        }


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

}
