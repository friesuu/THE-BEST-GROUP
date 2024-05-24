/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon_assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SafariZone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // List to hold the Pokemon
        List<String> pokemonList = new ArrayList<>();
        
        // Prompt user to enter Pokemon names
        System.out.println("+---------------------------------------------------------------------------------+");
        System.out.println("Welcome to the Safari Zone! Today's challenge : Sort the Pokémon!");
        System.out.println("+---------------------------------------------------------------------------------+");
        System.out.print("Enter the Pokémon in your party (separated by comma) : ");
        String input = sc.nextLine();
        String[] pokemonArray = input.split(",");
        for (String pokemon : pokemonArray) {
            pokemonList.add(pokemon.trim());
        }
        
        // Display the pokemon entered
        System.out.println("\nYou entered : " + String.join(",", pokemonList));
        System.out.println("\nSorting your Pokémon according to their unique preferences...");
        
        // Sort the Pokemon according to the given conditions
        sortPokemon(pokemonList);
        //List<String> sortedPokemonList = sortPokemon(pokemonList);
        
        System.out.println("\n+---------------------------------------------------------------------------------+");
        System.out.println("Your Pokémon are now sorted! Enjoy your adventure in the Safari Zone!");
        System.out.println("+---------------------------------------------------------------------------------+");
        //System.out.println("Final Sorted List : " + sortedPokemonList);
    }
    
    // Method to sort Pokemon based on given conditions
    private static void sortPokemon(List<String> pokemonList) {
        //List<String> sortedPokemonList = new ArrayList<>();
        
        // Eevee insists on being positioned at the beginning
        int eeveeIndex = pokemonList.indexOf("Eevee");
        System.out.println("\nStep 1 : Eevee insists on being positioned either at the beginning of the lineup to show its adaptability.");
        if (eeveeIndex != -1) {
            pokemonList.add(0, pokemonList.remove(eeveeIndex));
        }
        System.out.println("Sorted List : " + pokemonList);
        
        // Pikachu demands to be placed at the centre
        int pikachuIndex = pokemonList.indexOf("Pikachu");
        if (pikachuIndex != -1) {
            pokemonList.add(pokemonList.size() / 2, pokemonList.remove(pikachuIndex));
        }
        System.out.println("\nStep 2 : Pikachu demands to be placed at the centre of the arrangement.");
        /**pokemonList.remove(pikachuIndex);
        pokemonList.add(pokemonList.size() / 2, "Pikachu");*/
        System.out.println("Partial Sort : " + pokemonList);
        
        // Snorlax insists on being positioned at the end
        int snorlaxIndex = pokemonList.lastIndexOf("Snorlax");
        if (snorlaxIndex != -1) {
            pokemonList.remove(snorlaxIndex);
            pokemonList.add("Snorlax");
            //pokemonList.add(pokemonList.remove(snorlaxIndex));
        }
        System.out.println("\nStep 3 : Snorlax insists on being positioned at the end of the lineup to ensure minimum relaxation.");
        /**pokemonList.remove(snorlaxIndex);
        pokemonList.add("Snorlax");*/
        System.out.println("Partial Sort : " + pokemonList);
        
        // Jigglypuff prefers to be surrounded bu other "cute" Pokemon
        int jigglypuffIndex = pokemonList.indexOf("Jigglypuff");
        if (jigglypuffIndex != -1) {
            int pikachuIndex2 = pokemonList.indexOf("Pikachu");
            if ((pikachuIndex2 != -1) && (jigglypuffIndex != pikachuIndex2)) {
                pokemonList.remove(jigglypuffIndex);
                pokemonList.add((pikachuIndex2 + 1), "Jigglypuff");
            }
        }
        System.out.println("\nStep 4 : Jigglypuff prefers to be surrounded by other \"Cute\" Pokémon for morale purposes.");
        /**int pikachuIndex2 = pokemonList.indexOf("Pikachu");
        if (jigglypuffIndex - 1 != pikachuIndex2) {
            pokemonList.remove("Jigglypuff");
            pokemonList.add(pikachuIndex2 + 1, "Jigglypuff");
        }*/
        System.out.println("Partial Sort : " + pokemonList);
        
        // Bulbasaur refuses to be placed next to Charmander
        int bulbasaurIndex = pokemonList.indexOf("Bulbasaur");
        int charmanderIndex = pokemonList.indexOf("Charmander");
        if ((bulbasaurIndex != -1) && (charmanderIndex != -1) && ((bulbasaurIndex + 1 == charmanderIndex) || (bulbasaurIndex - 1 == charmanderIndex))) {
            pokemonList.remove(charmanderIndex);
            pokemonList.add(bulbasaurIndex + 4, "Charmander");
        }
        System.out.println("\nStep 5 : Bulbasaur refuses to be placed next to Charmander.");
        /**int charmanderIndex = pokemonList.indexOf("Charmander");
        if (bulbasaurIndex != -1 && charmanderIndex != -1 && (bulbasaurIndex + 1 == charmanderIndex || bulbasaurIndex - 1 == charmanderIndex)) {
            pokemonList.remove(charmanderIndex);
            pokemonList.add(bulbasaurIndex + 2, "Charmander");
        }*/
        System.out.println("Partial Sort : " + pokemonList);
        
        // Machop demands to be placed next to the heaviest Pokemon (Snorlax)
        int machopIndex = pokemonList.indexOf("Machop");
        if (snorlaxIndex > machopIndex) {
            pokemonList.remove(machopIndex);
            pokemonList.add(snorlaxIndex, "Machop");
        } else {
            pokemonList.remove(machopIndex);
            pokemonList.add(snorlaxIndex + 1, "Machop");
        }
        System.out.println("\nStep 6 : Machop demands to be placed next to the haviest Pokémon in the lineup to show off its strength.");
        /**if (snorlaxIndex > machopIndex) {
            pokemonList.remove("Machop");
            pokemonList.add(snorlaxIndex, "Machop");
        } else {
            pokemonList.remove("Machop");
            pokemonList.add(snorlaxIndex + 1, "Machop");
        }*/
        
        System.out.println("Final Sorted List : " + pokemonList);
        
        // Add remaining Pokemon to the sorted List
        //sortedPokemonList.addAll(pokemonList);

    }
}
