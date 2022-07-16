package main2;

import behavior.AsyncTask;
import entities.EnemySpawner;
import behavior.EnemySpawnerDelegator;
import behavior.MovementController;
import entities.Player;
import frames.MenuFrame;
import utils.BufferedImageUtils;
import utils.Highscore;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.net.URISyntaxException;
import java.util.Objects;

public class Game extends Canvas implements Runnable { // canvas = ZeichneKlasse
	private static final long serialVersionUID = 1L;
	public static final String title = "Desirous Virus";
	private static BufferedImage backgroundImg;

	private static Player p;
	private static EnemySpawnerDelegator e = new EnemySpawnerDelegator();
	private Highscore h;

	public void init() { // initialisiert entities

		backgroundImg = BufferedImageUtils.loadImage("resources/pictures/veins.jpg");
		final BufferedImage playerImg = Objects
				.requireNonNull(BufferedImageUtils.loadImage("resources/pictures/virus.png"));
		final BufferedImage enemyImg = Objects
				.requireNonNull(BufferedImageUtils.loadImage("resources/pictures/leukocyt.png"));

		final double playerScale = getHeight() / (double) 1370 * 0.35;
		final double enemyScale = getHeight() / (double) 1370 * 0.05;

		p = new Player(getScaledWidth(0.95), getScaledHeight(0.93), playerImg, getWidth(), getHeight(), playerScale);
		e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.86), getScaledHeight(0.94), getWidth() + enemyImg.getWidth(), false, enemyScale, 10)); // spawner für die gegner mit random
																			// höhe(von, bis), und anzahl
		e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.64), getScaledHeight(0.72), getWidth() + enemyImg.getWidth(), true, enemyScale, 15)); // width wichtig für die erkennung wann sie
																			// aus der b
		e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.44), getScaledHeight(0.52), getWidth() + enemyImg.getWidth(), false, enemyScale, 20)); // true und false für rechts oder links
		e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.23), getScaledHeight(0.31), getWidth() + enemyImg.getWidth(), true, enemyScale, 15));
		e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.23), getScaledHeight(0.31), getWidth() + enemyImg.getWidth(), false, enemyScale, 15));

		addKeyListener(
				new MovementController(p, getWidth() - playerImg.getWidth(), getHeight() - playerImg.getHeight())); // adden
																													// von
																													// Movementcontroller
		
		try {
			h = new Highscore(getScaledWidth(0.82), getScaledHeight(0.07)); // 0.8 = 80Prozent der Höhe/breiten 
		} catch (URISyntaxException e1) {
	
			e1.printStackTrace();
		}
		System.out.println("" + h.loadHighScore());
	}

	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();

		final double amountOfTicks = 60.0; // 60 ticks(updates) die Sekunde

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

	private boolean tick() {
		p.tick(); // bei dem Player tick aufrufen
		h.tick();
		boolean hit = e.tick(p); // tick in enemy aufrufen (wenn er nicht tot ist soll er sich bewegen)
		if (hit) {
			h.storeHighScore();
			System.exit(-1);	//schließt das spiel
			MenuFrame.ButtonAction.restart();
			AsyncTask.stop();		
			//checke ob man den win gehittet hat (h.StoreHighscore)
		}
		
		return !hit;

	}

	private void render() { // neu rendern(zeichnen) von dem Bild
		final BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return; // nach return wird nichts ausgeführt --> zurückgehen zu der Methode, die render
					// aufgerufen hat
		}

		final Graphics g = bs.getDrawGraphics(); // graphics ist das gesamte Bild
		g.drawImage(backgroundImg, 0, 0, getWidth(), getHeight(), this); // draws the background image

		p.render(g);	// render aufrunfe(ob links oder rechts schauen), und dann dort hinzeichnen von
		// den Spieler
		e.render(g);
		h.render(g);

		g.dispose(); // das was man nicht mehr gebruacht wird wird gelöscht
		bs.show(); // löschen, da man diese jedes Frame zeichnet und sie sich ansonsten anhäufen
					// würden
	}

	private int getScaledWidth(final double scale) {
		return BufferedImageUtils.getScaled(getWidth(), scale);
	}

	private int getScaledHeight(final double scale) {
		return BufferedImageUtils.getScaled(getHeight(), scale);
	}
}
