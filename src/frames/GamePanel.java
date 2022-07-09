package frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{			// extends nutzen, wenn man eine child klasse ableitet oder erstellt von der parent class(super class) 
																			//implements wenn man ein interface implementieren will
	final int PANEL_WIDTH = 1280;
	final int PANEL_HEIGHT = 720;
	Image virus;
	Image backgroundImage;
	Timer timer;
	int xVelocity = 1;
	int yVelocity = 1;
	int x = 0;
	int y = 0;
	
	GamePanel(){
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.BLACK);
		virus = new ImageIcon("virus.png").getImage();
		backgroundImage = new ImageIcon("veins.jpg").getImage();
		timer = new Timer(10, this);
		timer.start();
		
	}
	
	public void paint(Graphics g) {
		
		super.paint(g); //färbt Hintergrund schwarz
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.drawImage(backgroundImage, 0, 0, null);
		g2D.drawImage(virus, x, y, null);
	}

																		 
	public void actionPerformed(ActionEvent e) {					//void, weil darin etwas berechnet wird oder dargestellt wird aber nicht wieder returnt werden muss (muss nicht außerhalb davon verwendet werden)
		if (x>=PANEL_WIDTH-virus.getWidth(null) || x<0) {
			xVelocity = xVelocity * -1;
			
		}
		
		x = x + xVelocity;
		
		
		if (y>=PANEL_HEIGHT-virus.getHeight(null) || y<0) {
			yVelocity = yVelocity * -1;
			
		}
		
		y = y + yVelocity;
		
		repaint();
		
		
		
	}
	
	

}
