package frames;

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

public class GUI extends JFrame { // implements ActionListener {

	public final static int Width = 1000, Height = 550;
	JLabel label;
	JFrame window;
	JPanel panel;

	public GUI() {

		window = new JFrame();

//		JButton button = new JButton("Start Game");
//		button.addActionListener(this);

//		label = new JLabel("Hitbox");
//		label = new JLabel("Number of clicks: 0");

//		JPanel panel = new JPanel();

//		panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 500, 500));

//		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

//		panel.setLayout(new GridLayout(0, 1));
//		panel.add(button);
//		panel.add(label);

//		JPanel panel = new JPanel();
//		panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 500, 500));
//		panel.setLayout(new GridLayout(0, 1));
// 		panel.add(button);
//		panel.add(label);

//		frame.add(panel, BorderLayout.CENTER);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Minigame");
		window.getContentPane().setBackground(Color.black);
		window.setLocation(125, 75);
		window.pack();
		window.setSize(Width, Height);
		window.setVisible(true);

	}

	public void run() {
//	DA.update();
	}

}

