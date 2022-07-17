package frames;

import entities.EnemySpawner;
import entities.EnemySpawnerDelegator;
import controllers.MovementController;
import entities.Heart;
import entities.Player;
import utils.BufferedImageUtils;
import entities.Highscore;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.net.URISyntaxException;
import java.util.Objects;

public class Game extends Canvas implements Runnable { // canvas = Zeichenklasse
	public static final String title = "Desirous Virus";
	private BufferedImage backgroundImg;

	private Player p;
	private final EnemySpawnerDelegator e = new EnemySpawnerDelegator();
	private Highscore h;
	private Heart heart;

	public void init() { // initialisiert entities

		backgroundImg = BufferedImageUtils.loadImage("resources/pictures/veins.jpg");
		final BufferedImage playerImg = Objects.requireNonNull(BufferedImageUtils.loadImage("resources/pictures/virus.png"));
		final BufferedImage enemyImg = Objects.requireNonNull(BufferedImageUtils.loadImage("resources/pictures/leukocyt.png"));

		final double playerScale = getHeight() / (double) 1370 * 0.35;
		final double enemyScale = getHeight() / (double) 1370 * 0.05;

		p = new Player(getScaledWidth(0.95), getScaledHeight(0.93), playerImg, getWidth(), getHeight(), playerScale);
		heart = new Heart(new Rectangle((int) (getWidth() * 0.43), (int) (getHeight() * 0.08),(int) (getWidth() * 0.14), (int) (getHeight() * 0.05)));
		e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.86), getScaledHeight(0.94),getWidth() + enemyImg.getWidth(), false, enemyScale, 10)); // spawner für die gegner mit random höhe(von, bis), und anzahl
		e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.64), getScaledHeight(0.72),getWidth() + enemyImg.getWidth(), true, enemyScale, 15)); // width wichtig für die erkennung wann sie aus der border kommen
		e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.44), getScaledHeight(0.52),getWidth() + enemyImg.getWidth(), false, enemyScale, 20)); // true und false für rechts oder links
		e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.23), getScaledHeight(0.31),getWidth() + enemyImg.getWidth(), true, enemyScale, 15));
		e.addSpawner(new EnemySpawner(enemyImg, getScaledHeight(0.23), getScaledHeight(0.31),getWidth() + enemyImg.getWidth(), false, enemyScale, 15));

		addKeyListener(new MovementController(p)); // adden von Movementcontroller

		try {
			h = new Highscore(getScaledWidth(0.82), getScaledHeight(0.07), getScaledWidth(0.01)); // 0.8 = 80Prozent der Höhe/breiten
		} catch (URISyntaxException e1) {

			e1.printStackTrace();
		}

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

	}

	private boolean tick() {
		p.tick(); // bei dem Player tick aufrufen
		h.tick();
		boolean hit = e.tick(p); // tick in enemy aufrufen (wenn er nicht tot ist soll er sich bewegen)
		if (hit) {
			restartGame();
		}
		boolean heartReached = heart.isReached(p);
		if (heartReached) {
			h.storeHighScore(); // checke ob man das Herz/Ziel getroffen hat 
			restartGame();
		}
		return !hit || !heartReached;	//wenn man das Herz erreicht oder getroffen wird startet das Spiel neu
	}
	
	/*Methode zum restarten nachdem man Verloren/Gewonnen hat*/
	private void restartGame() {
        System.exit(-1);    //schließt das spiel

	}
	
	/* Zeichnenklasse, die alle renderMethoden aufruft */
	private void render() { 
		final BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return; // nach return wird nichts ausgeführt --> zurückgehen zu der Methode, die render
			// aufgerufen hat
		}

		final Graphics g = bs.getDrawGraphics(); 
		g.drawImage(backgroundImg, 0, 0, getWidth(), getHeight(), this); // zweichnen des Hintergrunds

		p.render(g); // render aufrufen für den Spieler
		e.render(g);
		h.render(g);

		g.dispose(); // die Graphiken, die nicht mehr gebruacht werden werden gelöscht
		bs.show(); // jedes mal nach dem rendern löschen, da man diese jedes Frame zeichnet und sie sich ansonsten anhäufen würden
	}

	/*Skalierungen der Bilder */
	private int getScaledWidth(final double scale) {	
		return BufferedImageUtils.getScaled(getWidth(), scale);
	}

	private int getScaledHeight(final double scale) {
		return BufferedImageUtils.getScaled(getHeight(), scale);
	}
}
