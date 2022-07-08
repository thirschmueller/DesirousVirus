package minigames;

import java.awt.Image;
import java.awt.Shape;


import org.newdawn.slick.geom.Circle;


public class Enemy {

	protected int pos_x; 
	protected int pos_y; 
	protected int speed_x;
	protected int speed_y; 
	protected Image img;          		
	public final static int Radius= 20;   // Bei Statischen variablen kann man sie mit Klasse.Variable in allen Klassen aufrufen 
	
	public Enemy(int x, int y, int speed_x, int speed_y)
	{
		this.img = img;
		this.pos_x = x;
		this.pos_y = y;
		this.speed_x = speed_x;
		this.speed_y = speed_y;
		
	}
	
		public void Update()              // Update Methode um die neue Position zu berechnen
		{
			this.pos_x += this.speed_x;
			this.pos_y += this.speed_y;
			

			
		//	this.hitbox.Location(this.pos_x - this.hitbox_rad / 2, this.pos_y - this.hitbox_rad / 2); 	//set Location? Errechnen des mittelpunks, da die Hitbox verschoben und nicht zentralisiert ist


		}
		
}