package frames;

import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import javax.swing.JFrame;

public class Highscore extends JFrame {

	// render und tick einfügen und alles hier rein schreiben (gesamte Speicher und
	// load sachen)

	private int score = 1000; // momentiger score
	private double highScore = 1000;
	private String saveDataPath;
	private String fileName = "SaveData";
	private Font scoreFont;

	public Highscore(double highScore) {
		this.highScore = highScore;
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

	public void tick() {

		highScore -= 0.2;
	}
	

	public void render(Graphics g) {
		g.drawString(String.valueOf((int) highScore), 200, 200); // render in Highscore, was ich dann hier reinschreiben
	}
	
	
	   
    private void update() {
    	if(score > highScore) {	 //wenn der score größer als der Highscore ist, dann ist der score der neue Highscore und wird so auch immer geupdated
    		highScore = score; 
    		setHighscore();
    	}
    }
    
    

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getHighScore() {
		return (int) highScore;
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

}

// if(score > highScore) {
// highScore = score;
