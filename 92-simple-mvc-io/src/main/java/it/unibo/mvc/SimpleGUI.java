package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private final JFrame frame = new JFrame();
    private static final Integer PROPORTION = 5;
    /**
     * Creates a new BadIOGUI.
     * 
     */
    public SimpleGUI() {
        final JPanel canvas = new JPanel();

        canvas.setLayout(new BorderLayout());
        final JTextArea area = new JTextArea();
        final JButton btn = new JButton("save");

        canvas.add(area);
        canvas.add(btn, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();

        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
