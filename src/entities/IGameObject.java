package entities;

import java.awt.*;

public abstract class IGameObject {
    private Rectangle r;
    private double x, y, velX, velY;

    public IGameObject(final Rectangle r, final double velX, final double velY) {
        this.r = r;
        this.x = r.getX();
        this.y = r.getY();
        this.velX = velX;
        this.velY = velY;
    }

    public abstract void render(final Graphics g);

    public void tick() {
        x += velX;
        y += velY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(final double x) {
        this.x = x;
    }

    public void setY(final double y) {
        this.y = y;
    }

    public double getVelX() {
        return velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelX(final double velX) {
        this.velX = velX;
    }

    public void setVelY(final double velY) {
        this.velY = velY;
    }

    public Rectangle getBorder() {
        return r;
    }
}
