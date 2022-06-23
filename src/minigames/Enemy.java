package minigames;

public class Enemy {

	protected int pos_x; 
	protected int pos_y; 
	protected int speed_x;
	protected int speed_y; 
	protected Shape hitbox;
	protected Image img;          		//LWJGL und Slick implementieren
	protected int hitbox_rad;

	
	public Enemy(int x, int y, int speed_x, int speed_y, int hitbox_rad)
	{
		this.img = img;
		this.pos_x = x;
		this.pos_y = y;
		this.hitbox_rad = hitbox_rad;
		this.speed_x = speed_x;
		this.speed_y = speed_y;
		this.hitbox = new Circle(x, y, hitbox_rad);
		
	}
	
		public void NewPosition()
		{
			this.pos_x += this.speed_x;
			this.pos_y += this.speed_y;
			
			this.hitbox.Location(this.pos_x - this.hitbox_rad / 2, this.pos_y - this.hitbox_rad / 2); 	//set Location? 
			// Errechnen des mittelpunks, da die Hitbox verschoben und nicht zentralisiert ist
		}
}