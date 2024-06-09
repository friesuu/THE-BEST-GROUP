package Testing2DGame.object;

import java.io.IOException;

import javax.imageio.ImageIO;

import Testing2DGame.Main.GamePanel;

public class Obj_SaffronCity extends SuperObject
{
    GamePanel panel;

    public Obj_SaffronCity(GamePanel panel)
    {
        this.panel = panel;
        name = "Saffron City";
        
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("./town.png"));
            uTool.scaleImage(image, panel.tileSize, panel.tileSize);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        collision = true;
    }
}
