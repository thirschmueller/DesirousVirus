package main2;

import behavior.EnemySpawner;
import behavior.MovementController;
import entities.Player;
import frames.MenuFrame;
import utils.BufferedImageUtils;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Game extends Canvas implements Runnable {
    public final String title = "Donkey Kong";

    private boolean running = false;
    private Thread thread;
    private Thread t1;
    private Thread t2;
    private Thread t3;
    private Thread t4;
    private Thread t5;

    private BufferedImage backgroundImg;

    private Player p;
    private EnemySpawner e1;
    private EnemySpawner e2;
    private EnemySpawner e3;
    private EnemySpawner e4;
    private EnemySpawner e5;

    public void init() {
        backgroundImg = BufferedImageUtils.loadImage("resources/pictures/veins.jpg");
        final BufferedImage playerImg = BufferedImageUtils.scaleImage(Objects.requireNonNull(BufferedImageUtils.loadImage("resources/pictures/virus.png")), 0.35);
        final BufferedImage enemyImg = BufferedImageUtils.scaleImage(Objects.requireNonNull(BufferedImageUtils.loadImage("resources/pictures/leukocyt.png")), 0.05);

        p = new Player(getScaledWidth(0.96), getScaledHeight(0.91), playerImg);
        e1 = new EnemySpawner(enemyImg, getScaledHeight(0.86), getScaledHeight(0.94), getWidth() + enemyImg.getWidth(), false, 10);
        e2 = new EnemySpawner(enemyImg, getScaledHeight(0.64), getScaledHeight(0.72), getWidth() + enemyImg.getWidth(), true, 15);
        e3 = new EnemySpawner(enemyImg, getScaledHeight(0.44), getScaledHeight(0.52), getWidth() + enemyImg.getWidth(), false, 20);
        e4 = new EnemySpawner(enemyImg, getScaledHeight(0.23), getScaledHeight(0.31), getWidth() + enemyImg.getWidth(), true, 15);
        e5 = new EnemySpawner(enemyImg, getScaledHeight(0.23), getScaledHeight(0.31), getWidth() + enemyImg.getWidth(), false, 15);

        t1 = new Thread(() -> e1.spawn());
        t2 = new Thread(() -> e2.spawn());
        t3 = new Thread(() -> e3.spawn());
        t4 = new Thread(() -> e4.spawn());
        t5 = new Thread(() -> e5.spawn());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        addKeyListener(new MovementController(p, getWidth() - playerImg.getWidth(), getHeight() - playerImg.getHeight()));
    }

    public synchronized void start() {
        if (running) {
            return;
        }

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        if (!running) {
            return;
        }

        running = false;
        try {
            final int time = 100;
            thread.join(time);
            t1.join(time);
            t2.join(time);
            t3.join(time);
            t4.join(time);
            t5.join(time);
        } catch (final InterruptedException e) {
            thread.interrupt();
            t1.interrupt();
            t2.interrupt();
            t3.interrupt();
            t4.interrupt();
            t5.interrupt();
            e.printStackTrace();
        }
        //System.exit(1);
    }

    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        final double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println(updates + " Ticks, Fps " + frames); //fps und ticks(wie oft geupdatet wird) anzeigen
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        p.tick();
        boolean hit = e1.tick(p) || e2.tick(p) || e3.tick(p) || e4.tick(p) || e5.tick(p);
        if (hit) {
            stop();
        }
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
        e1.render(g);
        e2.render(g);
        e3.render(g);
        e4.render(g);
        e5.render(g);

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
