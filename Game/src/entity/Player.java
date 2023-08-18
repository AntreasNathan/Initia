package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;


public class Player extends Entity {

	public GamePanel gp;
	public KeyHandler keyH;
	public final int screenX, screenY;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		this.screenX = (gp.screenWidth / 2) - gp.tileSize/2;
		this.screenY = (gp.screenHeight / 2) - gp.tileSize/2;
		
		//solid area is rectangle at the centre/lower end of the player
		solidArea = new Rectangle();
		//x,y indicates the upper right point of the rectangle 'solid' area
		//adding -1 for straight surfaces like the beginning
		//number are the pixels of the 16x16 image
		solidArea.x = 5 * gp.scale;
		solidArea.y = 8 * gp.scale;
		
		solidArea.width = gp.tileSize - (solidArea.x * 2);
		solidArea.height = gp.tileSize - (solidArea.y) - 1;
		
		this.seDefaultValues();
		this.getImage();
		
	}
	
	public void seDefaultValues() {
		
		this.worldX = gp.tileSize * 23;
		this.worldY = gp.tileSize * 21;
		this.speed = 10;
		this.directionV = "up";
		this.directionH = "right";
		
	}
	
	public void getImage() {
		
		try {
			up0 = ImageIO.read(getClass().getResource("/CharacterUp/frame_0_delay-0.png"));
			up1 = ImageIO.read(getClass().getResource("/CharacterUp/frame_1_delay-0.png"));
			up2 = ImageIO.read(getClass().getResource("/CharacterUp/frame_2_delay-0.png"));
			up3 = ImageIO.read(getClass().getResource("/CharacterUp/frame_3_delay-0.png"));
			upleft0 = ImageIO.read(getClass().getResource("/CharacterUpLeft/frame_0_delay-0.png"));
			upleft1 = ImageIO.read(getClass().getResource("/CharacterUpLeft/frame_1_delay-0.png"));
			upleft2 = ImageIO.read(getClass().getResource("/CharacterUpLeft/frame_2_delay-0.png"));
			upleft3 = ImageIO.read(getClass().getResource("/CharacterUpLeft/frame_3_delay-0.png"));
			upright0 = ImageIO.read(getClass().getResource("/CharacterUpRight/frame_0_delay-0.png"));
			upright1 = ImageIO.read(getClass().getResource("/CharacterUpRight/frame_1_delay-0.png"));
			upright2 = ImageIO.read(getClass().getResource("/CharacterUpRight/frame_2_delay-0.png"));
			upright3 = ImageIO.read(getClass().getResource("/CharacterUpRight/frame_3_delay-0.png"));
			down0 = ImageIO.read(getClass().getResource("/CharacterDown/frame_0_delay-0.png"));
			down1 = ImageIO.read(getClass().getResource("/CharacterDown/frame_1_delay-0.png"));
			down2 = ImageIO.read(getClass().getResource("/CharacterDown/frame_2_delay-0.png"));
			down3 = ImageIO.read(getClass().getResource("/CharacterDown/frame_3_delay-0.png"));
			downleft0 = ImageIO.read(getClass().getResource("/CharacterDownLeft/frame_0_delay-0.png"));
			downleft1 = ImageIO.read(getClass().getResource("/CharacterDownleft/frame_1_delay-0.png"));
			downleft2 = ImageIO.read(getClass().getResource("/CharacterDownLeft/frame_2_delay-0.png"));
			downleft3 = ImageIO.read(getClass().getResource("/CharacterDownLeft/frame_3_delay-0.png"));
			downright0 = ImageIO.read(getClass().getResource("/CharacterDownRight/frame_0_delay-0.png"));
			downright1 = ImageIO.read(getClass().getResource("/CharacterDownRight/frame_1_delay-0.png"));
			downright2 = ImageIO.read(getClass().getResource("/CharacterDownRight/frame_2_delay-0.png"));
			downright3 = ImageIO.read(getClass().getResource("/CharacterDownRight/frame_3_delay-0.png"));
			left0 = ImageIO.read(getClass().getResource("/CharacterLeft/frame_0_delay-0.png"));
			left1 = ImageIO.read(getClass().getResource("/CharacterLeft/frame_1_delay-0.png"));
			left2 = ImageIO.read(getClass().getResource("/CharacterLeft/frame_2_delay-0.png"));
			left3 = ImageIO.read(getClass().getResource("/CharacterLeft/frame_3_delay-0.png"));
			right0 = ImageIO.read(getClass().getResource("/CharacterRight/frame_0_delay-0.png"));
			right1 = ImageIO.read(getClass().getResource("/CharacterRight/frame_1_delay-0.png"));
			right2 = ImageIO.read(getClass().getResource("/CharacterRight/frame_2_delay-0.png"));
			right3 = ImageIO.read(getClass().getResource("/CharacterRight/frame_3_delay-0.png"));


		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update() {
		
		if(keyH.upPressed == true || (keyH.downPressed == true) 
			|| (keyH.leftPressed == true) || (keyH.rightPressed == true)) {
			
			if(keyH.upPressed == true && keyH.leftPressed == true) {
				if((worldY-speed) <= 0)
					worldY = 0;
				else if((worldX-speed) <= 0)
					worldX = 0;
				
				directionV = "up";
				directionH = "left";
			
			}
			else if(keyH.upPressed == true && keyH.rightPressed == true) {
				if((worldY-speed) <= 0)
					worldY = 0;
				else if((worldX+speed) >= (gp.worldWidth - gp.tileSize))
					worldX = (gp.worldWidth - gp.tileSize);

				directionV = "up";
				directionH = "right";
			}
			else if(keyH.downPressed == true && keyH.rightPressed == true) {
				if((worldY + speed) >= (gp.worldHeight - gp.tileSize))
					worldY = (gp.worldHeight - gp.tileSize);
				else if((worldX+speed) >= (gp.worldWidth - gp.tileSize))
					worldX = (gp.worldWidth - gp.tileSize);

				directionV = "down";
				directionH = "right";
			}
			else if(keyH.downPressed == true && keyH.leftPressed == true) {
				if((worldY + speed) >= (gp.worldHeight - gp.tileSize))
					worldY = (gp.worldHeight - gp.tileSize);
				else if((worldX-speed) <= 0)
					worldX = 0;

				directionV = "down";
				directionH = "left";
			}
			else if(keyH.upPressed == true) {
				if((worldY-speed) <= 0)
					worldY = 0;

				//System.out.println("up");
				directionV = "up";
				directionH = "NULL";
			}
			else if(keyH.downPressed == true) {
				if((worldY + speed) >= (gp.worldHeight - gp.tileSize))
					worldY = (gp.worldHeight - gp.tileSize);

				//System.out.println("down");
				directionV = "down";
				directionH = "NULL";
			}
			else if(keyH.leftPressed == true) {
				if((worldX-speed) <= 0)
					worldX = 0;

				//System.out.println("left");
				directionH = "left";
				directionV = "NULL";
			}
			else if(keyH.rightPressed == true) {
				if((worldX+speed) >= (gp.worldWidth - gp.tileSize))
					worldX = (gp.worldWidth - gp.tileSize);

				//System.out.println("right");
				directionH = "right";
				directionV = "NULL";
			}
			
			//check player collision
			collisionOn = false;
			gp.cChecker.checkTile(this);
			if(collisionOn) {
				System.out.println("Player: X = " + worldX/gp.tileSize + "  Y = " + worldY/gp.tileSize);
			}
			
			if(collisionOn == false) {
				
				if(directionV == "up" && directionH == "left") {
						worldY -= (speed/2);
						worldX -= (speed/2);
				}
				else if(directionV == "up" && directionH == "right") {
						worldY -= (speed/2);
						worldX += (speed/2);
				}
				else if(directionV == "down" && directionH == "right") {
						worldY += (speed/2);
						worldX += (speed/2);
				}
				else if(directionV == "down" && directionH == "left") {
						worldY += (speed/2);
						worldX -= (speed/2);
				}
				else if(directionV == "up") {
						worldY -= speed;
					
				}
				else if(directionV == "down") {
						worldY += speed;
				}
				else if(directionH == "left") {
						worldX -= speed;
				}
				else if(directionH == "right") {
						worldX += speed;
				}
			}
			
		
			if(WalkCount >=4) {
				WalkNum = (WalkNum%4)+1;
				WalkCount = 0;
			}
		
		}
		
		
		WalkCount ++;
		if(WalkCount >= (speed+1)){
			WalkNum = 0;
			WalkCount = 0;
		}
		
		//System.out.println("PlayerX: " + x + "PlayerY: " + y);
	
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = right0;
		
		
		if(directionV.equals("up") && (directionH.equals("left"))) {
			if(WalkNum == 1)
				image = upleft1;
			else if(WalkNum == 2)
				image = upleft2;
			else if(WalkNum == 3)
				image = upleft3;
			else
				image = upleft0;
		}
		else if(directionV.equals("up") && (directionH.equals("right"))) {
			if(WalkNum == 1)
				image = upright1;
			else if(WalkNum == 2)
				image = upright2;
			else if(WalkNum == 3)
				image = upright3;
			else
				image = upright0;
		}
		else if(directionV.equals("down") && (directionH.equals("left"))) {
			if(WalkNum == 1)
				image = downleft1;
			else if(WalkNum == 2)
				image = downleft2;
			else if(WalkNum == 3)
				image = downleft3;
			else
				image = downleft0;
		}
		else if(directionV.equals("down") && (directionH.equals("right"))) {
			if(WalkNum == 1)
				image = downright1;
			else if(WalkNum == 2)
				image = downright2;
			else if(WalkNum == 3)
				image = downright3;
			else
				image = downright0;
		}
		else if(directionV.equals("up")) {
			if(WalkNum == 1)
				image = up1;
			else if(WalkNum == 2)
				image = up2;
			else if(WalkNum == 3)
				image = up3;
			else
				image = up0;
		}
		else if(directionV.equals("down")) {
			if(WalkNum == 1)
				image = down1;
			else if(WalkNum == 2)
				image = down2;
			else if(WalkNum == 3)
				image = down3;
			else
				image = down0;
		}
		else if(directionH.equals("left")) {
			if(WalkNum == 1)
				image = left1;
			else if(WalkNum == 2)
				image = left2;
			else if(WalkNum == 3)
				image = left3;
			else
				image = left0;
		}
		else if(directionH.equals("right")) {
			if(WalkNum == 1)
				image = right1;
			else if(WalkNum == 2)
				image = right2;
			else if(WalkNum == 3)
				image = right3;
			else
				image = right0;
		}
		
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		
	}
	
}
