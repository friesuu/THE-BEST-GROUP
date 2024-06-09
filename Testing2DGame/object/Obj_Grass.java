package Testing2DGame.object;

import java.io.IOException;

import javax.imageio.ImageIO;

import Testing2DGame.Main.GamePanel;

public class Obj_Grass extends SuperObject
{
    GamePanel panel;

    public Obj_Grass(GamePanel panel)
    {
        this.panel = panel;
        name = "Grass";
        
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("./grass.png"));
            uTool.scaleImage(image, panel.tileSize, panel.tileSize);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
