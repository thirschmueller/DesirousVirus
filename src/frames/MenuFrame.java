package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame implements ActionListener, Frame {

    private static final JFrame frame = new JFrame();

    public MenuFrame() {
        final JButton button = new JButton("Start Game");
        button.addActionListener(this);

        final JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new GameFrame().draw();
    }

    public void draw() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Minigame");
        frame.pack();
        frame.setVisible(true);
    }
}
