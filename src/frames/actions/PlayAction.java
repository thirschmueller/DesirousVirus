package frames.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import frames.MenuFrame;
import frames.Game;
import utils.AsyncExecutor;

public class PlayAction implements ActionListener {
	private final static Game game = new Game();
	private final static JFrame gameFrame = new JFrame(Game.title); // Titel mit übertragen
	private final MenuFrame menu;

	public PlayAction(final MenuFrame menu) { // Play button im Menuefenster
		this.menu = menu;
	}

	public void actionPerformed(ActionEvent e) { // wenn der Play button gedrueckt wird startet sich das Spiel
		menu.dispose();

		gameFrame.add(game);
		gameFrame.pack();
		gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // makes the window full screen
		gameFrame.requestFocus(); // key input are recognised by the frame without clicking once on it
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setLocationRelativeTo(null); // centers window on screen
		gameFrame.setVisible(true); // shows the frame

		AsyncExecutor.addTask(game); // startet den gameloop in einem neuen Thread
	}
}
