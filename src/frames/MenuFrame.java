package frames;

import javax.swing.*;

import frames.actions.ExitAction;
import frames.actions.HighScoreAction;
import frames.actions.OptionAction;
import frames.actions.PlayAction;

import java.awt.*;

public class MenuFrame extends JFrame {

	private static final JPanel panel = new JPanel();
	private static final JButton buttonPlay = new JButton("Play");
	private static final JButton buttonHighScore = new JButton("Highscore");
	private static final JButton buttonOption = new JButton("Options");
	private static final JButton buttonExit = new JButton("Exit");
	
	/* Konstruktor für die GUI des Menüs. 
	 * Hier werden Position, Größe, Abstände, Schrift und Farbe der 4 Buttons festgelegt. 
	 * Eine Aktion wird soll beim Klicken auf einen Knopf ausgeführt werden*/
	public MenuFrame() {
        
		buttonPlay.setAlignmentX(Component.CENTER_ALIGNMENT); // zentriert ausgelegt
		buttonPlay.setBounds(100, 50, 100, 30); // x-Koordinate, y-Koordinate, Breite, Höhe

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS)); // vertikal ausgelegt
		
        panel.add(Box.createVerticalStrut(40)); // Abstand zum nächsten Button
        panel.add(buttonPlay); // Hinzufügen des Play-Buttons
	
		panel.add(Box.createVerticalStrut(40));
		buttonHighScore.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(buttonHighScore);

		panel.add(Box.createVerticalStrut(40));
		buttonOption.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(buttonOption);

		panel.add(Box.createVerticalStrut(40));
		buttonExit.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(buttonExit);

		buttonPlay.setPreferredSize(new Dimension(300, 120));

		buttonPlay.setFont(new Font("Cooper Black", Font.BOLD, 50)); // Schriftart, Fettgedruckt und Größe
		buttonPlay.setForeground(Color.LIGHT_GRAY); // Schrift Farbe vom Button
		buttonPlay.setBackground(Color.DARK_GRAY); // Hintegrundfarbe vom Button
		buttonPlay.setFocusable(false); // keine Border mehr um die Schrift

		buttonHighScore.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		buttonHighScore.setForeground(Color.GRAY);
		buttonHighScore.setBackground(Color.DARK_GRAY);
		buttonHighScore.setFocusable(false);

		buttonOption.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		buttonOption.setForeground(Color.GRAY);
		buttonOption.setBackground(Color.DARK_GRAY);
		buttonOption.setFocusable(false);

		buttonExit.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		buttonExit.setForeground(Color.GRAY);
		buttonExit.setBackground(Color.DARK_GRAY);
		buttonExit.setFocusable(false);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(600, 250);
		setTitle("Menu");
		pack();
		setVisible(true);

		buttonPlay.addActionListener(new PlayAction(this));		//PlayAction zum Playbutton hinzufuegen
		buttonHighScore.addActionListener(new HighScoreAction(this));
		buttonOption.addActionListener(new OptionAction(this));
		buttonExit.addActionListener(new ExitAction(this));
	}

}
