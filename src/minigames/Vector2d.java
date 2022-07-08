package minigames;

import java.awt.Image;
import java.util.Vector;

public class Vector2d {
	
	public int xpos;
	public int ypos;
	public int speed;
	//pos = new Character(GUI.Width / 2, GUI.Height / 2); 
	//vel = new Character(2);
	
	public Vector2d() { 	// Konstruktor immer mit klammer direkt dahinter --> Leere Klammern also wenn man keine x/y Werte angeben dann sind sie 0/0
		this.ypos = 0;		// this. --> Dass es wei�, dass man auf das oben definierte Objekt verweist 
		this.ypos = 0;
	}
	
	public Vector2d(int x, int y) {		
		this.xpos = x;
		this.ypos = y;
	}									//Mehtoden �berladen(einmal mit und ohne was in der Klammer, sodass man nicht nur Konstruktor hat sondern auch Variablen ,die man dann wo anders verwenden kann
										//Wenn man einen x/y wert angibt wird der 2. Konstruktor verwendet 
	
	public int getX() {
		return this.xpos;
	}
		
	public int getY() {	
		return this.ypos; 
	}
	
	public void walk(boolean right) {
		if(right == true) {
			xpos += speed;
		}else {
			xpos -= speed;
		}
	
	}
	
	
	public void updateMovement() {	// Update Methode für die neue Position
		xpos += speed;
		ypos += speed;		
		
		
	
	}
	
//	private int speed_x;
//	private int speed_y; //Mehtoden �berladen, sodass man nicht nur Konstruktor hat sondern auch Variablen ,die man dann woanders verwenden kann

//	private Image img;          	
	
	
}
	
		

		

			
	
//			this.hitbox.Location(this.pos_x - this.hitbox_rad / 2, this.pos_y - this.hitbox_rad / 2); 	//set Location? 
			// Errechnen des mittelpunks, da die Hitbox verschoben und nicht zentralisiert ist
			






