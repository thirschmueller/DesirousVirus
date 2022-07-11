package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends IGameObject {
    private BufferedImage enemyImg;

    private boolean isLookingLeft;
    private boolean isDead;

    public Enemy(final BufferedImage enemyImg, final double y, final double maxX, final double velX, final boolean isLookingLeft) {
        super(new Rectangle((int) (isLookingLeft ? maxX + enemyImg.getWidth() : -enemyImg.getWidth()), (int) y, (int) maxX, enemyImg.getHeight()), velX, 0);
        this.isDead = false;
        this.isLookingLeft = isLookingLeft;
        this.enemyImg = enemyImg;
    }

    @Override
    public void tick() {
        if (isOutOfBounds()) {
            isDead = true;
        } else {
            setX(getX() + getVelX());
        }
    }

    @Override
    public void render(final Graphics g) {
        final int playerSize = enemyImg.getWidth();
        if (isLookingLeft) {
            g.drawImage(enemyImg, (int) Math.floor(getX()), (int) Math.floor(getY()), -playerSize, playerSize, null); // draws the player
            //                                                                        A
            //                                                                        | this minus flips the image horizontally
        } else {
            g.drawImage(enemyImg, (int) Math.floor(getX()), (int) Math.floor(getY()), playerSize, playerSize, null); // draws the player
        }
    }

    public boolean getIsDead() {
        return isDead;
    }

    private boolean isOutOfBounds() {
        if (isLookingLeft) {
            return getX() < 0;
        } else {
            return getX() > getX() + getBorder().getWidth() + enemyImg.getWidth();
        }
    }
}
