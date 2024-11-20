package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
        final Controller controller = new SimpleController();

        final JTextField textField = new JTextField();
        final JTextArea area = new JTextArea();

        final JButton printBtn = new JButton("Print");
        final JButton showBtn = new JButton("Show history");

        final JPanel panel = new JPanel();
        final JPanel buttonPanel = new JPanel();

        panel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new FlowLayout());

        panel.add(textField, BorderLayout.NORTH);
        panel.add(area, BorderLayout.CENTER);


        buttonPanel.add(printBtn);
        buttonPanel.add(showBtn);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        printBtn.addActionListener((final ActionEvent e) -> {
            controller.setNextStringToPrint(textField.getText());
            controller.printCurrentString();
        });

        showBtn.addActionListener((final ActionEvent e) -> {
            controller.getPrintHistory().forEach((el) -> {
                area.append(el + "\n");
            });
        });
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
