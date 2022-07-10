package frames;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Highscore extends JFrame {
	public static void main(String[] args) {
	}

	private static final JFrame frame = new JFrame();
	JPanel panel1 = new JPanel();

	public Highscore() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(600, 400);
		frame.setTitle("Highscore");
		frame.pack();
		frame.setVisible(true);

		// public final static int Width = 1000, Height = 550;
		// JLabel label;
		// JFrame window;

		// window = new JFrame();

//			JButton button = new JButton("Start Game");
//			button.addActionListener(this);

//			label = new JLabel("Hitbox");
//			label = new JLabel("Number of clicks: 0");

//			JPanel panel = new JPanel();

//			panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 500, 500));

//			panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

//			panel.setLayout(new GridLayout(0, 1));
//			panel.add(button);
//			panel.add(label);

//			JPanel panel = new JPanel();
//			panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 500, 500));
//			panel.setLayout(new GridLayout(0, 1));
//	 		panel.add(button);
//			panel.add(label);

//			frame.add(panel, BorderLayout.CENTER);
//			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			window.setTitle("Minigame");
//			window.getContentPane().setBackground(Color.black);
//			window.setLocation(125, 75);
//			window.pack();
//			window.setSize(Width, Height);				// setSize() benutzen, wenn die parents keinen layout manager(z.B. set Layout Boxlayout) haben
//			window.setVisible(true);				    // setPreferredSize() hängt mit setMinimumSize und setMaximumSize zusammen --> benutzen, wenn ein parent layout manager vorhanden ist
//		}

//		public void run() {
//		DA.update();
	}

//	}

}

// if(score > highScore) {
// highScore = score;
