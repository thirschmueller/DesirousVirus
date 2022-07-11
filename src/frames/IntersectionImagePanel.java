package frames;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import controllers.EnemyMovement;
import controllers.MovementController;


@SuppressWarnings("serial")
public class IntersectionImagePanel extends JPanel {
	private static BufferedImage bgImg;


	public IntersectionImagePanel() {
		try {
			File img1 = new File("resources/pictures/veins.jpg");
			bgImg = ImageIO.read(img1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	protected void paintComponent(Graphics g) {					// Paint methode um sachen auf den Bildschirm zu zeichnen 
		super.paintComponent(g);					

		if (bgImg != null) {
			g.drawImage(bgImg, -450, 0, this);						// Größe und Position von Backroundimage
		}

	}

	
	public Dimension getPreferredSize() {
		if (bgImg != null) {
			int width = bgImg.getWidth();
			int height = bgImg.getHeight();
			return new Dimension(width, height);
		}
		return super.getPreferredSize();
	}
	 	
		
	private static ImageIcon getScaled(final ImageIcon icon, final int size) {
		Image image = icon.getImage(); // transform it
		Image newimg = image.getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH); 					// scale it the smooth way
		return new ImageIcon(newimg); // transform it back
		
	}

	private static void createAndShowGui() {
        IntersectionImagePanel mainPanel = new IntersectionImagePanel();
        final JFrame frame = new JFrame();
        
        frame.pack();
        
//        frame.addComponentListener(new ResizeListener());

        
        final ImageIcon icon = getScaled(new ImageIcon("resources/pictures/virus.png"), 100);				
																											
        final JLabel label = new JLabel(icon);
     
        
        
        final ImageIcon icon2 = getScaled(new ImageIcon("resources/pictures/leukocyt.png"), 50);			
        final JLabel label2 = new JLabel(icon2);
        
        label.setBounds(400, 400, 150, 150);
        label2.setBounds(600, 600, 50, 50);
        
        final MovementController controller = new MovementController(label, frame);
        
        initTimer(label2);
                         
        
        
      
        frame.add(label);
        frame.add(label2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(controller);
        frame.getContentPane().add(mainPanel);
        frame.pack();											// frame.pack nimmt alle inhalte von frame und passt das fenster immer an die größe der Teile an --> Verhältnis bleibt gleich
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
      
        
    }
		
		
	 private static void initTimer(final Component component) {
         Timer t = new Timer(17, e -> {												// gibt milisekunden an bis zum nächsten update --> 17 = 60fps
        	 new EnemyMovement(component).move(5);									// gibt geschwindigkeit an 
             component.repaint();
             
         });
         t.start();
     }  
	 
	 	 
	 
	 
	//Mehtoden ueberladen(Verschiedene sachen in der Klammer, sodass man nicht nur für 1 fall Konstruktoren hat sondern auch Variablen ,die man dann wo anders verwenden kann
	 																					//Wenn man einen x/y wert angibt wird der 2. Konstruktor verwendet 
	public static void main(String[] args) {
		SwingUtilities.invokeLater(IntersectionImagePanel::createAndShowGui);
	}
}