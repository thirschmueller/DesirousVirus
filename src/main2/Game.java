package main2;

import behavior.AsyncTask;
import entities.EnemySpawner;
import behavior.EnemySpawnerDelegator;
import behavior.MovementController;
import entities.Heart;
import entities.Player;
import frames.MenuFrame;
import utils.BufferedImageUtils;
import utils.Highscore;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.net.URISyntaxException;
import java.util.Objects;

public class Game extends Canvas implements Runnable { // Canvas = Zeichenklasse
    private static final long serialVersionUID = 1L;
    public static final String title = "Desirous Virus";
    private static BufferedImage backgroundImg;

    private static Player p;
    private static EnemySpawnerDelegator e = new EnemySpawnerDelegator();
    private Highscore h;
    private Heart heart;

    public void init() { // initialisiert entities

        backgroundImg = BufferedImageUtils.loadImage("resources/pictures/veins.jpg");
        final BufferedImage playerImg = Objects
                .requireNonNull(BufferedImageUtils.loadImage("resources/pictures/virus.png"));
        final BufferedImage enemyImg = Objects
                .requireNonNull(BufferedImageUtils.loadImage("resources/pictures/leukocyt.png"));

        final double playerScale = getHeight() / (double) 1370 * 0.35;
        final double enemyScale = getHeight() / (double) 1370 * 0.05;

        p = new Player(getScaledWidth(0.95), getScaledHeight(0.93), playerImg, getWidth(), getHeight(), playerScale);
        heart = new Heart(new Rectangle((int) (getWidth() * 0.43), (int) (getHeight() * 0.08), (int) (getWidth() * 0.2), (int) (getHeight() * 0.1)));
        e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.86), getScaledHeight(0.94), getWidth() + enemyImg.getWidth(), false, enemyScale, 10)); 	// spawner für die Gegner mit random Hoehe (von, bis), und Anzahl
        e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.64), getScaledHeight(0.72), getWidth() + enemyImg.getWidth(), true, enemyScale, 15)); 	// width wichtig für die Erkennung, wann sie aus dem Bild verschwinden
        e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.44), getScaledHeight(0.52), getWidth() + enemyImg.getWidth(), false, enemyScale, 20)); 	// "true" und "false" für nach rechts blickend oder nach links blickend
        e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.23), getScaledHeight(0.31), getWidth() + enemyImg.getWidth(), true, enemyScale, 15));
        e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.23), getScaledHeight(0.31), getWidth() + enemyImg.getWidth(), false, enemyScale, 15));

        addKeyListener(
                new MovementController(p, getWidth() - playerImg.getWidth(), getHeight() - playerImg.getHeight())); // adden von MovementController

        try {
            h = new Highscore(getScaledWidth(0.82), getScaledHeight(0.07)); // 0.82 = 82 Prozent der Höhe/ Breite
        } catch (URISyntaxException e1) {

            e1.printStackTrace();
        }
        //	System.out.println("" + h.loadHighScore());
    }

    @Override
    /*Methode zum Updaten der Frames pro Sekunde*/
    public void run() {
        init();
        long lastTime = System.nanoTime();

        final double amountOfTicks = 60.0; // 60 ticks (updates) die Sekunde

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
            if (isRunning) { // render so oft es geht
                render();
            }
        }

        // init2();
        // new Highscore(highscore);
    }

    /*Methode, die das Spielende definiert (entweder verloren durch Kollision mit Gegner oder Sieg bei erreichen des Herzens)*/
    private boolean tick() {
        p.tick(); 					// bei dem Player tick aufrufen
        h.tick();
        boolean hit = e.tick(p); 	// tick in enemy aufrufen (wenn er nicht tot ist, soll er sich bewegen)
        if (hit) {
            restartGame();
        }
        boolean heartReached = heart.isReached(p);
        if (heartReached) {
            h.storeHighScore(); 	//checke ob man den win gehittet hat (h.StoreHighscore)
            restartGame();
        }
        return !hit || !heartReached;
    }

    /*Methode schließt das Spiel und startet es neu*/
    private void restartGame() {
        System.exit(-1);    // schließt das Spiel
        //MenuFrame.ButtonAction.restart();
        //AsyncTask.stop();
    }

    /* Methode fuers neu Rendern (Zeichnen) von dem Bild*/
    private void render() { 
        final BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return; // nach return wird nichts ausgefuehrt --> Zurückgehen zu der Methode, die render aufgerufen hat
        }

        final Graphics g = bs.getDrawGraphics(); 							// Graphics ist das gesamte Bild
        g.drawImage(backgroundImg, 0, 0, getWidth(), getHeight(), this); 	// zeichnet Hintergrundbild

        p.render(g);    // render aufrufen (ob nach links oder rechts schauen) und dann dort Hinzeichnen von dem Spieler
        e.render(g);
        h.render(g);

        g.dispose(); // das was man nicht mehr gebraucht wird, wird geloescht
        bs.show(); // loeschen, da man diese jedes Frame zeichnet und sie sich ansonsten anhaeufen wuerden
    }

    /*Methode fuer skalierte Breite*/
    private int getScaledWidth(final double scale) {
        return BufferedImageUtils.getScaled(getWidth(), scale);
    }

    /*Methode fuer skalierte Hoehe*/
    private int getScaledHeight(final double scale) {
        return BufferedImageUtils.getScaled(getHeight(), scale);
    }
}
