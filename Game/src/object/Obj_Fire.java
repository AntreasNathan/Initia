package object;

import javax.imageio.ImageIO;

public class Obj_Fire extends SuperObject {

	public Obj_Fire() {
		
		name = "fire";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/CustomFire.png"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
