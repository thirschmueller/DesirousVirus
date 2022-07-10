package behavior;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import entities.Player;

public class MovementController extends KeyAdapter {

    private final Player p;

    private final int maxX, maxY;

    public MovementController(final Player p, final int maxX, final int maxY) {
        this.p = p;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void keyPressed(KeyEvent e) {
        final int speed = 5;

        if (p.getX() > maxX) { // border right
            p.setVelX(0);
            p.setX(maxX);
            return;
        }
        if (p.getX() < 0) { // border left
            p.setVelX(0);
            p.setX(0);
            return;
        }
        if (p.getY() > maxY) { // border bottom
            p.setVelY(0);
            p.setY(maxY);
            return;
        }
        if (p.getY() < 0) { // border top
            p.setVelY(0);
            p.setY(0);
            return;
        }

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                p.setVelY(-speed);
                break;
            case KeyEvent.VK_A:
                p.setIsLookingLeft(true);
                p.setVelX(-speed);
                break;
            case KeyEvent.VK_S:
                p.setVelY(speed);
                break;
            case KeyEvent.VK_D:
                p.setIsLookingLeft(false);
                p.setVelX(speed);
                break;
            case KeyEvent.VK_LEFT:
                p.setIsLookingLeft(true);
                p.setVelX(-speed * 2);
                break;
            case KeyEvent.VK_UP:
                p.setVelY(-speed * 2);
                break;
            case KeyEvent.VK_RIGHT:
                p.setIsLookingLeft(false);
                p.setVelX(speed * 2);
                break;
            case KeyEvent.VK_DOWN:
                p.setVelY(speed * 2);
                break;
        }

    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
            p.setVelY(0);
        } else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
            p.setVelX(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Pressed: " + e.getKeyChar() + ", (code: " + e.getKeyCode() + ")");
    }
}
