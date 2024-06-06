package Testing2DGame.Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;

import Testing2DGame.Main.CityManager;
import Testing2DGame.Main.GamePanel;
import Testing2DGame.Main.KeyHandler;
import Testing2DGame.Main.MazeGame;

public class Player extends Entity
{
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;
    int hasKey = 0; // How many keys the player currently has

    private static CityManager cityManager;// = new CityManager();
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

    public Player(GamePanel gp, KeyHandler keyHandler)
    {
        this.gamePanel = gp;
        this.keyHandler = keyHandler;

        screenX = gamePanel.screenWidth/2 - (gamePanel.tileSize/2);
        screenY = gp.screenHeight/2 - (gamePanel.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
    }

    // Set player's default position
    public void setDefaultValues()
    {
        worldX = gamePanel.tileSize * 3;
        worldY = gamePanel.tileSize * 35;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage()
    {
        try
        {
            up1 = ImageIO.read(getClass().getResourceAsStream(".\\boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream(".\\boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream(".\\boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream(".\\boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream(".\\boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream(".\\boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream(".\\boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream(".\\boy_right_2.png"));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void update() 
    {
        if(keyHandler.upPressed == true || keyHandler.downPressed == true || keyHandler.leftPressed == true || keyHandler.rightPressed == true)
        {
            if(keyHandler.upPressed == true)
            {
                direction = "up";
                // worldY -= speed;
            }
            else if(keyHandler.downPressed == true)
            {
                direction = "down";
                // worldY += speed;
            }
            else if(keyHandler.leftPressed == true)
            {
                direction = "left";
                // worldX -= speed;
            }
            else if(keyHandler.rightPressed == true)
            {
                direction = "right";
                // worldX += speed;
            }
    

            // Checks tile collision
            collisionOn = false;
            gamePanel.checker.checkTile(this);

            // Checks object collision (what will happen when the player hits the object)
            int objIndex = gamePanel.checker.checkObject(this, true);
            pickUpObject(objIndex);

            // If collision is false, player can move
            if(collisionOn == false)
            {
                switch (direction) 
                {
                    case "up":
                    {
                        worldY -= speed;
                        break;
                    }
                    case "down":
                    {
                        worldY += speed;
                        break;
                    }
                    case "left":
                    {
                        worldX -= speed;
                        break;
                    }
                    case "right":
                    {
                        worldX += speed;
                        break;
                    }
                }
            }

            spriteCounter++;
            if(spriteCounter > 15)
            {
                if(spriteNum == 1)
                {
                    spriteNum = 2;
                }
                else if(spriteNum == 2)
                {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void pickUpObject(int index)
    {
        if(index != 999)
        {
            // gamePanel.object[index] = null;

            String objectName = gamePanel.object[index].name;
            
            switch(objectName)
            {
                case "Key":
                {
                    CityManager cityManager = new CityManager();

                    Scanner scanner = new Scanner(System.in);

                    boolean condition = true;

                    outer:
                    while (true) 
                    {
                        System.out.println("+----------------------------------------------------------------------+");
                        System.out.println("You are currently in " + objectName + ":");
                        System.out.println("+----------------------------------------------------------------------+");

                        // List<String> adjacentCities = (cityManager.cities).get(currentCity).getAdjacentCities();

                        // for (int i = 0; i < adjacentCities.size(); i++) 
                        // {
                        //     System.out.println("    " + (i + 1) + ". " + adjacentCities.get(i));
                        // }

                        System.out.println("[1] Challenge Gym Leader [" + (cityManager.cities).get(currentCity).getGymLeader() + " - " + (cityManager.cities).get(currentCity).getGymType() + " type]");
                        System.out.println("[2] Fight Wild Pokémon [" + String.join(", ", (cityManager.cities).get(currentCity).getWildPokemon()) + " are common]");
                        System.out.println("[3] Player Options");
                        System.out.println("[4] PokeMaze");
                        System.out.println("[5] Exit (Go back to GUI)");
                        System.out.print("+----------------------------------------------------------------------+\nYour choice: ");
                        
                        int choice = scanner.nextInt();
                        
                        switch (choice) 
                        {
                            case 1:
                            {
                                System.out.println("Challenging Gym Leader " + (cityManager.cities).get(currentCity).getGymLeader() + "...");
                                // Implement Gym Leader battle logic here
                                break;
                            }
                            case 2:
                            {
                                System.out.println("Encountering wild Pokémon...");
                                // Implement wild Pokémon encounter logic here
                                break;
                            }
                            case 3:
                            {
                                System.out.println("Player Options:");
                                System.out.println("a. Show map");
                                System.out.println("b. Show My Pokémon");
                                System.out.println("c. Show My badges");
                                System.out.println("d. Save and Exit");
                                System.out.println("e. Exit");
                                System.out.print("Your choice: ");
                                String playerOption = scanner.next();
                                switch (playerOption) 
                                {
                                    case "a":
                                    {
                                        //displayMap();
                                        break;
                                    }
                                    case "b":
                                    {
                                        // Implement showing player's Pokémon
                                        break;
                                    }
                                    case "c":
                                    {
                                        // Implement showing player's badges
                                        break;
                                    }
                                    case "d":
                                    {
                                        System.out.println("Saving game and exiting..."); // Implement game saving code
                                        System.exit(0);
                                    }
                                    case "e":
                                    {
                                        break;
                                    }
                                    default:
                                    System.out.println("Invalid option.");
                                }
                                break;
                            }
                            case 4:
                            {
                                int[] start = {1, 1};
                                int[] end = {8, 15};

                                MazeGame game = new MazeGame(maze, start, end);
                                Scanner keyboard = new Scanner(System.in);

                                System.out.println("Welcome to the PokeMaze Challenge!");
                                while (true) 
                                {
                                    game.displayMaze();
                                    System.out.print("Enter direction (up, down, left, right): ");
                                    String direction = keyboard.nextLine();

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

                                break;
                            }
                            case 5:
                            {
                                System.out.println("Exited the town. Go back to GUI to go to another town");
                                condition = false;
                                break outer;
                            }
                            default:
                            {
                                System.out.println("Invalid choice. Please try again.");
                            }
                        }
                    }
                    break;
                }
                case "Door":
                {
                    if(hasKey > 0)
                    {
                        gamePanel.object[index] = null;
                        hasKey--;
                        System.out.println("Key:" + hasKey);
                    }
                    break;
                }
            }
        }
    }

    public void draw(Graphics2D g2)
    {
        // g2.setColor(Color.white);
        // g2.fillOval(x, y, gamePanel.tileSize, gamePanel.tileSize);

        BufferedImage image  = null;
        
        switch(direction)
        {
            case "up":
            {
                if(spriteNum == 1)
                {
                    image = up1;
                }
                if(spriteNum ==2)
                {
                    image = up2;
                }
                break;
            }
            case "down":
            {
                if(spriteNum == 1)
                {
                    image = down1;
                }
                if(spriteNum ==2)
                {
                    image = down2;
                }
                break;
            }
            case "left":
            {
                if(spriteNum == 1)
                {
                    image = left1;
                }
                if(spriteNum ==2)
                {
                    image = left2;
                }
                break;
            }
            case "right":
            {
                if(spriteNum == 1)
                {
                    image = right1;
                }
                if(spriteNum ==2)
                {
                    image = right2;
                }
                break;
            }
        }
        g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
        
    }
}
