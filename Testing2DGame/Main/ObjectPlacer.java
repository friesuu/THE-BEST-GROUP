package Testing2DGame.Main;

import Testing2DGame.object.ObjectDoor;
import Testing2DGame.object.ObjectKey;

public class ObjectPlacer 
{
    GamePanel panel;

    public ObjectPlacer(GamePanel panel)
    {
        this.panel = panel;
    }

    public void setObject()
    {
        panel.object[0] = new ObjectKey();
        panel.object[0].worldX = 4 * panel.tileSize;
        panel.object[0].worldY = 36 * panel.tileSize;

        panel.object[1] = new ObjectDoor();
        panel.object[1].worldX = 3 * panel.tileSize; // Change the number to put at the position following the map
        panel.object[1].worldY = 36 * panel.tileSize;
    }
}
