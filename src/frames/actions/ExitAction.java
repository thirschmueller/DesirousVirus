package frames.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frames.MenuFrame;

public class ExitAction implements ActionListener {
	private final MenuFrame menu;

	public ExitAction(final MenuFrame menu) {
		this.menu = menu;
	}

	public void actionPerformed(ActionEvent e) {
		menu.dispose();
		System.exit(0); //schließt das Programm komplett 

	}
}
