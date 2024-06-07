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

    public int checkObject(Entity entity, boolean player) // Checks if player hits the object and if yes it returns the index of the object
    {
        int index = 999;

        for(int i = 0; i < gamePanel.object.length; i++)
        {
            if(gamePanel.object[i] != null)
            {
                // get entity's solid area position
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                // Get the object's solid area position
                gamePanel.object[i].solidArea.x = gamePanel.object[i].worldX + gamePanel.object[i].solidArea.x;
                gamePanel.object[i].solidArea.y = gamePanel.object[i].worldY + gamePanel.object[i].solidArea.y;

                switch(entity.direction)
                {
                    case "up":
                    {
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gamePanel.object[i].solidArea))
                        {
                            if(gamePanel.object[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            if(player == true)
                            {
                                index = i;
                            }
                            // System.out.println("up collision");
                        }
                        break;
                    }
                    case "down":
                    {
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gamePanel.object[i].solidArea))
                        {
                            if(gamePanel.object[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            if(player == true)
                            {
                                index = i;
                            }
                            // System.out.println("down collision");
                        }
                        break;
                    }
                    case "left":
                    {
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gamePanel.object[i].solidArea))
                        {
                            if(gamePanel.object[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            if(player == true)
                            {
                                index = i;
                            }
                            // System.out.println("left collision");
                        }
                        break;
                    }
                    case "right":
                    {
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gamePanel.object[i].solidArea))
                        {
                            if(gamePanel.object[i].collision == true)
                            {
                                entity.collisionOn = true;
                            }
                            if(player == true)
                            {
                                index = i;
                            }
                            // System.out.println("right collision");
                        }
                        break;
                    }
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gamePanel.object[i].solidArea.x = gamePanel.object[i].solidAreaDefaultX;
                gamePanel.object[i].solidArea.y = gamePanel.object[i].solidAreaDefaultY;
            }
        }

        return index;
    }
}
