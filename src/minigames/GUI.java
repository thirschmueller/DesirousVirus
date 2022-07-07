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

public class GUI      { //JFrame Konstruktor einfügen             //implements ActionListener {

//Und  über Superklasse (Vererbung)	
	
	
		public final static int Width = 1550, Height = 750;
		private final JLabel label;
		private final JFrame window;
		private JPanel panel;
		private final DrawArea DA;
		
		
	public GUI() {
		
		window = new JFrame();
		
		
		//JButton button = new JButton("Start Game");
		//button.addActionListener(this);
		
		label = new JLabel("Hitbox");
//		label = new JLabel("Number of clicks: 0");
		
		
		JPanel panel = new JPanel();
//		panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 500, 500));
//		panel.setLayout(new GridLayout(0, 1));
		//panel.add(button);
//		panel.add(label);
		
		window.setSize(Width, Height);
//		frame.add(panel, BorderLayout.CENTER);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Minigame");
		window.getContentPane().setBackground(Color.black);
		window.pack();
		window.setVisible(true);
		
		DA  = new DrawArea(window); 
		window.add(DA);
		
		
	}
//	public static void main(String[] args) {
//		new GUI();
	
	public void run( ) {
	DA.update();
	}

		
	
	//@Override
	//public void actionPerformed(ActionEvent e) {
		//count++;
		//label.setText("Number of clicks: " + count);
	}
//}
