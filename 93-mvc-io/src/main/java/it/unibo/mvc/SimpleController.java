package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String currentString;
    private final List<String> printHistory;

    /**
     * 
     */
    public SimpleController() {
        this.printHistory = new ArrayList<>();
        this.currentString = "";
    }

    @Override
    public void setNextStringToPrint(final String input) {
        this.currentString = input;
    }

    @Override
    public String getNextStringToPrint() {
        return currentString;
    }

    @Override
    public List<String> getPrintHistory() {
        return new ArrayList<>(this.printHistory);
    }

    @Override
    public void printCurrentString() {
        if (!this.currentString.isEmpty() || !this.currentString.isBlank()) {
            System.out.println(currentString); //NOPMD Suppressed as print is required in the exercise
            printHistory.add(currentString);
        } else {
            throw new IllegalStateException("The current string is empty");
        }
    }
}
