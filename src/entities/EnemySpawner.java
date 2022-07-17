package entities;

import utils.RandomGen;
import utils.CollisionDetection;

import java.awt.*;
import java.awt.image.BufferedImage;


public class EnemySpawner implements Runnable {
    private Enemy[] enemies;

    private final double minY, maxY, maxX, enemyScale;
    private final boolean isLeft;	//Blickrichtung
    private final BufferedImage enemyImg;
    private boolean isRunning = true;

    public EnemySpawner(final BufferedImage enemyImg, final double minY, final double maxY, final double maxX, final boolean isLeft, final double enemyScale, final int maxEnemies) {	//wird in Game verwendet
        this.enemies = new Enemy[maxEnemies];	//maximale Gegneranzahl wird noch festgelegt (Anzahl der Positionen im Array)


        this.minY = minY;
        this.maxY = maxY;
        this.maxX = maxX;
        this.enemyScale = enemyScale;
        this.isLeft = isLeft;
        this.enemyImg = enemyImg;
    }

    /*Methode gibt an was bassieren soll wenn ein hit mit dem Player stattfindet und wird dann in Game definiert*/
    public boolean tick(final IGameObject obj) {	
        if (collisionCheckAll(obj)) {
            return true;
        }
        for (Enemy enemy : enemies) {
            if (enemy != null) {
                enemy.tick();
            }
        }
        return false;
    }

    /*Methode rendert neu gespawnte Gegner*/
    public void render(Graphics g) {	
        for (Enemy enemy : enemies) {
            if (enemy != null) {
                enemy.render(g);
            }
        }
    }

    @Override
    /* Methode, dass Gegner über die Blutbahnen laufen. Wenn sie Bildschirm verlassen, sollen neue Gegnaer nach gewisser Zeit gespawnt werden */
    public void run() {
        while (isRunning) {											// wenn es nicht unterbrochen wird --> durchfuehren
            for (int i = 0; i < enemies.length; i++) {			
                if (enemies[i] == null || enemies[i].getIsDead()) {	
                    enemies[i] = new Enemy(enemyImg, RandomGen.randomBetween(minY, maxY), maxX, RandomGen.randomBetween(1, 4), enemyScale, isLeft);	//wenn er am ende des Bildschirms ist wird er als tot angesehen --> neu spawnen
       
                    try {
                        Thread.sleep((long) RandomGen.randomBetween(20000 / (double) enemies.length, 40000 / (double) enemies.length));	// Wartezeit festlegen und random stellen (auf die Anzahl der Gegner bezogen)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }                
    }            


    /*Methode gibt zurück, ob eine Kollision des Gegners mit dem Spieler stattgefunden hat*/ 
    private boolean collisionCheckAll(final IGameObject obj) {
        boolean hit = false;
        for (final Enemy e : enemies) {
            if (e != null && CollisionDetection.collisionCheckSingle(e.getBorder(), obj.getBorder())) {
                hit = true;
                break;
            }
        }
        return hit;
    }
}
