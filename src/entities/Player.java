package entities;

import utils.BorderControl;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends IGameObject {

    private BufferedImage playerImg;	//Zeichnet im hintegrund ein Bild, welches dann sichtbar gemacht werden kann 

    private boolean isLookingLeft = true;

<<<<<<< Updated upstream
    private int maxX, maxY;

    private BorderControl[] borders;

    public Player(final double x, final double y, final BufferedImage playerImg, final int maxX, final int maxY) {
        super(new Rectangle((int) x, (int) y, playerImg.getWidth(), playerImg.getHeight()), 0, 0);
=======
    public Player(final double x, final double y, final BufferedImage playerImg) {
        super(new Rectangle((int)x,(int)y,playerImg.getWidth(),playerImg.getHeight()), 0, 0);	//(Rectangle(x, y, Breite, Höhe), geschwindigkeitX, GeschwindigkeitY)
>>>>>>> Stashed changes
        this.playerImg = playerImg;
        this.maxX = maxX;
        this.maxY = maxY;
        this.borders = new BorderControl[]{
                new BorderControl(new Rectangle(-100, 0, 100, maxY)), // left
                new BorderControl(new Rectangle(maxX, 0, 100, maxY)), //right
                new BorderControl(new Rectangle(0, (int) (maxY * 0.965), maxX, 100)), // bottom
                new BorderControl(new Rectangle(0, (int) (maxY * 0.02), maxX, 100)), // top
                new BorderControl(new Rectangle(0, (int) (maxY * 0.755), (int) (maxX * 0.09), 132)), // row 0 0
                new BorderControl(new Rectangle((int) (maxX * 0.135), (int) (maxY * 0.755), (int) (maxX * 0.142), 132)), // row 0 1
                new BorderControl(new Rectangle((int) (maxX * 0.325), (int) (maxY * 0.755), (int) (maxX * 0.75), 132)), // row 0 2
                new BorderControl(new Rectangle(0, (int) (maxY * 0.55), (int) (maxX * 0.58), 129)), // row 1 0
                new BorderControl(new Rectangle((int) (maxX * 0.627), (int) (maxY * 0.55), (int) (maxX * 0.196), 129)), // row 1 1
                new BorderControl(new Rectangle((int) (maxX * 0.87), (int) (maxY * 0.55), (int) (maxX * 0.3), 129)), // row 1 2
                new BorderControl(new Rectangle(0, (int) (maxY * 0.342), (int) (maxX * 0.4), 129)), // row 2 0
                new BorderControl(new Rectangle((int) (maxX * 0.45), (int) (maxY * 0.342), (int) (maxX * 0.6), 129)), // row 2 1
                new BorderControl(new Rectangle(0, (int) (maxY * 0.08), (int) (maxX * 0.19), 200)), // row 3 0
                new BorderControl(new Rectangle((int) (maxX * 0.237), (int) (maxY * 0.17), (int) (maxX * 0.522), 77)), // row 3 1 under heart
                new BorderControl(new Rectangle((int) (maxX * 0.807), (int) (maxY * 0.08), (int) (maxX * 0.2), 200)), // row 3 2
        };
    }

    public void tick() {
        super.x += super.velX;
        super.y += super.velY;

        /*final BorderControl bottomBorder = new BorderControl(new Rectangle(0, (int) (maxY * 0.965), maxX, 100));
        bottomBorder.forceOutOfBorders(this);

        final BorderControl rightBorder = new BorderControl(new Rectangle(maxX, 0, 100, maxY));
        rightBorder.forceOutOfBorders(this);*/

        for (int i = 0; i < borders.length; i++) {
            borders[i].forceOutOfArea(this);
        }
    }

    public void render(final Graphics g) {
        final int playerSize = playerImg.getWidth();
        if (isLookingLeft) {
            g.drawImage(playerImg, (int) (Math.floor(getX()) + playerSize), (int) Math.floor(getY()), -playerSize, playerSize, null); // draws the player
            //                                                                                        A
            //                                                                                        | this minus flips the image horizontally
        } else {
            g.drawImage(playerImg, (int) Math.floor(getX()), (int) Math.floor(getY()), playerSize, playerSize, null); // draws the player
        }
    }

    public void setIsLookingLeft(final boolean isLookingLeft) {
        this.isLookingLeft = isLookingLeft;
    }
}
