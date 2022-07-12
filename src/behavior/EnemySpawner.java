package behavior;

import entities.Enemy;
import entities.IGameObject;
import utils.RandomGen;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemySpawner implements Runnable {
    private Enemy[] enemies;
    private double minY, maxY, maxX;
    private boolean isLeft;
    private BufferedImage enemyImg;

    public EnemySpawner(final BufferedImage enemyImg, final double minY, final double maxY, final double maxX, final boolean isLeft, final int maxEnemies) {
        this.enemies = new Enemy[maxEnemies];
        this.minY = minY;
        this.maxY = maxY;
        this.maxX = maxX;
        this.isLeft = isLeft;
        this.enemyImg = enemyImg;
    }

    public boolean tick(final IGameObject obj) {
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

    public void render(Graphics g) {
        for (Enemy enemy : enemies) {
            if (enemy != null) {
                enemy.render(g);
            }
        }
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i] == null || enemies[i].getIsDead()) {
                    enemies[i] = new Enemy(enemyImg, RandomGen.randomBetween(minY, maxY), maxX, RandomGen.randomBetween(1, 4), isLeft);
                    try {
                        Thread.sleep((long) RandomGen.randomBetween(20000 / (double) enemies.length, 40000 / (double) enemies.length));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private boolean collisionCheckAll(final IGameObject obj) {
        boolean hit = false;
        for (final Enemy e : enemies) {
            if (e != null && collisionCheckSingle(e, obj)) {
                hit = true;
                break;
            }
        }
        return hit;
    }

    private boolean collisionCheckSingle(final IGameObject obj1, final IGameObject obj2) {
        // Location obj 1
        double centerX1 = obj1.getBorder().getCenterX();
        double centerY1 = obj1.getBorder().getCenterY();

        // Location obj 1
        double centerX2 = obj2.getBorder().getCenterX();
        double centerY2 = obj2.getBorder().getCenterY();

        // Calculate the distance between the center of obj1 and obj2
        double diffX = centerX1 - centerX2;
        double diffY = centerY1 - centerY2;

        double distance = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));

        // Compare with minimum distance
        double minDistance = obj1.getBorder().getWidth() / 2 + obj2.getBorder().getWidth() / 2;
        return distance <= minDistance;
    }
}
