package frames.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frames.MenuFrame;

public class OptionAction implements ActionListener {
	private final MenuFrame menu;

	public OptionAction(final MenuFrame menu) {		//Options button im Menuefenster
		this.menu = menu;
	}

	public void actionPerformed(ActionEvent e) {	//wenn der Button gedrueckt wurde soll das Menuefenster sich schließen 
		menu.dispose();
		//hier wuerde noch ein Option menue entstehen

	}
}

