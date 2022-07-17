package frames.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frames.HighScoreFrame;
import frames.MenuFrame;

public class HighScoreAction implements ActionListener {

	private final MenuFrame menu;

	public HighScoreAction(final MenuFrame menu) {	//Highscore button im Menuefenster
		this.menu = menu;
	}

	public void actionPerformed(ActionEvent e) {	//wenn der Button gedrueckt wurde soll das Menuefenster sich schließen 
		menu.dispose();
		new HighScoreFrame();	//öffnen von dem Highscoreframe

	}
}
