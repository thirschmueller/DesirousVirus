package minigames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import org.newdawn.slick.AppGameContainer;

public class GUI      { //JFrame Konstruktor einf�gen             //implements ActionListener {
	
	
//Und �ber Superklasse (Vererbung)	
	
		private int count = 0;
		private JLabel label;
		private JFrame frame;
		private JPanel panel;
	
	public GUI() {
		
		frame = new JFrame();
		
		//JButton button = new JButton("Start Game");
		//button.addActionListener(this);
		
		label = new JLabel("Hitbox");
//		label = new JLabel("Number of clicks: 0");
		
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 500, 500));
		panel.setLayout(new GridLayout(0, 1));
		//panel.add(button);
		panel.add(label);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Minigame");
		frame.getContentPane().setBackground(Color.black);
		frame.pack();
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		new GUI();
	}

		
	
	//@Override
	//public void actionPerformed(ActionEvent e) {
		//count++;
		//label.setText("Number of clicks: " + count);
	}
//}
