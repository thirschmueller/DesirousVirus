package entities;

import java.awt.Rectangle;

public class Player {
	private int x;
	private int y;
	private int velX = 0;
	private int velY = 0;

	public Player(int x, int y, int velX, int velY) {
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
	}

//	public void tick() {
//		x += velX;
//		y += velY;
//	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public void setLocation(int i, int y2) {
		// TODO Auto-generated method stub
		
	}

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
}
