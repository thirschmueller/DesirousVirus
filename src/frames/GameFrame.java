package frames;

import controllers.MovementController;
import entities.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

public class GameFrame extends java.awt.Frame implements Frame {

    private static final long serialVersionUID = 1L;		// --> kein fehlercode mehr (jedes Objekt hat eine default UID aber je nach dem welche compiler man implementiert kann es zu problemen kommen) mit der Zeile kann das nicht mehr passieren

	private final static JFrame frame = new JFrame();
    
	
    
    
    
    public GameFrame() {									// Konstruktor immer mit klammer direkt dahinter --> Leere Klammern also keine Argumente
    	
    	final ImageIcon icon = new ImageIcon("resources/pictures/virus.png");
    	    	
    	
        final JLabel label = new JLabel(icon);				//instanzierung eines Objekts
        
        
        
        label.setBounds(100, 100, 150, 150);
        
        final MovementController controller = new MovementController(label, frame);					// ergänzen von null ansonsten fehlermeldung --> muss 2 argumente haben 
        
		
        add(label);
        addKeyListener(controller);
        
        a = new ImageIcon("resources/pictures/veins.jpg");
       
        
    }

    ImageIcon a;

    WindowListener wl = new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    };

    public void paint(Graphics g) {
        super.paint(g);						//super ist eine Referenz auf die Elternklasse. Hier wird der Konstruktor der Basisklasse aufgerufen
        g.drawImage(a.getImage(), 0, 0, this);
    }
    
    
 
    
    	
    public void draw() {
    	
  //    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(a.getIconWidth(), a.getIconHeight());
        addWindowListener(wl);
        setLocationRelativeTo(null);
   //   frame.setLocation(400, 20);
   //   frame.setLayout(null);
        setTitle("Minigame");
        final ImageIcon icon = new ImageIcon("resources/pictures/veins.jpg");
        
        
        
        SwingUtilities.invokeLater(new Runnable(){
            
            public void run() {
                new ImageOnImage(new ImageIcon("resources/pictures/veins.jpg"), new ImageIcon("resources/pictures/veins.jpg"));
            }
        });
        
        setVisible(true);
        
    }
}
