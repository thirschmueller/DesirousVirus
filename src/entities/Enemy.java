package entities;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends IGameObject {
    private final BufferedImage enemyImg;

    private final boolean isLookingLeft;
    private boolean isDead;
    private final double maxX, scale;


    public Enemy(final BufferedImage enemyImg, final double y, final double maxX, final double velX, final double enemyScale, final boolean isLookingLeft) {	//beschreibung aller daten des Gegners
        super(new Rectangle((int) (isLookingLeft ? maxX + enemyImg.getWidth() : -enemyImg.getWidth()), (int) y, (int) (enemyImg.getWidth() * enemyScale), (int) (enemyImg.getHeight() * enemyScale)), isLookingLeft ? -velX : velX, 0);
      //super, da man alle Funktionen von IGameObject und Enemy weitergeben will
 
        this.isDead = false;
        this.maxX = maxX;
        this.scale = enemyScale;
        this.isLookingLeft = isLookingLeft;
        this.enemyImg = enemyImg;
    }

    @Override
    /* Methode, die angibt wann ein Gegner tot ist*/
    public void tick() {
        if (isOutOfBounds()) {
            isDead = true;
        } else {
            setX(getX() + getVelX());	
        }
    }

    @Override
    /* Methode rendert Bild des Gegners. Es wird in Blickrichtung nach rechts und links unterschieden.*/
    public void render(final Graphics g) {
        final int enemySize = (int) (enemyImg.getWidth() * scale);
        if (isLookingLeft) {
            g.drawImage(enemyImg, (int) Math.floor(getX()), (int) Math.floor(getY()), -enemySize, enemySize, null); // zeichnet den Spieler, Minus bei "-enemySize" spiegelt das Bild horizontal  
        } else {
            g.drawImage(enemyImg, (int) Math.floor(getX()), (int) Math.floor(getY()), enemySize, enemySize, null); 
        }
    }

    
    public boolean getIsDead() {
        return isDead;
    }

    /* Methode sorgt dafuer, dass er nicht an einer Achse gespiegelt wird, sondern sich auf einer Position dreht*/
    private boolean isOutOfBounds() {
        if (isLookingLeft) {
            return getX() < -enemyImg.getWidth();
        } else {
            return getX() > maxX + enemyImg.getWidth();
        }
    }
}
