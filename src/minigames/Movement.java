package minigames;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Movement extends JFrame implements KeyListener{ 

	
	JLabel label;
	ImageIcon icon;
	
	Movement(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(null);
		this.addKeyListener(this);
		
		icon = new ImageIcon("Virus.png");
		
		label = new JLabel();
		label.setBounds(0, 400, 50, 50);
		label.setIcon(icon);
<<<<<<< Updated upstream
		//label.setBackground(Color.red);
		//label.setOpaque(true);
=======
		label.setBackground(Color.red);
		label.setOpaque(true);
>>>>>>> Stashed changes
		
		this.getContentPane().setBackground(Color.black);
		this.add(label);
		this.setVisible(true);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		switch(e.getKeyChar()) {
		case 'a': label.setLocation(label.getX()-10, label.getY());
			break;
		case 'd': label.setLocation(label.getX()+10, label.getY());
			break;
		}
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
<<<<<<< Updated upstream
		case '37': label.setLocation(label.getX()-50, label.getY());
			break;
		case '39': label.setLocation(label.getX()+50, label.getY());
=======
		case 37: label.setLocation(label.getX()-50, label.getY());
			break;
		case 39: label.setLocation(label.getX()+50, label.getY());
>>>>>>> Stashed changes
			break;
		}
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(e.getKeyChar());
		System.out.println(e.getKeyCode());
		
	}

}
