package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends IGameObject {

    private BufferedImage playerImg;

    private boolean isLookingLeft = true;

    public Player(final double x, final double y, final BufferedImage playerImg) {
        super(new Rectangle((int)x,(int)y,playerImg.getWidth(),playerImg.getHeight()), 0, 0);
        this.playerImg = playerImg;
    }

    public void render(final Graphics g) {
        final int playerSize = playerImg.getWidth();
        if (isLookingLeft) {
            g.drawImage(playerImg, (int) (Math.floor(getX()) + playerSize * 1.35), (int) Math.floor(getY()), -playerSize, playerSize, null); // draws the player
            //                                                                                             A
            //                                                                                             | this minus flips the image horizontally
        } else {
            g.drawImage(playerImg, (int) Math.floor(getX()), (int) Math.floor(getY()), playerSize, playerSize, null); // draws the player
        }
    }

    public void setIsLookingLeft(final boolean isLookingLeft) {
        this.isLookingLeft = isLookingLeft;
    }
}
