package entities;

import utils.BorderControl;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends IGameObject {

    private BufferedImage playerImg;    //Zeichnet im hintegrund ein Bild, welches dann sichtbar gemacht werden kann

    private boolean isLookingLeft = true;

    private BorderControl[] borders;

    private double scale;


    public Player(final double x, final double y, final BufferedImage playerImg, final int maxX, final int maxY, final double scale) {
        super(new Rectangle((int) x, (int) y, (int) (playerImg.getWidth() * scale), (int) (playerImg.getHeight() * scale)), 0, 0);    //(Rectangle(x, y, Breite, H�he), geschwindigkeitX, GeschwindigkeitY)

        this.scale = scale;
        this.playerImg = playerImg;
        this.borders = new BorderControl[]{
                new BorderControl(new Rectangle((int) (maxX * -0.039), 0, (int) (maxX * 0.039), maxY)), // left
                new BorderControl(new Rectangle(maxX, 0, (int) (maxX * 0.039), maxY)), //right
                new BorderControl(new Rectangle(0, (int) (maxY * 0.965), maxX, (int) (maxY * 0.073))), // bottom
                new BorderControl(new Rectangle(0, (int) (maxY * 0.02), maxX, (int) (maxY * 0.073))), // top
                new BorderControl(new Rectangle(0, (int) (maxY * 0.755), (int) (maxX * 0.09), (int) (maxY * 0.0964))), // row 0 0
                new BorderControl(new Rectangle((int) (maxX * 0.135), (int) (maxY * 0.755), (int) (maxX * 0.142), (int) (maxY * 0.0964))), // row 0 1
                new BorderControl(new Rectangle((int) (maxX * 0.325), (int) (maxY * 0.755), (int) (maxX * 0.75), (int) (maxY * 0.0964))), // row 0 2
                new BorderControl(new Rectangle(0, (int) (maxY * 0.55), (int) (maxX * 0.58), (int) (maxY * 0.0942))), // row 1 0
                new BorderControl(new Rectangle((int) (maxX * 0.627), (int) (maxY * 0.55), (int) (maxX * 0.196), (int) (maxY * 0.0942))), // row 1 1
                new BorderControl(new Rectangle((int) (maxX * 0.87), (int) (maxY * 0.55), (int) (maxX * 0.3), (int) (maxY * 0.0942))), // row 1 2
                new BorderControl(new Rectangle(0, (int) (maxY * 0.342), (int) (maxX * 0.4), (int) (maxY * 0.0942))), // row 2 0
                new BorderControl(new Rectangle((int) (maxX * 0.45), (int) (maxY * 0.342), (int) (maxX * 0.6), (int) (maxY * 0.0942))), // row 2 1
                new BorderControl(new Rectangle(0, (int) (maxY * 0.08), (int) (maxX * 0.19), (int) (maxY * 0.146))), // row 3 0
                new BorderControl(new Rectangle((int) (maxX * 0.237), (int) (maxY * 0.17), (int) (maxX * 0.522), (int) (maxY * 0.0562))), // row 3 1 under heart
                new BorderControl(new Rectangle((int) (maxX * 0.807), (int) (maxY * 0.08), (int) (maxX * 0.2), (int) (maxY * 0.146))), // row 3 2
        };
    }

    public void tick() {
        super.x += super.velX;	//super, weil es alles aus player und IGameObjects können soll 
        super.y += super.velY;

        for (int i = 0; i < borders.length; i++) {
            borders[i].forceOutOfArea(this);

        }
    }

    public void render(final Graphics g) {

        final int playerSize = (int) (playerImg.getWidth() * scale);
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
