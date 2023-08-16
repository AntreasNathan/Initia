package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;


public class GamePanel extends JPanel implements Runnable{
	
	//Screen Settings
	final int originalCharacterSize = 16;  //16x16 tile
	//final int scale = 3;
	final int scale = 5;
	
	public final int tileSize = originalCharacterSize * scale;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	//public final int screenWidth = tileSize * maxScreenCol;
	public final int screenWidth = tileSize * maxScreenCol;
	//public final int screenHeight = tileSize * maxScreenRow;
	public final int screenHeight = tileSize * maxScreenRow;
	
	//WORLD PARAMETERS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	//FPS
	final int fps = 60;
	
	KeyHandler keyH =new KeyHandler();
	Thread gameThread; 		//bring time to the game
	public Player player = new Player(this, keyH);
	
	TileManager tileM = new TileManager(this);
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.green);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		//fps with sleep method
//		double drawInterval = 1000000000/fps;
//		double nextDrawTime = System.nanoTime() + drawInterval;
//		//double remainingTime;
//		
//		while(gameThread != null) {
//			
//			
//			
//			update();		//call update()
//			
//			repaint();		//call paintComponent()
//			
//			
//			try {
//				double remainingTime = nextDrawTime - System.nanoTime();
//				remainingTime/=1000000;
//				
//				if(remainingTime < 0)
//					remainingTime = 0;
//				
//				Thread.sleep((long) remainingTime);
//				
//				nextDrawTime += drawInterval;
//				
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
		
		
		//second method
		double drawInterval = 1000000000/fps;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		int drawCount = 0;
		long timer = 0;
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
				repaint();
				delta --;
				drawCount++;
			}
			
			if(timer >= 1000000000) {
				System.out.println("Fps: " + drawCount);
				drawCount = 0;
				timer = 0;
			}
			
		}
		
		
	}
	
	public void update() {
		player.update();
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;	//more factions to use
		
		tileM.draw(g2);
		
		player.draw(g2);
		
		g2.dispose();
	}
	
}
