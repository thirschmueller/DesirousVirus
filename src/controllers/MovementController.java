package controllers;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class MovementController extends KeyAdapter {
	/*
	 * Keyadapter statt listener (hat schon alles vom Listener drin) Extend this
	 * class to create a {@code KeyEvent} listener and override the methods for the
	 * events of interest. (If you implement the {@code KeyListener} interface, you
	 * have to define all of the methods in it. This abstract class defines null
	 * methods for them all, so you can only have to define methods for events you
	 * care about.) Default von Listener (keine Funktion bisher) --> Man definiert
	 * selbst die die man braucht
	 */

	private final Component component;
	private JFrame frame; // alles was sich von einem Objekt verändert darf nicht static sein aber bei
							// Statischen variablen kann man sie mit Klasse.Variable in allen Klassen
							// aufrufen

	public MovementController(final Component component, final JFrame frame) {
		this.component = component;
		this.frame = frame; // this. --> Dass es weiss dass man auf das oben definierte Objekt verweist

	}

	@Override
	public void keyPressed(KeyEvent e) {

		int x = component.getX();
		int y = component.getY();
		final Rectangle r = frame.getBounds();
		final int winWidth = r.width;
		final int winHeight = r.height;
		final Rectangle recComponent = component.getBounds();
		final int compWidth = recComponent.width;
		final int compHeight = recComponent.height;

		if (x > winWidth - compWidth) {
			component.setLocation(winWidth - (compWidth + 1), y);
			return;
		}
		if (x < 0) {
			component.setLocation(1, y);
			return;
		}
		if (y > winHeight - compHeight) {
			component.setLocation(x, winHeight - (compHeight + 1));
			return;
		}
		if (y < 0) {
			component.setLocation(x, 1);
			return;
		}

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

	public void keyReleased(KeyEvent e) {

		int x = component.getX();
		int y = component.getY();
		final Rectangle r = frame.getBounds();
		final int winWidth = r.width;
		final int winHeight = r.height;
		final Rectangle recComponent = component.getBounds();
		final int compWidth = recComponent.width;
		final int compHeight = recComponent.height;

		if (x > winWidth - compWidth) {
			component.setLocation(winWidth - (compWidth + 1), y);
			return;
		}
		if (x < 0) {
			component.setLocation(1, y);
			return;
		}
		if (y > winHeight - compHeight) {
			component.setLocation(x, winHeight - (compHeight + 1));
			return;
		}
		if (y < 0) {
			component.setLocation(x, 1);
			return;
		}

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

	private int x;
	private int y;
	private int velX = 0;
	private int velY = 0;

	public void update() {
		x += velX;
		y += velY;
	}

	public void setX(int x) {
		this.x = x;
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

	// this.hitbox.Location(this.pos_x - this.hitbox_rad / 2, this.pos_y -
	// this.hitbox_rad / 2); //set Location?
	// Errechnen des mittelpunks, da die Hitbox verschoben und nicht zentralisiert
	// ist

	@Override // Overide überschreibt übergeordnete Klassen (wenn Action performt darüber
				// steht du aber etwas anderes als action haben willst)
	public void keyTyped(KeyEvent e) {
		System.out.println("Pressed: " + e.getKeyChar() + ", (code: " + e.getKeyCode() + ")");
	}
}
