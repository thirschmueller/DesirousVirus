package frames;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import controllers.MovementController;

@SuppressWarnings("serial")
public class IntersectionImagePanel extends JPanel {
    private static BufferedImage bgImg, fgImg;
   

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
            return new Dimension(width , height );
        }
        return super.getPreferredSize();
    }

    private static void createAndShowGui() {
        IntersectionImagePanel mainPanel = new IntersectionImagePanel();
        
        
        final ImageIcon icon = new ImageIcon("resources/pictures/virus.png");
        final JLabel label = new JLabel(icon);
        final MovementController controller = new MovementController(label);
        
        
        label.setBounds(400, 400, 150, 150);
        
        JFrame frame = new JFrame("IntersectionImage");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(controller);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(IntersectionImagePanel::createAndShowGui);
    }
}