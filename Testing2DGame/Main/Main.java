package Testing2DGame.Main;

import javax.sound.midi.spi.SoundbankReader;
import javax.swing.JFrame;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static Player1 player1;
    public static Player1 player2;
    public static Player1 player3;

    // private static Map<String, PokemonKantoAdventure.City> cities = new HashMap<>();
    private static CityManager cityManager;// = new PokemonKantoAdventure.CityManager();
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

    public static Player1 currentPlayer;

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        GameFlow gameFlow = new GameFlow();
        gameFlow.setPokemon();
        cityManager = new CityManager();
        gameFlow.start();
        MemoryCartridge.getUserSelection();

        
        // JFrame window = new JFrame();
    
        // window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // window.setResizable(true);
        // window.setTitle("Pokemon-Kanto Adventures");

        // GamePanel panel = new GamePanel();
        // window.add(panel);

        // window.pack();

        // window.setLocationRelativeTo(null);
        // window.setVisible(true);
        
        // panel.setupGame();
        // panel.startGameThread();
        
        

    }


}
