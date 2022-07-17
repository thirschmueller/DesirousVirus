package frames;

import javax.swing.JFrame;

import utils.Highscore;
import javax.swing.JTabbedPane;

public class HighScoreFrame extends JFrame{
	private Highscore h;
	
	public HighScoreFrame() {
	
		
		pack();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		requestFocus(); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Highscore");
		setLocationRelativeTo(null); 
		setVisible(true); 
		
		//Hier wuerde eine Highscore Tabelle entstehen
	}
}
