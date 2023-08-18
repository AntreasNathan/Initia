package main;

import object.Obj_Fire;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
		gp.obj[0] = new Obj_Fire();
		gp.obj[0].worldX = 23 * gp.tileSize;
		gp.obj[0].worldY = 7 * gp.tileSize;
		
		gp.obj[1] = new Obj_Fire();
		gp.obj[1].worldX = 7 * gp.tileSize;
		gp.obj[1].worldY = 31 * gp.tileSize;
		
		gp.obj[2] = new Obj_Fire();
		gp.obj[2].worldX = 15 * gp.tileSize;
		gp.obj[2].worldY = 40 * gp.tileSize;
	}
	
}
