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
	Tile[] tile;
	int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[10];
		mapTileNum = new int[gp.maxScreenRow][gp.maxScreenCol];
		
		getTileImage();
		loadMap();
	}
	
	public void getTileImage() {
		
		try {
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/water.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/sand.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/earth.png"));
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/tree.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/wall.png"));
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/wall.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadMap() {
		
		try {
			
			InputStream input = getClass().getResourceAsStream("/Maps/testMap.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			int col = 0;
			int row = 0;
			
			while(row < gp.maxScreenRow) {
				String line = reader.readLine();
				
				String numbers[] = line.split(" ");
				for(col=0 ; col<gp.maxScreenCol ; col++) {
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
		
		for(int row=0 ; row<gp.maxScreenRow ; row++) {
			for(int col=0 ; col<gp.maxScreenCol ; col++)
				g2.drawImage(tile[mapTileNum[row][col]-1].image, col * gp.tileSize, row * gp.tileSize, gp.tileSize, gp.tileSize, null);
		}
		
		
	}
	
}
