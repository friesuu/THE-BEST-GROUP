package Testing2DGame.Main;

import Testing2DGame.object.Obj_ViridianCity;
import Testing2DGame.object.Obj_CeladonCity;
import Testing2DGame.object.Obj_CeruleanCity;
import Testing2DGame.object.Obj_CinnabarIsland;
import Testing2DGame.object.Obj_FuschiaCity;
import Testing2DGame.object.Obj_LavenderTown;
import Testing2DGame.object.Obj_PalletTown;
import Testing2DGame.object.Obj_PewterCity;
import Testing2DGame.object.Obj_SaffronCity;
import Testing2DGame.object.Obj_VermillionCity;

public class ObjectPlacer 
{
    GamePanel panel;

    public ObjectPlacer(GamePanel panel)
    {
        this.panel = panel;
    }

    public void setObject()
    {
        panel.object[0] = new Obj_PalletTown(panel);
        panel.object[0].worldX = 2 * panel.tileSize;
        panel.object[0].worldY = 34 * panel.tileSize;
        
        panel.object[1] = new Obj_ViridianCity(panel);
        panel.object[1].worldX = 2 * panel.tileSize;
        panel.object[1].worldY = 25 * panel.tileSize;

        panel.object[2] = new Obj_PewterCity(panel);
        panel.object[2].worldX = 2 * panel.tileSize;
        panel.object[2].worldY = 8 * panel.tileSize;

        panel.object[3] = new Obj_CeruleanCity(panel);
        panel.object[3].worldX = 35 * panel.tileSize;
        panel.object[3].worldY = 5 * panel.tileSize;

        panel.object[4] = new Obj_SaffronCity(panel);
        panel.object[4].worldX = 35 * panel.tileSize;
        panel.object[4].worldY = 16 * panel.tileSize;

        panel.object[5] = new Obj_VermillionCity(panel);
        panel.object[5].worldX = 35 * panel.tileSize;
        panel.object[5].worldY = 27 * panel.tileSize;

        panel.object[6] = new Obj_CeladonCity(panel);
        panel.object[6].worldX = 19 * panel.tileSize;
        panel.object[6].worldY = 16 * panel.tileSize;

        panel.object[7] = new Obj_LavenderTown(panel);
        panel.object[7].worldX = 47 * panel.tileSize;
        panel.object[7].worldY = 16 * panel.tileSize;

        panel.object[8] = new Obj_FuschiaCity(panel);
        panel.object[8].worldX = 30 * panel.tileSize;
        panel.object[8].worldY = 37 * panel.tileSize;

        panel.object[9] = new Obj_CinnabarIsland(panel);
        panel.object[9].worldX = 2 * panel.tileSize;
        panel.object[9].worldY = 41 * panel.tileSize;
    }
}
