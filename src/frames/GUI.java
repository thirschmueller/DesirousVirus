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
	JFrame frame;
	JPanel panel;

	public GUI() {

		frame = new JFrame();

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Minigame");
		frame.getContentPane().setBackground(Color.black);
		frame.setLocation(125, 75);
		frame.pack();
		frame.setSize(Width, Height);				// setSize() benutzen, wenn die parents keinen layout manager(z.B. set Layout Boxlayout) haben
		frame.setVisible(true);				    // setPreferredSize() hängt mit setMinimumSize und setMaximumSize zusammen --> benutzen, wenn ein parent layout manager vorhanden ist
	}

	public void run() {
//	DA.update();
	}

}

