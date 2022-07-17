package entities;

import utils.RandomGen;
import utils.CollisionDetection;

import java.awt.*;
import java.awt.image.BufferedImage;


public class EnemySpawner implements Runnable {
    private final Enemy[] enemies;

    private final double minY, maxY, maxX, enemyScale;
    private final boolean isLeft;	//Blickrichtung
    private final BufferedImage enemyImg;
    private boolean isRunning = true;

    public EnemySpawner(final BufferedImage enemyImg, final double minY, final double maxY, final double maxX, final boolean isLeft, final double enemyScale, final int maxEnemies) {	//wird in Game verwendet
        this.enemies = new Enemy[maxEnemies];	//maximale gegner anzahl wird noch festgelegt (anzahl der positionen im Array)


        this.minY = minY;
        this.maxY = maxY;
        this.maxX = maxX;
        this.enemyScale = enemyScale;
        this.isLeft = isLeft;
        this.enemyImg = enemyImg;
    }

    public boolean tick(final IGameObject obj) {	//
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

    public void render(Graphics g) {
        for (Enemy enemy : enemies) {
            if (enemy != null) {
                enemy.render(g);
            }
        }
    }

    @Override
    public void run() {
        while (isRunning) {	//wenn es nicht unterbrochen wird durchführen
            for (int i = 0; i < enemies.length; i++) {	//für jeden leukocyt ausführen
                if (enemies[i] == null || enemies[i].getIsDead()) {	//wenn es noch nicht die gewünschte Anzahl der gegner gibt 
                    enemies[i] = new Enemy(enemyImg, RandomGen.randomBetween(minY, maxY), maxX, RandomGen.randomBetween(1, 4), enemyScale, isLeft);	//wenn er am ende des Bildschirms ist wird er als tot angesehen --> neu spawnen

                    try {
                        Thread.sleep((long) RandomGen.randomBetween(20000 / (double) enemies.length, 40000 / (double) enemies.length));	//wartezeit festlegen und random stellen(auf die anzahl der gegner bezogen)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }           

    public void stop() {
    	this.isRunning = false;
    }
    
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
