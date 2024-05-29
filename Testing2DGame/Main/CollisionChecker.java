package Testing2DGame.Main;

import Testing2DGame.Entity.Entity;

public class CollisionChecker 
{
    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamepPanel)
    {
        this.gamePanel = gamepPanel;
    }

    public void checkTile(Entity entity)
    {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityUpWorldY = entity.worldY + entity.solidArea.y;
        int entityDownWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gamePanel.tileSize;
        int entityRightCol = entityRightWorldX/gamePanel.tileSize;
        int entityUpRow = entityUpWorldY/gamePanel.tileSize;
        int entityDownRow = entityDownWorldY/gamePanel.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction)
        {
            case "up":
            {
                entityUpRow = (entityUpWorldY - entity.speed)/gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityUpRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityUpRow];

                if(gamePanel.tileManager.tile[tileNum1].collision == true || gamePanel.tileManager.tile[tileNum2].collision == true)
                {
                    entity.collisionOn = true;
                }

                break;
            }
            case "down":
            {
                entityDownRow = (entityDownWorldY + entity.speed)/gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityDownRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityDownRow];

                if(gamePanel.tileManager.tile[tileNum1].collision == true || gamePanel.tileManager.tile[tileNum2].collision == true)
                {
                    entity.collisionOn = true;
                }

                break;
            }
            case "left":
            {
                entityLeftCol = (entityLeftWorldX - entity.speed)/gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityUpRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityDownRow];

                if(gamePanel.tileManager.tile[tileNum1].collision == true || gamePanel.tileManager.tile[tileNum2].collision == true)
                {
                    entity.collisionOn = true;
                }

                break;
            }
            case "right":
            {
                entityRightCol = (entityRightWorldX + entity.speed)/gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityRightCol][entityUpRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityDownRow];

                if(gamePanel.tileManager.tile[tileNum1].collision == true || gamePanel.tileManager.tile[tileNum2].collision == true)
                {
                    entity.collisionOn = true;
                }

                break;
            }
        }
    }
}
