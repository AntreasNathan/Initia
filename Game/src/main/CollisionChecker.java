package main;

import entity.Entity;

public class CollisionChecker {
	
	GamePanel gp;
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX / gp.tileSize;
		int entityRightCol = entityRightWorldX / gp.tileSize;
		int entityTopRow = entityTopWorldY / gp.tileSize;
		int entityBottomRow = entityBottomWorldY / gp.tileSize;
		
		int tileNum1, tileNum2, tileNum3, tileNum4;
		
		if(entity.directionV.equals("up") && entity.directionH.equals("left")) {
			entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
			entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum3 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum4 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if(	gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true
				|| gp.tileM.tile[tileNum3].collision == true || gp.tileM.tile[tileNum4].collision == true) {
				entity.collisionOn = true;
			}
		}
		else if(entity.directionV.equals("up") && entity.directionH.equals("right")) {
			entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
			entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum3 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum4 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(	gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true
				|| gp.tileM.tile[tileNum3].collision == true || gp.tileM.tile[tileNum4].collision == true) {
				entity.collisionOn = true;
			}
		}
		else if(entity.directionV.equals("down") && entity.directionH.equals("left")) {
			entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
			entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			tileNum3 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum4 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if(	gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true
				|| gp.tileM.tile[tileNum3].collision == true || gp.tileM.tile[tileNum4].collision == true) {
				entity.collisionOn = true;
			}
		}
		else if(entity.directionV.equals("down") && entity.directionH.equals("right")) {
			entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
			entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			tileNum3 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum4 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(	gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true
				|| gp.tileM.tile[tileNum3].collision == true || gp.tileM.tile[tileNum4].collision == true) {
				entity.collisionOn = true;
			}
		}
		else if(entity.directionV.equals("up")) {
			entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
		}
		else if(entity.directionV.equals("down")) {
			entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
		}
		else if(entity.directionH.equals("left")) {
			entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
		}
		else if(entity.directionH.equals("right")) {
			entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
		
			
		}
		
		
	}
	
}
