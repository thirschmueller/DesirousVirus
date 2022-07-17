package controllers;

import entities.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

    private final Player p;

    public MovementController(final Player p) { // Konstruktor
        this.p = p; // wird genutzt, da man das coordinatensystem aus der Klasse Player verwenden
        // will
    }

    public void keyPressed(KeyEvent e) {
        final double speed = 3;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: // Vk ist das Virtual keyboard, welches vordefiniert ist aber die Tasten lesbar
            case KeyEvent.VK_UP:
                // macht (keine keycodes)
                p.setVelY(-speed); // negativer speed in y richtung, wenn w gedrückt wird
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                p.setIsLookingLeft(true);
                p.setVelX(-speed);
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                p.setVelY(speed);
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                p.setIsLookingLeft(false);
                p.setVelX(speed);
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_S
                || keyCode == KeyEvent.VK_DOWN) { // wenn eine dieser tasten losgelassen wird, wird die Geschwindigkeit
            // in y-Richtung auf 0 gesetzt (dies erzeugt smoothes movement)
            p.setVelY(0);
        } else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_D
                || keyCode == KeyEvent.VK_RIGHT) {
            p.setVelX(0);
        }
    }
}
