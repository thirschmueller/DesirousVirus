package src.behavior;

import src.entities.Enemy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class EnemySpawner {
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

    public void tick() {
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] != null) {
                enemies[i].tick();
            }
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] != null) {
                enemies[i].render(g);
            }
        }
    }

    public void spawn() {
        while(true) {
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i] == null || enemies[i].getIsDead()) {
                    enemies[i] = new Enemy(enemyImg, randomBetween(minY, maxY), maxX, randomBetween(1, 4), isLeft);
                    try {
                        Thread.sleep((long) randomBetween(2000, 4000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private double randomBetween(final double min, final double max) {
        final Random  r = new Random();
        return r.nextDouble() * (max - min + 1.0) + min;
    }
}
