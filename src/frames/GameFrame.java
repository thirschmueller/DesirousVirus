package frames;

import controllers.MovementController;
import javax.swing.*;
import java.awt.*;

public class GameFrame implements Frame {

    private final static JFrame frame = new JFrame();
    
    
    
    public GameFrame() {
    	
    	final ImageIcon icon = new ImageIcon("resources/pictures/virus.png");
    	    	
    	
        final JLabel label = new JLabel(icon);						
        
        
        label.setBounds(400, 400, 150, 150);
        label.setOpaque(true);

        final MovementController controller = new MovementController(label);

        frame.add(label);
        frame.addKeyListener(controller);
    }

  
    public void draw() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLocation(400, 20);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.black);
        frame.setVisible(true);
    }
}
