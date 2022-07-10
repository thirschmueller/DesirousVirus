package src;

import src.behavior.EnemySpawner;
import src.behavior.MovementController;
import src.entities.Player;
import src.utils.BufferedImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Game extends Canvas implements Runnable {
    public final String title = "Donkey Kong";

    private boolean running = false;
    private Thread thread;

    private BufferedImage backgroundImg;

    private Player p;
    private EnemySpawner e1;
    private EnemySpawner e2;
    private EnemySpawner e3;
    private EnemySpawner e4;

    public void init() {
        backgroundImg = BufferedImageUtils.loadImage("resources/pictures/veins.jpg");
        final BufferedImage playerImg = BufferedImageUtils.scaleImage(Objects.requireNonNull(BufferedImageUtils.loadImage("resources/pictures/virus.png")), 0.5);
        final BufferedImage enemyImg = BufferedImageUtils.scaleImage(Objects.requireNonNull(BufferedImageUtils.loadImage("resources/pictures/leukocyt.png")), 0.05);

        p = new Player(getScaledWidth(0.9), getScaledHeight(0.91), playerImg);
        e1 = new EnemySpawner(enemyImg, getScaledHeight(0.86), getScaledHeight(0.94), getWidth() + enemyImg.getWidth(), false, 10);
        e2 = new EnemySpawner(enemyImg, getScaledHeight(0.64), getScaledHeight(0.72), getWidth() + enemyImg.getWidth(), true, 10);
        e3 = new EnemySpawner(enemyImg, getScaledHeight(0.44), getScaledHeight(0.52), getWidth() + enemyImg.getWidth(), false, 10);
        e4 = new EnemySpawner(enemyImg, getScaledHeight(0.23), getScaledHeight(0.31), getWidth() + enemyImg.getWidth(), true, 10);

        Thread t1 = new Thread(() -> e1.spawn());
        Thread t2 = new Thread(() -> e2.spawn());
        Thread t3 = new Thread(() -> e3.spawn());
        Thread t4 = new Thread(() -> e4.spawn());
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        addKeyListener(new MovementController(p, getWidth() - playerImg.getWidth(), getHeight() - playerImg.getHeight()));
    }

    private synchronized void start() {
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
            thread.join();
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    public static void main(String[] args) {
        final Game game = new Game();

        final JFrame frame = new JFrame(game.title);
        frame.add(game);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // makes the window full screen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // centers window on screen
        frame.setVisible(true); // shows the frame

        game.start(); // starts a thread
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
                System.out.println(updates + " Ticks, Fps " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        p.tick();
        e1.tick();
        e2.tick();
        e3.tick();
        e4.tick();
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

        g.dispose();
        bs.show();
    }

    private int getScaledWidth(final double scale) {
        return (int) Math.floor(getWidth() * scale);
    }

    private int getScaledHeight(final double scale) {
        return (int) Math.floor(getHeight() * scale);
    }
}
