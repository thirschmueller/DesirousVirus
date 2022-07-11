package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    private double x;
    private double y;

    private BufferedImage playerImg;

    private double velX;
    private double velY;

    private boolean isLookingLeft = true;

    public Player(final double x, final double y, final BufferedImage playerImg) {
        this.x = x;
        this.y = y;
        this.playerImg = playerImg;
    }

    public void tick() {
        x += velX;
        y += velY;
    }

    public void render(final Graphics g) {
        final int playerSize = playerImg.getWidth();
        if (isLookingLeft) {
            g.drawImage(playerImg, (int) Math.floor(x), (int) Math.floor(y), -playerSize, playerSize, null); // draws the player
            //                                                               A
            //                                                               | this minus flips the image horizontally
        } else {
            g.drawImage(playerImg, (int) Math.floor(x), (int) Math.floor(y), playerSize, playerSize, null); // draws the player
        }
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

    public void setVelX(final double velX) {
        this.velX = velX;
    }

    public void setVelY(final double velY) {
        this.velY = velY;
    }

    public void setIsLookingLeft(final boolean isLookingLeft) {
        this.isLookingLeft = isLookingLeft;
    }
}
