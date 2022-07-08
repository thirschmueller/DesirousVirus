package frames;

import controllers.MovementController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

public class GameFrame extends java.awt.Frame implements Frame {

    private final static JFrame frame = new JFrame();
    
    
    
    
    public GameFrame() {
    	
    	final ImageIcon icon = new ImageIcon("resources/pictures/virus.png");
    	    	
    	
        final JLabel label = new JLabel(icon);	
        
        
        
        label.setBounds(400, 400, 150, 150);

        final MovementController controller = new MovementController(label);

        add(label);
        addKeyListener(controller);
        
        a = new ImageIcon("resources/pictures/veins.jpg");
      //frame.setSize(1000, 1000);      
        
    }

    ImageIcon a;

    WindowListener wl = new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    };

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(a.getImage(), 0, 0, this);
    }
    
    
 
    
    	
    public void draw() {
    	
  //    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(a.getIconWidth(), a.getIconHeight());
        addWindowListener(wl);
        setLocationRelativeTo(null);
  //    frame.setLocation(400, 20);
   //   frame.setLayout(null);
        setTitle("Minigame");
        final ImageIcon icon = new ImageIcon("resources/pictures/veins.jpg");
        
        
        
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new ImageOnImage(new ImageIcon("resources/pictures/veins.jpg"), new ImageIcon("resources/pictures/veins.jpg"));
            }
        });
        
        setVisible(true);
        
    }
}
