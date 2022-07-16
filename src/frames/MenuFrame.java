package frames;

import behavior.AsyncTask;
import main2.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame {

    private static final JFrame menuFrame = new JFrame();
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

        menuFrame.getContentPane().add(panel);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setLocation(600, 400);
        menuFrame.setTitle("Minigame");
        menuFrame.pack();
        menuFrame.setVisible(true);

        ButtonAction bAction = new ButtonAction();

        button1.addActionListener(bAction);
        button2.addActionListener(bAction);
    }

    public static class ButtonAction implements ActionListener {

        final static Game game = new Game();
        final static JFrame gameFrame = new JFrame(Game.title);

        public void actionPerformed(ActionEvent e) {
            MenuFrame.menuFrame.dispose();

            gameFrame.add(game);
            gameFrame.pack();
            gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // makes the window full screen
            gameFrame.requestFocus(); // key input are recognised by the frame without clicking once on it
            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameFrame.setLocationRelativeTo(null); // centers window on screen
            gameFrame.setVisible(true); // shows the frame

            new AsyncTask(game); // starts game loop in new thread
        }

        public static void restart() {
            gameFrame.dispose();
            new MenuFrame();
        }
    }
}
