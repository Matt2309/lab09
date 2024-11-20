package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    /**
     * Sets the next string to print.
     * @param input
     * 
     */
    void setNextStringToPrint(String input);

    /**
     * Returns the next string to print.
     * @return currentString
     * 
     */
    String getNextStringToPrint();

    /**
     * Return a list of the last printed strings.
     * @return printHistory
     * 
     */
    List<String> getPrintHistory();

    /**
     * Prints the current set string.
     * @throws IllegalStateException
     * 
     */
    void printCurrentString();
}
