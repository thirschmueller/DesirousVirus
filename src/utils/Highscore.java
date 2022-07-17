package utils;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Highscore {

	public static final String title = "Highscore";
	private double highScore = 1000;
	private DataStorage storage;
	private int x, y;
	
	public Highscore(final int x, final int y) throws URISyntaxException {
		this.x = x;
		this.y = y;
		final String saveDataPath = Highscore.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
		storage = new DataStorage(saveDataPath, "highscore"); // speichert die daten von Highscore bei der Jar von dem
																// Spiel);
	}

	public void tick() {
		highScore -= 0.1;
	}

	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.setFont(new Font("Goudy Stout", Font.PLAIN, 35));
		g2.setColor(Color.red);
		g.drawString("Score: " + String.valueOf((int) highScore), x, y); // render in Highscore, was ich dann hier reinschreiben
	}

	public void storeHighScore() {
		if (loadHighScore() < highScore) {
			storage.set(String.valueOf((int) highScore));
		}

	}

	public int loadHighScore() {
		return Integer.parseInt((String) storage.load());
	}
	
	//aufrufen mit loadHighscore
	//am besten dahin verlinke (Highscore GUI)

}