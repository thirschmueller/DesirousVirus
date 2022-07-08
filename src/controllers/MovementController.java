package controllers;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementController implements KeyListener {
	private final Component component;
	private int winWidth, winHeight;  				// alles was sich von einem Objekt verändert darf nicht static sein
	
	public MovementController(final Component component, final int winWidth, final int winHeight) {
		this.component = component; 
		this.winWidth = winWidth;
		this.winHeight = winHeight;
				
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		final int x = component.getX();
		final int y = component.getY();

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
		if (x > winWidth-1000)
			component.setLocation(winWidth -1051, y);
		if (x < 0)
			component.setLocation(1, y);
		if (y > winHeight-1000)
			component.setLocation(x, winHeight -1051);
		if (y < 0)
			component.setLocation(x, 1);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Pressed: " + e.getKeyChar() + ", (code: " + e.getKeyCode() + ")");
	}
}
