package main2;

import behavior.EnemySpawner;import behavior.MovementController;
import entities.Player;
import frames.Highscore;
import utils.BufferedImageUtils;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
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
    
    private Highscore h;     
    
    private int score = 1000; // momentiger score
	private int highScore = 1000;
	private String saveDataPath;
	private String fileName = "SaveData";
	private Font scoreFont;
	

	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public Font getScoreFont() {
		return scoreFont;
	}

	public void setScoreFont(Font scoreFont) {
		this.scoreFont = scoreFont;
	}

	public Game() {
		try {
			saveDataPath = Highscore.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath(); // speichert die daten von Highscore bei der Jar von dem Spiel
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
		loadHighscore();
	}

	private void createSaveData() {
		try {
			File file = new File(saveDataPath, fileName);

			FileWriter output = new FileWriter(file); // neues File erstellen
			BufferedWriter writer = new BufferedWriter(output);
			writer.write("" + 1000); // Highscore auf 0 setzen
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private void loadHighscore() {
		try {
			File f = new File(saveDataPath, fileName);
			if (!f.isFile()) { // wenn kein File vorhanden ist, wird ein neues erstellt
				createSaveData();
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			highScore = Integer.parseInt(reader.readLine());
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void setHighscore() {
		FileWriter output = null;

		try {
			File f = new File(saveDataPath, fileName);
			output = new FileWriter(f);
			BufferedWriter writer = new BufferedWriter(output);

			
			writer.write("" + highScore);

			
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
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
        
        h = new Highscore(highScore);
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
            thread.join();
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
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
        score =  (int) ns;	//timer hängt mit score zusammen
        
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
                System.out.println(updates + " Ticks, Fps " + frames); //fps und ticks(wie oft geupdatet wird) anzeigen
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
        h.tick();	//tick für Highscore
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
        h.render(g);	//render für Highscore
        
        g.dispose();
        bs.show();
    }

    
    
    private void update() {
    	if(score > highScore) {	 //wenn der score größer als der Highscore ist, dann ist der score der neue Highscore und wird so auch immer geupdated
    		highScore = score; 
    		setHighscore();
    	}
    }

    private int getScaledWidth(final double scale) {
        return (int) Math.floor(getWidth() * scale);
    }

    private int getScaledHeight(final double scale) {
        return (int) Math.floor(getHeight() * scale);
    }
}
