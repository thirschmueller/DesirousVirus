package frames;

import controllers.MovementController;
import javax.swing.*;
import java.awt.*;

public class GameFrame implements Frame {

    private final static JFrame frame = new JFrame();

    public GameFrame() {
        final JLabel label = new JLabel();
        label.setBounds(0, 400, 50, 50);
        label.setBackground(Color.red);
        label.setOpaque(true);

        final MovementController controller = new MovementController(label);

        frame.add(label);
        frame.addKeyListener(controller);
    }

  
    public void draw() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.black);
        frame.setVisible(true);
    }
}
