package Testing2DGame.object;

import java.io.IOException;

import javax.imageio.ImageIO;

import Testing2DGame.Main.GamePanel;

public class ObjectDoor extends SuperObject
{
    GamePanel panel;

    public ObjectDoor(GamePanel panel)
    {
        this.panel = panel;
        name = "Door";
        
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("./door.png"));
            uTool.scaleImage(image, panel.tileSize, panel.tileSize);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
