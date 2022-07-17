package frames.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import frames.GameFrame;
import frames.MenuFrame;
import utils.AsyncExecutor;

public class PlayAction implements ActionListener {
	private final static GameFrame game = new GameFrame();	
	private final static JFrame gFrame = new JFrame(GameFrame.title);	//Titel mit übertragen
	private final MenuFrame menu;

	public PlayAction(final MenuFrame menu) {	//Play button im Menuefenster
		this.menu = menu;
	}

	public void actionPerformed(ActionEvent e) {	//wenn der Play button gedrueckt wird startet sich das Spiel
		menu.dispose();

		gFrame.getContentPane().add(game);	//die Methoden von Game werden hinzugefügt 
		gFrame.pack();
		gFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // sorgt fuer fullscreen
		gFrame.requestFocus(); //man muss nicht in das Fenster clicken, sodass die Tasten erkannt werden
		gFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gFrame.setLocationRelativeTo(null); //setzt das frame in die Mitte des Bildschirms 
		gFrame.setVisible(true); 

		AsyncExecutor.addTask(game); //startet den gameloop in einem neuen Thread
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
