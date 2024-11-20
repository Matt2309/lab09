package it.unibo.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;


/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File file;
    private static final String SEP = System.getProperty("file.separator");
    private static final String HOME_PATH = System.getProperty("user.home");

    /**
     *  By default, the current file is "output.txt" inside the user home folder.
     * 
     */
    public Controller() {
        this.file = new File(HOME_PATH + SEP + "output.txt");
    }

    /**
     *  Set a File as current File.
     * 
     * @param file
     */
    public void setAsCurrentFile(final File file) {
        this.file = file;
    }

    /**
     *  Get the current File.
     * 
     * @return File
     */
    public File getCurrentFile() {
        return this.file;
    }

    /**
     *  Get the path of current File.
     * 
     * @return String
     */
    public String getFilePathString() {
        return this.file.getPath();
    }

    /**
     * Saves the content on the current file.
     * 
     * @param content
     * @throws FileNotFoundException
     */
    public void saveContent(final String content) throws IOException {
        try (PrintStream ps = new PrintStream(this.getFilePathString(), StandardCharsets.UTF_8)) {
            ps.print(content);
        } catch (IOException e) {
            throw new IOException("Error while saving content to file: " + this.getFilePathString(), e);
        }
    }
}
