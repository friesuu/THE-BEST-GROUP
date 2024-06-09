package Testing2DGame.Tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Testing2DGame.Main.GamePanel;
import Testing2DGame.Main.UtilityTool;

public class TileManager 
{
    GamePanel gamePanel;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;

        tile = new Tile[10]; // Creates 10 TYPES of tile. TYPE not amount
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];

        getTileImage();
        loadMap(".\\map01.txt");
    }

    public void getTileImage()
    {
            setup(0, "grass", false);
            setup(1, "wall", true);
            setup(2, "water", true);
            setup(3, "earth", false);
            setup(4, "tree", true);
            setup(5, "sand", false);
    }

    public void setup(int index, String imageName, boolean collision)
    {
        UtilityTool uTool = new UtilityTool();

        try
        {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream(".\\" + imageName + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gamePanel.tileSize, gamePanel.tileSize);
            tile[index].collision = collision;
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void loadMap(String filepath)
    {
        try
        {
            InputStream is = getClass().getResourceAsStream(filepath); // Import the text file
            BufferedReader br = new BufferedReader(new InputStreamReader(is)); // Reads the text file

            int col = 0;
            int row = 0;

            while(col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow)
            {
                String line = br.readLine(); // Puts one line from the text file into the variable "line"

                while(col < gamePanel.maxWorldCol)
                {
                    String numbers[] = line.split(" "); // Splits the string in "line" into multiple String arrays. It splits everytime it encounters a whitespace (the argument in the split method)
                    
                    int num = Integer.parseInt(numbers[col]); // Changes the String type values in the numbers array into integer type

                    mapTileNum[col][row] = num; // Will hold the array in the text file
                    col++;
                }

                if(col == gamePanel.maxWorldCol)
                {
                    col = 0; // Reset to first column
                    row++; // Move to next row
                }
            }
            br.close();
        }
        catch(Exception e)
        {

        }
    }

    public void draw(Graphics2D g2)
    {
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gamePanel.maxWorldCol && worldRow < gamePanel.maxWorldRow)
        {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gamePanel.tileSize;
            int worldY = worldRow * gamePanel.tileSize;
            int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

            if(worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX && 
                worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX && 
                worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY && 
                worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY)
                {
                    g2.drawImage(tile[tileNum].image, screenX, screenY,null);
                }
            worldCol++;

            if(worldCol == gamePanel.maxWorldCol)
            {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
