package Testing2DGame.object;

import java.io.IOException;

import javax.imageio.ImageIO;

import Testing2DGame.Main.GamePanel;

public class ObjectKey extends SuperObject
{
    GamePanel panel;

    public ObjectKey(GamePanel panel)
    {
        this.panel = panel;
        name = "Lavender Town";
        
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("./key.png"));
            uTool.scaleImage(image, panel.tileSize, panel.tileSize);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
