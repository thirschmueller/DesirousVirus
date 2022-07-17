package utils;

import java.awt.*;
import java.net.URISyntaxException;

public class Highscore {
	private double highScore = 1000; // setzt Score auf 1000
	private final DataStorage storage;
	private final int x, y;
	
	/* Methode speichert Highscore*/
	public Highscore(final int x, final int y) throws URISyntaxException {
		this.x = x;
		this.y = y;
		final String saveDataPath = Highscore.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
		storage = new DataStorage(saveDataPath, "highscore"); // speichert die Daten von Highscore bei der Jar von dem
																// Spiel);
	}

	/* Methode lässt Highscore pro tick um angegebenen Wert abnehmen*/
	public void tick() {
		highScore -= 0.1;
	}

	/* Methode rendert Highscore*/
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.setFont(new Font("Goudy Stout", Font.PLAIN, 35));
		g2.setColor(Color.red);
		g.drawString("Score: " + (int) highScore, x, y); // render in Highscore, was ich dann hier reinschreiben
	}

	/* Methode definiert neuen Highscore (nur neuer Highscore, wenn höher als gespeicherter alter Highscore --> dann aktuellen Score als neuen Highscore gespeichern */
	public void storeHighScore() {
		if (loadHighScore() < highScore) {
			storage.set(String.valueOf((int) highScore));
		}

	}

	/* Methode zum gespeicherten Highscore Laden*/
	public int loadHighScore() {
		return Integer.parseInt((String) storage.load());
	}
	
	//aufrufen mit loadHighscore
	//am besten dahin verlinke (Highscore GUI)

}