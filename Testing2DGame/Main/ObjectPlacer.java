package Testing2DGame.Main;

import Testing2DGame.object.Obj_Grass;
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
        panel.object[0] = new ObjectKey(panel);
        panel.object[0].worldX = 4 * panel.tileSize;
        panel.object[0].worldY = 36 * panel.tileSize;

        panel.object[1] = new ObjectDoor(panel);
        panel.object[1].worldX = 3 * panel.tileSize; // Change the number to put at the position following the map
        panel.object[1].worldY = 36 * panel.tileSize;

        panel.object[2] = new Obj_Grass(panel);
        panel.object[2].worldX = 2 * panel.tileSize;
        panel.object[2].worldY = 35 * panel.tileSize;
    }
}
