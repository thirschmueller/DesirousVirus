package controllers;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class MovementController extends KeyAdapter {
	

	private final Component component;
	private JFrame frame; 

	public MovementController(final Component component, final JFrame frame) { 
		this.component = component;
		this.frame = frame;

	}

	public void keyPressed(KeyEvent e) {

		int x = component.getX(); 
		int y = component.getY();
		final Rectangle r = frame.getBounds(); 
		final int winWidth = r.width;
		final int winHeight = r.height;
		final Rectangle recComponent = component.getBounds();
		final int compWidth = recComponent.width;
		final int compHeight = recComponent.height;

		if (x > winWidth - compWidth) { // weil man obere Linke ecke trackt --> - compwidth
			component.setLocation(winWidth - compWidth, y); // rechts
			return; // wegen void heißt das nur abbrechen, weil man kein return wert hat
		}
		if (x < 0) {
			component.setLocation(0, y); // Links
			return;
		}
		if (y > winHeight - compHeight) { // unten
			component.setLocation(x, winHeight - compHeight);
			return;
		}
		if (y < 0) { // oben
			component.setLocation(x, 0);
			return;
		}

		switch (e.getKeyCode()) {
		case 87: // w
			component.setLocation(x, y - 20); // set location ist predefined und setzt die loacation für component
			break;
		case 65: // a
			component.setLocation(x - 20, y);
			break;
		case 83: // s
			component.setLocation(x, y + 20);
			break;
		case 68: // d
			component.setLocation(x + 20, y);
			break;
		case 37: // left arrow
			component.setLocation(x - 50, y);
			break;
		case 38: // up arrow
			component.setLocation(x, y - 50);
			break;
		case 39: // right arrow
			component.setLocation(x + 50, y);
			break;
		case 40: // down arrow
			component.setLocation(x, y + 50);
			break;

		}

	}

	public void keyReleased(KeyEvent e) { // for smooth movement

		int x = component.getX();
		int y = component.getY();

		switch (e.getKeyCode()) {
		case 87: // w
			component.setLocation(x, y - 20);
			break;
		case 65: // a
			component.setLocation(x - 20, y);
			break;
		case 83: // s
			component.setLocation(x, y + 20);
			break;
		case 68: // d
			component.setLocation(x + 20, y);
			break;
		case 37: // left arrow
			component.setLocation(x - 50, y);
			break;
		case 38: // up arrow
			component.setLocation(x, y - 50);
			break;
		case 39: // right arrow
			component.setLocation(x + 50, y);
			break;
		case 40: // down arrow
			component.setLocation(x, y + 50);
			break;
		}
	}



	// this.hitbox.Location(this.pos_x - this.hitbox_rad / 2, this.pos_y -
	// this.hitbox_rad / 2); //set Location?
	// Errechnen des mittelpunks, da die Hitbox verschoben und nicht zentralisiert
	// ist

	@Override 
	public void keyTyped(KeyEvent e) {
		System.out.println("Pressed: " + e.getKeyChar() + ", (code: " + e.getKeyCode() + ")");
	}
}
