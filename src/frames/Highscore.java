package frames;



import java.awt.Graphics;

import javax.swing.JFrame;




public class Highscore extends JFrame {
	
	//render und tick einfügen und alles hier rein schreiben (gesamte Speicher und load sachen)
	private double highScore;
	public Highscore(double highScore) {
		this.highScore = highScore;
		
		
	}
	
	public void tick() {
		
		highScore -= 0.2;
	}
	
	public void render(Graphics g) {
		g.drawString(String.valueOf((int)highScore), 200, 200);	//render in Highscore, was ich dann hier reinschreiben 
	}
}

// if(score > highScore) {
// highScore = score;
