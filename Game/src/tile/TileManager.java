package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;



public class TileManager {
	
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[10];
		mapTileNum = new int[gp.maxWorldRow][gp.maxWorldCol];
		
		getTileImage();
		loadMap("/Maps/world01.txt");
	}
	
	public void getTileImage() {
		
		try {
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/grass.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/wall.png"));
			tile[1].collision = true;
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water.png"));
			tile[2].collision = true;
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/earth.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/tree.png"));
			tile[4].collision = true;
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/sand.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadMap(String mapStr) {
		
		try {
			
			InputStream input = getClass().getResourceAsStream(mapStr);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			int col = 0;
			int row = 0;
			
			while(row < gp.maxWorldRow) {
				String line = reader.readLine();
				
				String numbers[] = line.split(" ");
				for(col=0 ; col<gp.maxWorldCol ; col++) {
					mapTileNum[row][col] = Integer.parseInt(numbers[col]);
				}
				//System.out.println();
				row++;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void draw(Graphics2D g2) {
		
		int minPrintX = (gp.player.worldX - gp.player.screenX)/gp.tileSize, maxPrintX = ((gp.player.worldX + gp.player.screenX)+gp.tileSize)/gp.tileSize;
		int minPrintY = (gp.player.worldY - gp.player.screenY)/gp.tileSize, maxPrintY = ((gp.player.worldY + gp.player.screenY)+gp.tileSize)/gp.tileSize;
		int worldX, screenX;
		int worldY, screenY;
		
//		for(int worldRow=minPrintX ; worldRow < maxPrintX ; worldRow++) {
//			for(int worldCol=minPrintY ; worldCol < maxPrintY ; worldCol++) {
//				worldX = worldRow * gp.tileSize;
//				worldY = worldCol * gp.tileSize;
//				screenX = worldX - gp.player.worldX + gp.player.screenX;
//				screenY = worldY - gp.player.worldY + gp.player.screenY;
//				g2.drawImage(tile[mapTileNum[worldRow][worldCol]].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
//			}
//		}
		
		for(int worldRow = minPrintX ; worldRow <= maxPrintX ; worldRow++) {
			for(int worldCol = minPrintY ; worldCol <= maxPrintY ; worldCol++) {
				worldX = worldRow * gp.tileSize;
				worldY = worldCol * gp.tileSize;
				screenX = worldX - gp.player.worldX + gp.player.screenX;
				screenY = worldY - gp.player.worldY + gp.player.screenY;
				if(	worldRow >= 0 && worldRow < gp.maxWorldRow &&
					worldCol >= 0 && worldCol < gp.maxWorldCol)	
				g2.drawImage(tile[mapTileNum[worldRow][worldCol]].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			}
		}
		
		
	}
	
}
