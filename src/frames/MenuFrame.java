package frames;

import main2.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame {

    private static final JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton button1 = new JButton("Play");
    JButton button2 = new JButton("Highscores");
    JButton button3 = new JButton("Options");
    JButton button4 = new JButton("Exit");


    public MenuFrame() {
        button1.setBounds(100, 50, 100, 30);

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS)); // Vertikal ausgelegt

        panel.add(button1);
        panel.add(Box.createRigidArea(new Dimension(150, 40))); // erstellt abstand (Horizontal, Vertikal)

        panel.add(button2);
        panel.add(Box.createRigidArea(new Dimension(150, 40)));
        button3.setAlignmentY(Component.TOP_ALIGNMENT);

        panel.add(button3);
        Component rigidArea = Box.createRigidArea(new Dimension(150, 40));
        panel.add(rigidArea);

        panel.add(button4);

        button1.setPreferredSize(new Dimension(300, 200));

        button1.setFont(new Font("Cooper Black", Font.BOLD, 50)); // Schriftart, Fettgedruckt und Größe
        button1.setForeground(Color.LIGHT_GRAY); // Schrift Farbe vom Button
        button1.setBackground(Color.DARK_GRAY); // Hintegrundfarbe vom Button
        button1.setFocusable(false); // keine Border mehr um die Schrift

        button2.setFont(new Font("Cooper Black", Font.PLAIN, 25));
        button2.setForeground(Color.GRAY);
        button2.setBackground(Color.DARK_GRAY);
        button2.setFocusable(false);


        button3.setFont(new Font("Cooper Black", Font.PLAIN, 25));
        button3.setForeground(Color.GRAY);
        button3.setBackground(Color.DARK_GRAY);
        button3.setFocusable(false);

        button4.setFont(new Font("Cooper Black", Font.PLAIN, 25));
        button4.setForeground(Color.GRAY);
        button4.setBackground(Color.DARK_GRAY);
        button4.setFocusable(false);

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(600, 400);
        frame.setTitle("Minigame");
        frame.pack();
        frame.setVisible(true);

        ButtonAction bAction = new ButtonAction();

        button1.addActionListener(bAction);
        button2.addActionListener(bAction);

    }

    private static class ButtonAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            final Game game = new Game();

            final JFrame frame = new JFrame(game.title);
            frame.add(game);
            frame.pack();
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // makes the window full screen
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null); // centers window on screen
            frame.setVisible(true); // shows the frame

            game.start(); // starts a thread
        }
    }
}
