package controllers;

import entities.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MovementController extends KeyAdapter { //keyadapter statt keylistener (hat schon alles vom keylistener drin, aber man definiert selbst nur die Methoden, die man braucht

    private final Player p;

    public MovementController(final Player p) { 
        this.p = p; // wird genutzt, da man das Koordinatensystem aus der Klasse Player(bzw. IGameObject) verwenden will
    }

    /* Methode, damit man mit dem druecken der genannten Tasten steuern kann*/
    public void keyPressed(KeyEvent e) {
        final double speed = 3;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: // Vk ist das Virtual keyboard, welches vordefiniert ist, aber die Tasten lesbar
            case KeyEvent.VK_UP:
                p.setVelY(-speed); // negativer speed in y-Richtung, wenn w gedrückt wird
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

    /* Methode für smooth movements: wenn eine dieser Tasten losgelassen wird, wird die Geschwindigkeit auf 0 gesetzt*/
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_S
                || keyCode == KeyEvent.VK_DOWN) { 
            p.setVelY(0);
        } else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_D
                || keyCode == KeyEvent.VK_RIGHT) {
            p.setVelX(0);
        }
    }
}
