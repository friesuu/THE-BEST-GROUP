package Testing2DGame.object;

import java.io.IOException;

import javax.imageio.ImageIO;

import Testing2DGame.Main.GamePanel;

public class Obj_PalletTown extends SuperObject
{
    GamePanel panel;

    public Obj_PalletTown(GamePanel panel)
    {
        this.panel = panel;
        name = "Pallet Town";
        
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
