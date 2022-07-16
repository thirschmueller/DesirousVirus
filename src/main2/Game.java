package main2;

import behavior.AsyncTask;
import entities.EnemySpawner;
import behavior.EnemySpawnerDelegator;
import behavior.MovementController;
import entities.Player;
import frames.Highscore;
import frames.MenuFrame;
import utils.BufferedImageUtils;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;
	public static final String title = "Donkey Kong";
    private static BufferedImage backgroundImg;

    private static Player p;
    private static EnemySpawnerDelegator e = new EnemySpawnerDelegator();
    private Highscore h;
   
    public void init() {
        backgroundImg = BufferedImageUtils.loadImage("resources/pictures/veins.jpg");
        final BufferedImage playerImg = Objects.requireNonNull(BufferedImageUtils.loadImage("resources/pictures/virus.png"));
        final BufferedImage enemyImg = Objects.requireNonNull(BufferedImageUtils.loadImage("resources/pictures/leukocyt.png"));

        final double playerScale = (double) (getHeight() / 1370) * 0.35;
        final double enemyScale = (double) (getHeight() / 1370) * 0.05;

        p = new Player(getScaledWidth(0.95), getScaledHeight(0.93), playerImg, getWidth(), getHeight(), playerScale);
        e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.86), getScaledHeight(0.94), getWidth() + enemyImg.getWidth(), false,enemyScale, 10));
        e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.64), getScaledHeight(0.72), getWidth() + enemyImg.getWidth(), true,enemyScale, 15));
        e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.44), getScaledHeight(0.52), getWidth() + enemyImg.getWidth(), false,enemyScale, 20));
        e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.23), getScaledHeight(0.31), getWidth() + enemyImg.getWidth(), true, enemyScale,15));
        e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.23), getScaledHeight(0.31), getWidth() + enemyImg.getWidth(), false,enemyScale, 15));

        addKeyListener(new MovementController(p, getWidth() - playerImg.getWidth(), getHeight() - playerImg.getHeight()));
    }
	

    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60;
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
        //init2();
 //       new Highscore(highscore);
    }

    private boolean tick() {
        if (p != null) {
            p.tick();
            boolean hit = e.tick(p);
            if (hit) {
                System.exit(-1);
                MenuFrame.ButtonAction.restart();
                AsyncTask.stop();
            }
            return !hit;
        }
        return false;
    }

    private void render() {
        final BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        final Graphics g = bs.getDrawGraphics();
        g.drawImage(backgroundImg, 0, 0, getWidth(), getHeight(), this); // draws the background image
        if (p != null) {
            p.render(g);
        }
        if (e != null) {
            e.render(g);
        }

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
