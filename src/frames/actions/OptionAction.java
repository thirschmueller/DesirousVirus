package frames.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frames.MenuFrame;

public class OptionAction implements ActionListener {
	private final MenuFrame menu;

	public OptionAction(final MenuFrame menu) {
		this.menu = menu;
	}

	public void actionPerformed(ActionEvent e) {
		menu.dispose();
		

	}
}

