package minigames;

import java.awt.Image;
import java.util.Vector;

public class Character {
	private final Character pos, vel;
	
	public Character getVel() {
		return vel;
		
		
		
	}
	public final static int Radius= 20; 
	
	
//	private int speed_x;
//	private int speed_y; 
//	private Image img;          	
	  // Bei Statischen variablen kann man sie mit Klasse.Variable in allen Klassen aufrufen 
	
	
	
	public Character () {
	
		
		pos = new Character(GUI.Width / 2, GUI.Height / 2); 
		vel = new Character(2);
		
	}
	
	public Character getPos() {
		return pos;
	}	
	
	
	public void Update() {             // Update Methode um die neue Position zu berechnen
		
		pos.setX(pos.getX() + vel.getX());			// Methodenaufruf --> Klammern
		pos.setY(pos.getY() + vel.getY());
	}

		

			
	
			//this.hitbox.Location(this.pos_x - this.hitbox_rad / 2, this.pos_y - this.hitbox_rad / 2); 	//set Location? 
			// Errechnen des mittelpunks, da die Hitbox verschoben und nicht zentralisiert ist
			
}





