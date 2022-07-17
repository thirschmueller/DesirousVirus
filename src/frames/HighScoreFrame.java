package frames;

import javax.swing.JFrame;

import utils.Highscore;
import javax.swing.JTabbedPane;

public class HighScoreFrame extends JFrame{
	private Highscore h;
	
	public HighScoreFrame() {
	//	h.loadHighScore();
		
		pack();
		setExtendedState(JFrame.MAXIMIZED_BOTH); // makes the window full screen
		requestFocus(); // key input are recognised by the frame without clicking once on it
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Highscore");
		setLocationRelativeTo(null); // centers window on screen
		setVisible(true); // shows the frame
	}
}
