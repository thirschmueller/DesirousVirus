package frames.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import frames.GameFrame;
import frames.MenuFrame;
import utils.AsyncExecutor;

public class PlayAction implements ActionListener {
	private final static GameFrame game = new GameFrame();
	private final static JFrame gFrame = new JFrame(GameFrame.title);
	private final MenuFrame menu;

	public PlayAction(final MenuFrame menu) {
		this.menu = menu;
	}

	public void actionPerformed(ActionEvent e) {
		menu.dispose();

		gFrame.getContentPane().add(game);
		gFrame.pack();
		gFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // makes the window full screen
		gFrame.requestFocus(); // key input are recognised by the frame without clicking once on it
		gFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gFrame.setLocationRelativeTo(null); // centers window on screen
		gFrame.setVisible(true); // shows the frame

		AsyncExecutor.addTask(game); // starts game loop in new thread
		while(AsyncExecutor.isRunning()) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println(Thread.activeCount());
		}
		new MenuFrame();

	}
}
