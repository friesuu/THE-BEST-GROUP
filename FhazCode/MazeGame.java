package FhazCode;

import java.util.Scanner;
import java.util.Stack;

public class MazeGame 
{   
    private static final char WALL = '#';
    private static final char PATH = '.';
    private static final char START = 'S';
    private static final char END = 'E';
    private static final char GHOST = 'G';
    private static final char PLAYER = 'P';

    private char[][] maze;
    private int[] start;
    private int[] end;
    public int[] currentPosition;
    private Stack<int[]> pathStack;

    public MazeGame(char[][] maze, int[] start, int[] end) {
        this.maze = maze;
        this.start = start;
        this.end = end;
        this.currentPosition = start.clone();
        this.pathStack = new Stack<>();
        this.pathStack.push(start.clone());
    }


    public void displayMaze() 
    {
        for (int i = 0; i < maze.length; i++) 
        {
            for (int j = 0; j < maze[i].length; j++) 
            {
                if (i == currentPosition[0] && j == currentPosition[1]) 
                {
                    System.out.print(PLAYER + " ");
                } 
                else 
                {
                    System.out.print(maze[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean move(String direction) 
    {
        int[] newPosition = currentPosition.clone();
        System.out.println(direction);
        switch (direction.toLowerCase()) 
        {
            case "up":
                newPosition[0]--;
                break;
            case "down":
                newPosition[0]++;
                break;
            case "left":
                newPosition[1]--;
                break;
            case "right":
            {
                newPosition[1]++;
                break;
            }
            default:
                System.out.println("Invalid move. Try again.");
                return false;
        }

        if (isValidMove(newPosition)) 
        {
            currentPosition = newPosition;
            pathStack.push(newPosition.clone());
            return true;
        } 
        else 
        {
            System.out.println("Invalid move. Try again.");
            return false;
        }
    }

    public boolean isValidMove(int[] position) 
    {
        int row = position[0];
        int col = position[1];
        
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length) 
        {
            return false;
        }
        /* else if(cell == GHOST)
        {
            System.out.println("GAME END");
        } */
        
        char cell = maze[row][col];
        return cell == PATH || cell == START || cell == END || cell == GHOST;
    }

    public boolean isCaughtByGhost(int[] position) {
        return maze[position[0]][position[1]] == GHOST;
    }

    public boolean hasReachedEnd() {
        return currentPosition[0] == end[0] && currentPosition[1] == end[1];
    }

    /* public static void main(String[] args) 
    {
        char[][] maze = 
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

        int[] start = {1, 1};
        int[] end = {8, 15};

        MazeGame game = new MazeGame(maze, start, end);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the PokeMaze Challenge!");
        while (true) 
        {
            game.displayMaze();
            System.out.print("Enter direction (up, down, left, right): ");
            String direction = scanner.nextLine();

            if (game.move(direction)) 
            {
                if (game.isCaughtByGhost(game.currentPosition)) 
                {
                    game.displayMaze();
                    System.out.println("Oh no! You encountered a Ghastly and got caught.");
                    System.out.println("Game Over.");
                    break;
                }
                if (game.hasReachedEnd()) 
                {
                    game.displayMaze();
                    System.out.println("Congratulations! You've reached the end of the maze.");
                    break;
                }
            }
        }

        scanner.close();
    } */
}
