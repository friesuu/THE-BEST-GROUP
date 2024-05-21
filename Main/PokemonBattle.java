package Testing2DGame.Main;

import java.util.Scanner;

public class PokemonBattle {
    private String oppsPokemon; //could change to class of characters
    private String playersPokemon; // could change to class of characters
    private int playersPokemonLevel;
    private int oppPokemonLevel;
    public String getOppsPokemon() {
        return oppsPokemon;
    }
    public void setOppsPokemon(String oppsPokemon) {
        this.oppsPokemon = oppsPokemon;
    }
    public String getPlayersPokemon() {
        return playersPokemon;
    }
    public void setPlayersPokemon(String playersPokemon) {
        this.playersPokemon = playersPokemon;
    }


    public PokemonBattle(Player player, String opponent) {
        this.playersPokemon = player.getPlayersPokemon();
        this.oppsPokemon = opponent;

        System.out.println("You are about to challenge " + opponent+ "!");
        System.out.println("Prepare yourself for an intense battle!");
        System.out.println("Your Pokemon:");
        System.out.printf("%s - Level: %d\n", playersPokemon, playersPokemonLevel);
        System.out.println("+--------------------------------------------------------------------------------------------+");
        battle(oppsPokemon, oppPokemonLevel, playersPokemon, playersPokemonLevel);
        battleRounds(1,player);


    }

    public static void battle (String Opponent, int OppLevel,  String Player, int PlayerLevel) {
        System.out.println("Battle Start: Trainer Amaan vs. Gym Leader Brock!");
        System.out.printf("Brock sends out %s [Level %d]!\n\n", Opponent, OppLevel);

        System.out.printf("%s is sent out! Its grass type is strong against the opponent's %s.\n\n", Player, Opponent);



    }


    public static void choice () { //make function return which class to call to ?? [change void -> class name (??)]
        Scanner scanner =  new Scanner(System.in);

        String decision;
        System.out.print("Your choice: ");
        decision = scanner.next();
        System.out.println("+--------------------------------------------------------------------------------------------+");

        //do conditional checking which class should be called based on decision


    }


    public static void battleRounds (int count, Player player){
        System.out.printf("Round %d: \n", count);
        System.out.printf("%s's Moves:\n", player.getPlayersPokemon());
        System.out.printf("1. %s\n", player.getMove1());
        System.out.printf("2. %sn", player.getMove2());

    }
}
