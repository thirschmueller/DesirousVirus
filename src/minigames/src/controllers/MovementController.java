package minigames.src.controllers;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementController implements KeyListener {
    private final Component component;

    public MovementController(final Component component) {
        this.component = component;
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
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Pressed: " + e.getKeyChar() + ", (code: " + e.getKeyCode() + ")");
    }
}
