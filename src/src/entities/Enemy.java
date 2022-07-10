package src.entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    private double x;
    private double maxX;
    private double y;

    private BufferedImage enemyImg;

    private double velX;

    private boolean isLookingLeft;
    private boolean isDead;

    public Enemy(final BufferedImage enemyImg, final double y, final double maxX, final double velX, final boolean isLookingLeft) {
        this.x = isLookingLeft ? maxX + enemyImg.getWidth() : -enemyImg.getWidth();
        this.y = y;
        this.isDead = false;
        this.velX = isLookingLeft ? -velX : velX;
        this.isLookingLeft = isLookingLeft;
        this.enemyImg = enemyImg;
        this.maxX = maxX;
    }

    public void tick() {
        if (isOutOfBounds()) {
            isDead = true;
        } else {
            x += velX;
        }
    }

    private boolean isOutOfBounds() {
        if (isLookingLeft) {
            return x < 0;
        } else {
            return x > maxX + enemyImg.getWidth();
        }
    }

    public void render(final Graphics g) {
        final int playerSize = enemyImg.getWidth();
        if (isLookingLeft) {
            g.drawImage(enemyImg, (int) Math.floor(x), (int) Math.floor(y), -playerSize, playerSize, null); // draws the player
            //                                                               A
            //                                                               | this minus flips the image horizontally
        } else {
            g.drawImage(enemyImg, (int) Math.floor(x), (int) Math.floor(y), playerSize, playerSize, null); // draws the player
        }
    }

    public boolean getIsDead() {
        return isDead;
    }
}
