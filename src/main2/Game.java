package main2;

import behavior.AsyncTask;
import behavior.EnemySpawner;
import behavior.EnemySpawnerDelegator;
import behavior.MovementController;
import entities.Player;
import frames.MenuFrame;
import utils.BufferedImageUtils;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Game extends Canvas implements Runnable {
    public static final String title = "Donkey Kong";
    private static BufferedImage backgroundImg;

    private static Player p;
    private static final EnemySpawnerDelegator e = new EnemySpawnerDelegator();

    public void init() {
        backgroundImg = BufferedImageUtils.loadImage("resources/pictures/veins.jpg");
        final BufferedImage playerImg = BufferedImageUtils.scaleImage(Objects.requireNonNull(BufferedImageUtils.loadImage("resources/pictures/virus.png")), 0.35);
        final BufferedImage enemyImg = BufferedImageUtils.scaleImage(Objects.requireNonNull(BufferedImageUtils.loadImage("resources/pictures/leukocyt.png")), 0.05);

        p = new Player(getScaledWidth(0.95), getScaledHeight(0.93), playerImg, getWidth(), getHeight());
        e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.86), getScaledHeight(0.94), getWidth() + enemyImg.getWidth(), false, 10));
        e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.64), getScaledHeight(0.72), getWidth() + enemyImg.getWidth(), true, 15));
        e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.44), getScaledHeight(0.52), getWidth() + enemyImg.getWidth(), false, 20));
        e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.23), getScaledHeight(0.31), getWidth() + enemyImg.getWidth(), true, 15));
        e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.23), getScaledHeight(0.31), getWidth() + enemyImg.getWidth(), false, 15));

        addKeyListener(new MovementController(p, getWidth() - playerImg.getWidth(), getHeight() - playerImg.getHeight()));
    }

    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        final double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        boolean isRunning = false;

        while (Thread.currentThread().isAlive()) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                isRunning = tick();
                delta--;
            }
            if (isRunning) {
                render();
            }
        }
    }

    private boolean tick() {
        p.tick();
        boolean hit = e.tick(p);
        if (hit) {
            System.exit(-1);
            MenuFrame.ButtonAction.restart();
            AsyncTask.stop();
        }
        return !hit;
    }

    private void render() {
        final BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        final Graphics g = bs.getDrawGraphics();
        g.drawImage(backgroundImg, 0, 0, getWidth(), getHeight(), this); // draws the background image
        p.render(g);
        e.render(g);

        g.dispose();
        bs.show();
    }

    private int getScaledWidth(final double scale) {
        return BufferedImageUtils.getScaled(getWidth(), scale);
    }

    private int getScaledHeight(final double scale) {
        return BufferedImageUtils.getScaled(getHeight(), scale);
    }
}
