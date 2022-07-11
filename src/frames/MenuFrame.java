package frames;

import javax.swing.*;

import Main2.Game;
import controllers.MovementController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame implements ActionListener, Frame {

	private static final JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Play");
	JButton button2 = new JButton("Highscores");
	JButton button3 = new JButton("Options");
	JButton button4 = new JButton("Exit");

	
	public MenuFrame() {
		final JButton button = new JButton("Start Game");
		button.addActionListener(this); // this wegen in dieser Klasse
		button1.setBounds(100, 50, 100, 30);

		final JPanel panel = new JPanel();
//		panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS)); // Vertikal ausgelegt

		panel.add(button1);
		panel.add(Box.createRigidArea(new Dimension(150, 40))); // erstellt abstand (Horizontal, Vertikal)

		panel.add(button2);
		panel.add(Box.createRigidArea(new Dimension(150, 40)));
		button3.setAlignmentY(Component.TOP_ALIGNMENT);

		panel.add(button3);
		Component rigidArea = Box.createRigidArea(new Dimension(150, 40));
		panel.add(rigidArea);

		panel.add(button4);

//		button1.set

		button1.setPreferredSize(new Dimension(300, 200));

		button1.setFont(new Font("Cooper Black", Font.BOLD, 50)); // Schriftart, Fettgedruckt und Größe
		button1.setForeground(Color.LIGHT_GRAY); // Schrift Farbe vom Button
		button1.setBackground(Color.DARK_GRAY); // Hintegrundfarbe vom Button
		button1.setFocusable(false); // keine Border mehr um die Schrift
//		button1.setLocation(winwidth/2, winHeight/2);

		button2.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		button2.setForeground(Color.GRAY);
		button2.setBackground(Color.DARK_GRAY);
		button2.setFocusable(false);
	

		button3.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		button3.setForeground(Color.GRAY);
		button3.setBackground(Color.DARK_GRAY);
		button3.setFocusable(false);

		button4.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		button4.setForeground(Color.GRAY);
		button4.setBackground(Color.DARK_GRAY);
		button4.setFocusable(false);

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});

		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(600, 400);
		frame.setTitle("Minigame");
		frame.pack();
		frame.setVisible(true);

		ButtonAction bAction = new ButtonAction();
		
		button1.addActionListener(bAction);
		button2.addActionListener(bAction);
//		button3.addActionListener(bAction);
//		button4.addActionListener(bAction);

	}

	private class ButtonAction implements ActionListener {

		public void actionPerformed1(ActionEvent e) {
			
			if(e.getSource() == button1) {
				Game gamePanel = new Game();
				
				frame.dispose();
			}
			else if(e.getSource()==button2) {
				Highscore highscorePanel = new Highscore();
				frame.dispose();
			}
//			else if(e.getSource()==button3) {
//				//sads
//			}
//			else if(e.getSource()==button4) {
//					//dad				
//			}

	};

		public void actionPerformed(ActionEvent e) {
			new GameFrame().draw();
		}

		public void draw() {
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocation(600, 400);
			frame.setTitle("Minigame");
			frame.pack();
			frame.setVisible(true);

		}

		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new MenuFrame();
				}

			});

		}
	}

	@Override
	public void draw() {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}
	public static void main(String[] args) {
	}
}
