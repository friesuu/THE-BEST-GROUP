package Testing2DGame.Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ThePokemon {


    //io txt file Pokemon Name, Type, Level, Moves, Strength and Weakness
    //Name,Type,Level,Move1,Damage1,Move2,Damage2,Strength1,Strength2,Strength3,Weakness1,Weakness2,weakness3





        public void setPokemon (int[] id, String[] name, String[] type, int[] level, String[] move1, int[] damage1, String[] move2, int[] damage2, String[] strength1, String[] strength2, String[] strength3, String[] weakness1, String[] weakness2, String[] weakness3) {


            int i = 0;
            try {
                Scanner pokemon = new Scanner(new FileInputStream("D:\\DEGREE\\1ST YEAR\\SEM 2\\THE-BEST-GROUP\\POKEMONLIST"));
                //FileReader pokemon = new FileReader ("D:\\DEGREE\\1ST YEAR\\net code\\DUITRIA\\LOCATIONS.txt");

                while (pokemon.hasNextLine()) {
                    String[] pokemonRead = pokemon.nextLine().split(",");

                    id[i] = Integer.parseInt(pokemonRead[0]);
                    name[i] = pokemonRead[1];
                    type[i] = pokemonRead[2];
                    level[i] = Integer.parseInt(pokemonRead[3]);
                    move1[i] = pokemonRead[4];
                    damage1[i] = Integer.parseInt(pokemonRead[5]);
                    move2[i] = pokemonRead[6];
                    damage2[i] = Integer.parseInt(pokemonRead[7]);
                    strength1[i] = pokemonRead[8];
                    strength2[i] = pokemonRead[9];
                    strength3[i] = pokemonRead[10];
                    weakness1[i] = pokemonRead[11];
                    weakness2[i] = pokemonRead[12];
                    weakness3[i] = pokemonRead[13];

                    System.out.println(name[i] + " " + type[i] + " " + level[i]);

                    i++;
                }


            } catch (IOException ignored) {
                System.out.println("Error while reading Pokemon List txt file");
            }
        }




}
