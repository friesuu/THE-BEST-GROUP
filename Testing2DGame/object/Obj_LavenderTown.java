package Testing2DGame.object;

import java.io.IOException;

import javax.imageio.ImageIO;

import Testing2DGame.Main.GamePanel;

public class Obj_LavenderTown extends SuperObject
{
    GamePanel panel;

    public Obj_LavenderTown(GamePanel panel)
    {
        this.panel = panel;
        name = "Lavender Town";
        
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("./town.png"));
            uTool.scaleImage(image, panel.tileSize, panel.tileSize);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}
