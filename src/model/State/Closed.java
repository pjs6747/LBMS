package model.State;

/*
Project: LBMS
File: Closed
Author: Group 4
 */

/**
 * Closed used for state of library when it is closed
 */
public class Closed implements LibraryState {

    /**
     * States that the library is closed
     * @return false that library is open in open state, library is closed
     */
    public boolean isOpen() {
        return false;
    }
}
