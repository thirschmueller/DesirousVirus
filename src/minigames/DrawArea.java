package minigames;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawArea extends JPanel{

//	private static final long serialVersionUID = 1L;   //Implementieren, dass eclipse kein fehler anzeigt 
	
	private final JFrame parent; 
	private final Character Player = new Character();
	
	public DrawArea(final JFrame j) {
		parent = j;
	}


	public void update() {
		Player.Update();
		parent.repaint();   		// aufrufen von Paint methode und neu rendern von allem auf dem Bildschirm
		
	}
	@Override
	public void paint(Graphics g) {			// Paint methode um sachen auf den Bildschirm zu zeichnen 
		g.setColor(Color.white);    		// Farbe von dem gemalten
		g.fillOval(Player.getPos().getX, Player.getPos().getY(), Character.Radius, Character.Radius);   	// Größe und Position von Character
	}
		

}

