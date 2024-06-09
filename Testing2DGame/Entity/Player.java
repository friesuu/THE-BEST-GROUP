package Testing2DGame.Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Testing2DGame.Main.City;
import Testing2DGame.Main.CityManager;
import Testing2DGame.Main.GameFlow;
import Testing2DGame.Main.GamePanel;
import Testing2DGame.Main.KeyHandler;
import Testing2DGame.Main.Main;
import Testing2DGame.Main.MazeGame;
import Testing2DGame.Main.UtilityTool;

public class Player extends Entity
{
    GamePanel gamePanel;
    KeyHandler keyHandler;
    JButton button;
    JPanel panel;
    JFrame frame;
    GameFlow gameFlow;

    public final int screenX;
    public final int screenY;
    // int hasKey = 0; // How many keys the player currently has
    boolean condition2 = true;

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
        up1 = setup("up_1");
        up2 = setup("up_2");
        down1 = setup("down_1");
        down2 = setup("down_2");
        left1 = setup("left_1");
        left2 = setup("left_2");
        right1 = setup("right_1");
        right2 = setup("right_2");
    }

    public BufferedImage setup(String imageName)
    {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try
        {
            image = ImageIO.read(getClass().getResourceAsStream(".\\" + imageName + ".png"));
            image = uTool.scaleImage(image, gamePanel.tileSize, gamePanel.tileSize);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return image;
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
        // boolean condition2 = true;
        if(index != 999)
        {
            // gamePanel.object[index] = null;

            String objectName = gamePanel.object[index].name;
            Main.currentPlayer.setLocation(CityManager.cities.get(objectName));
            gameFlow = new GameFlow();
            
            // outer:
            switch(objectName)
            {
                case "Pewter City":
                {
                    // gameFlow = new GameFlow();
                    gameFlow.intermediate(Main.currentPlayer, objectName);
                    break;
                }
                case "Pallet Town":
                {
                    // gameFlow = new GameFlow();
                    
                    gameFlow.intermediate(Main.currentPlayer, objectName);
                    break;
                    // if(hasKey > 0)
                    // {
                    //     gamePanel.object[index] = null;
                    //     hasKey--;
                    //     System.out.println("Key:" + hasKey);
                    // }
                    // break;
                }
                case "Cinnabar Island":
                {
                    gameFlow.intermediate(Main.currentPlayer, objectName);
                    break;
                    // frame = new JFrame();
                    // panel = new JPanel();
                    // button = new JButton("Testing");
                    // int condition = 1;
                    // frame.setTitle("My GUI");
                    // frame.setSize(400, 300);
                    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    // Scanner scanner = new Scanner(System.in);

                    // //button.add("TESTING");

                    // panel.add(button);
                    // frame.add(panel);

                    // // Add components, set layout, etc.
                    // frame.setVisible(true);
                    // while(condition == 1)
                    // {
                    //     condition = scanner.nextInt();

                    // }
                    // // gamePanel.drawPanel();
                    // // System.out.println("You have encountered a wild pokemon!");
                    // // Battle implementation here
                    // outer2:
                    // while(this.condition2)
                    // {
                    //     if(this.condition2)
                    //     {
                    //         this.condition2 = false;
                    //         break outer2;
                    //     }
                    //     // break;
                    // }
                }
                case "Lavender Town":
                {
                    gameFlow.intermediate(Main.currentPlayer, objectName);
                    break;
                }
                case "Fuschia City":
                {
                    gameFlow.intermediate(Main.currentPlayer, objectName);
                    break;
                }
                case "Cerulean City":
                {
                    gameFlow.intermediate(Main.currentPlayer, objectName);
                    break;
                }
                case "Celadon City":
                {
                    gameFlow.intermediate(Main.currentPlayer, objectName);
                    break;
                }
                case "Vermillion City":
                {
                    gameFlow.intermediate(Main.currentPlayer, objectName);
                    break;
                }
                case "Saffron City":
                {
                    gameFlow.intermediate(Main.currentPlayer, objectName);
                    break;
                }
                case "Viridian City":
                {
                    gameFlow.intermediate(Main.currentPlayer, objectName);
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
        g2.drawImage(image, screenX, screenY, null);
        
    }
}
