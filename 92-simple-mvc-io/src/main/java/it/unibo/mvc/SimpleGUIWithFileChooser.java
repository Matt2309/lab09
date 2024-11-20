package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private final JFrame frame = new JFrame();
    private static final Integer PROPORTION = 5;
    /**
     * Creates a new BadIOGUI.
     * 
     */
    public SimpleGUIWithFileChooser() {
        final Controller controller = new Controller();

        final JTextField textField = new JTextField(controller.getFilePathString());
        textField.setEnabled(false);

        final JButton browseBtn = new JButton("Browse...");
        final JTextArea area = new JTextArea();
        final JButton saveBtn = new JButton("save");

        final JPanel panel1 = new JPanel();
        final JPanel panel2 = new JPanel();

        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());

        panel1.add(area);
        panel1.add(saveBtn, BorderLayout.SOUTH);
        panel1.add(panel2, BorderLayout.NORTH);

        panel2.add(textField, BorderLayout.CENTER);
        panel2.add(browseBtn, BorderLayout.LINE_END);

        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        saveBtn.addActionListener((final ActionEvent e) -> {
            try {
                controller.saveContent(area.getText());
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(frame, e1, "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        browseBtn.addActionListener((final ActionEvent e) -> {
            final JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            final int res = chooser.showSaveDialog(null);
            if (res == JFileChooser.APPROVE_OPTION) {
                final String uri = chooser.getSelectedFile().getAbsolutePath();
                textField.setText(uri);
                controller.setAsCurrentFile(new File(uri));
            } else if (res == JFileChooser.ERROR) {
                JOptionPane.showMessageDialog(frame, "Errore durante l'apertura del file", "Error", JOptionPane.ERROR_MESSAGE);
            }
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
        new SimpleGUIWithFileChooser().display();
    }
}
