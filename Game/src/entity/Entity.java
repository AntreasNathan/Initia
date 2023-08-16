package entity;

import java.awt.image.BufferedImage;



public class Entity {

	public int worldX, worldY;
	public int speed;
	
	public BufferedImage up0, up1, up2, up3, upleft0, upleft1, upleft2, upleft3, upright0, upright1, upright2, upright3, down0, down1, down2, down3, 
						downleft0, downleft1, downleft2, downleft3, downright0, downright1, downright2, downright3, 
						left0, left1, left2, left3, right0, right1, right2, right3;
	
	public int WalkCount = 0;
	public int WalkNum = 0;
	
}
