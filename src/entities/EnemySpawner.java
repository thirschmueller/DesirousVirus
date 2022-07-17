package entities;

import utils.RandomGen;
import utils.CollisionDetection;

import java.awt.*;
import java.awt.image.BufferedImage;


public class EnemySpawner implements Runnable {
    private Enemy[] enemies;

    private double minY, maxY, maxX, enemyScale;
    private boolean isLeft;	//Blickrichtung
    private BufferedImage enemyImg;

    public EnemySpawner(final BufferedImage enemyImg, final double minY, final double maxY, final double maxX, final boolean isLeft, final double enemyScale, final int maxEnemies) {	//wird in Game verwendet
        this.enemies = new Enemy[maxEnemies];	//maximale Gegneranzahl wird noch festgelegt (Anzahl der Positionen im Array)


        this.minY = minY;
        this.maxY = maxY;
        this.maxX = maxX;
        this.enemyScale = enemyScale;
        this.isLeft = isLeft;
        this.enemyImg = enemyImg;
    }

    /*Methode gibt an, dass neuer Enemy spawnen soll, wenn er aus Bild verschwindet*/
    public boolean tick(final IGameObject obj) {	//
        if (collisionCheckAll(obj)) {
            System.out.println("Collision detected");
            return true;
        }
        for (Enemy enemy : enemies) {
            if (enemy != null) {
                enemy.tick();
            }
        }
        return false;
    }

    /*Methode rendert neu gespawnten Enemy*/
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

        while (!Thread.currentThread().isInterrupted()) {			// wenn es nicht unterbrochen wird --> durchfuehren
            for (int i = 0; i < enemies.length; i++) {				// fuer jeden Leukocyt ausfuehren
                if (enemies[i] == null || enemies[i].getIsDead()) {	// wenn es noch nicht die gewuenschte Anzahl der Gegner gibt 
                    enemies[i] = new Enemy(enemyImg, RandomGen.randomBetween(minY, maxY), maxX, RandomGen.randomBetween(1, 4), enemyScale, isLeft);	// wenn er am Ende des Bildschirms ist, wird er als tot angesehen --> neu spawnen

                    try {
                        Thread.sleep((long) RandomGen.randomBetween(20000 / (double) enemies.length, 40000 / (double) enemies.length));	// Wartezeit festlegen und random stellen (auf die Anzahl der Gegner bezogen)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
                
    }           
        
    
    /*Methode gibt zurück, ob eine Kollision des Gegners mit dem Spielfeldrand stattgefunden hat*/ 
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
