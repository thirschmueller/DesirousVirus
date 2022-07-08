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

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (bgImg != null) {
			g.drawImage(bgImg, 0, 0, this);
		}

	}

	@Override
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
		Image newimg = image.getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		return new ImageIcon(newimg); // transform it back

	}

	private static void createAndShowGui() {
        IntersectionImagePanel mainPanel = new IntersectionImagePanel();
        
        
        final ImageIcon icon = getScaled(new ImageIcon("resources/pictures/virus.png"), 100);
        final JLabel label = new JLabel(icon);
        final MovementController controller = new MovementController(label, bgImg.getWidth(), bgImg.getHeight());
        
        
        final ImageIcon icon2 = getScaled(new ImageIcon("resources/pictures/leukocyt.png"), 50);
        final JLabel label2 = new JLabel(icon2);
        
        label.setBounds(400, 400, 150, 150);
        label2.setBounds(600, 600, 50, 50);
        
        initTimer(label2);
                         
        
        
        
        JFrame frame = new JFrame("IntersectionImage");
        frame.add(label);
        frame.add(label2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(controller);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        
    }
	
		
	 private static void initTimer(final Component component) {
         Timer t = new Timer(40, e -> {
        	 new EnemyMovement(component).move(10);
             component.repaint();
         });
         t.start();
     }  
	 
	 
	 
	 
	public static void main(String[] args) {
		SwingUtilities.invokeLater(IntersectionImagePanel::createAndShowGui);
	}
}