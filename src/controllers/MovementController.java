package controllers;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class MovementController extends KeyAdapter { // Keyadapter statt listener (hat schon alles vom Listener drin)
														// --> Default von Listener (keine Funktion bis dahin)
	private final Component component;
	private JFrame frame; // alles was sich von einem Objekt verändert darf nicht static sein

	public MovementController(final Component component, final JFrame frame) {
		this.component = component;
		this.frame = frame;
		

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		final int x = component.getX();
		final int y = component.getY();
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
			component.setLocation(x, y - 10);
			break;
		case 65: // a
			component.setLocation(x - 10, y);
			break;
		case 83: // s
			component.setLocation(x, y + 10);
			break;
		case 68: // d
			component.setLocation(x + 10, y);
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

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Pressed: " + e.getKeyChar() + ", (code: " + e.getKeyCode() + ")");
	}
}
