package frames;

import javax.swing.JFrame;

public class HighScoreFrame extends JFrame {

	public HighScoreFrame() {

		pack();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		requestFocus();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Highscore");
		setLocationRelativeTo(null);
		setVisible(true);

		// Hier wuerde eine Highscore Tabelle entstehen
	}
}
