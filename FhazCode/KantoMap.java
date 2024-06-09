package FhazCode;

import java.util.LinkedList;

public class KantoMap {

    public static void printMap(String currentCity) {
        String[][] map = {
                {"[Pewter City]", "-----------------------------", "[Cerulean City]", "------------------------|"},
                {"     |", "                                               |", "                           |"},
                {"     |", "                                               |", "                           |"},
                {"     |", "                                               |", "                           |"},
                {"     |", "                                               |", "                           |"},
                {"     |", "                 ","[Celadon City]", "------", "[Saffron City]", "-----------", "[Lavender Town]"},
                {"     |", "                        |", "                      |", "                           |"},
                {"     |", "                        |", "                      |", "                           |"},
                {"[Viridian City]", "               |", "                      |", "                           |"},
                {"     |", "                        |", "                      |", "                           |"},
                {"     |", "                        |", "               ","[Vermillion City]", "------------------|"},
                {"     |", "                        |", "                                                  |"},
                {"[Pallet Town]", "                 |", "                                                  |"},
                {"     |", "                        |", "                                                  |"},
                {"     |", "                  ","[Fuchsia City]", "-------------------------------------------|"},
                {"     |", "                        |"},
                {"     |", "                        |"},
                {"[Cinnabar Island]", "-------------|"}
        };

        System.out.println("Map of Kanto\n");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equalsIgnoreCase("["+ currentCity+ "]")) {
                    System.out.print("[**" + currentCity + "**]");
                } else {
                    System.out.print(map[i][j]);
                }
            }

            System.out.println();
        }

        System.out.println("\n");
        System.out.println("+--------------------------------------------------------------------------------------------+");

    }

}
