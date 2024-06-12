package Testing2DGame.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SafariZone {


    // Method to sort Pokemon based on given conditions
    public static List<String> sortPokemon(List<String> pokemonList) {
        List<String> sortedPokemonList = new ArrayList<>();

        // Eevee insists on being positioned at the beginning
        int eeveeIndex = pokemonList.indexOf("Eevee");
        if (eeveeIndex != -1) {
            sortedPokemonList.add("Eevee");
            pokemonList.remove(eeveeIndex);
            sortedPokemonList.addAll(pokemonList);
            System.out.println("\nStep 1 : Eevee insists on being positioned either at the beginning of the lineup to show its adaptability.");
            System.out.println("Sorted List : " + sortedPokemonList);
        }

        // Pikachu demands to be placed at the centre
        int pikachuIndex = sortedPokemonList.indexOf("Pikachu");
        if (pikachuIndex != -1) {
            int centreIndex = sortedPokemonList.size() / 2;
            sortedPokemonList.remove(pikachuIndex);
            sortedPokemonList.add(centreIndex, "Pikachu");
            System.out.println("\nStep 2 : Pikachu demands to be placed at the centre of the arrangement.");
            System.out.println("Partial Sort : " + sortedPokemonList);
        }

        // Snorlax insists on being positioned at the end
        int snorlaxIndex = sortedPokemonList.indexOf("Snorlax");
        if (snorlaxIndex != -1) {
            sortedPokemonList.remove(snorlaxIndex);
            sortedPokemonList.add("Snorlax");
            System.out.println("\nStep 3 : Snorlax insists on being positioned at the end of the lineup to ensure minimum relaxation.");
            System.out.println("Partial Sort : " + sortedPokemonList);
            //pokemonList.add(pokemonList.remove(snorlaxIndex));
        }

        // Jigglypuff prefers to be surrounded by other "cute" Pokemon
        int jigglypuffIndex = sortedPokemonList.indexOf("Jigglypuff");
        int pikachuIndex2 = sortedPokemonList.indexOf("Pikachu");
        if ((jigglypuffIndex != -1) && (pikachuIndex2 != -1) && (jigglypuffIndex != pikachuIndex2)) {
            sortedPokemonList.remove(jigglypuffIndex);
            sortedPokemonList.add((pikachuIndex2), "Jigglypuff");
            System.out.println("\nStep 4 : Jigglypuff prefers to be surrounded by other \"Cute\" Pokémon for morale purposes.");
            System.out.println("Partial Sort : " + sortedPokemonList);
        }


        // Bulbasaur refuses to be placed next to Charmander
        int bulbasaurIndex = sortedPokemonList.indexOf("Bulbasaur");
        int charmanderIndex = sortedPokemonList.indexOf("Charmander");
        if ((bulbasaurIndex != -1) && (charmanderIndex != -1) && ((bulbasaurIndex + 1 == charmanderIndex) || (bulbasaurIndex - 1 == charmanderIndex))) {
            sortedPokemonList.remove(charmanderIndex);
            sortedPokemonList.add(bulbasaurIndex + 3, "Charmander");
            System.out.println("\nStep 5 : Bulbasaur refuses to be placed next to Charmander.");
            System.out.println("Partial Sort : " + sortedPokemonList);
        }

        // Machop demands to be placed next to the heaviest Pokemon (Snorlax)
        int machopIndex = sortedPokemonList.indexOf("Machop");
        int snorlaxIndex2 = sortedPokemonList.indexOf("Snorlax");
        if (machopIndex != -1) {
            if (snorlaxIndex2 > machopIndex) {
                sortedPokemonList.remove(machopIndex);
                sortedPokemonList.add(snorlaxIndex2 - 1, "Machop");
            } else {
                sortedPokemonList.remove(machopIndex);
                sortedPokemonList.add(snorlaxIndex2, "Machop");
            }
            System.out.println("\nStep 6 : Machop demands to be placed next to the haviest Pokémon in the lineup to show off its strength.");
            System.out.println("Final Sorted List : " + sortedPokemonList);
        }

        return sortedPokemonList;
    }
}