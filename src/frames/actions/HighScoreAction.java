package frames.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frames.HighScoreFrame;
import frames.MenuFrame;

public class HighScoreAction implements ActionListener {

	private final MenuFrame menu;

	public HighScoreAction(final MenuFrame menu) {
		this.menu = menu;
	}

	public void actionPerformed(ActionEvent e) {
		menu.dispose();
		new HighScoreFrame();

	}
}
