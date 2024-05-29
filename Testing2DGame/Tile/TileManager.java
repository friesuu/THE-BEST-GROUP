package Testing2DGame.Tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Testing2DGame.Main.GamePanel;

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
        try 
        {
            tile[0] = new Tile();  
            tile[0].image = ImageIO.read(getClass().getResourceAsStream(".\\grass.png"));
            tile[0].collision = true;

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream(".\\wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream(".\\water.png"));
            tile[2].collision = true;

            tile[3] = new Tile();  
            tile[3].image = ImageIO.read(getClass().getResourceAsStream(".\\earth.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream(".\\tree.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream(".\\sand.png"));
        } 
        catch (IOException e) {
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
                    g2.drawImage(tile[tileNum].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
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
