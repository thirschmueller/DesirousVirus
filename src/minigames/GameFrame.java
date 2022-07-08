package minigames;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	
	GamePanel panel;
	
	GameFrame(){
		
		panel = new GamePanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
