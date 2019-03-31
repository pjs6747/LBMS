package model.State;

/*
Project: LBMS
File: Open
Author: Group 4
 */

/**
 * Open used for state of library when it is open
 */
public class Open implements LibraryState {

    /**
     * States that the library is open
     * @return true that library is open in open state
     */
    public boolean isOpen() {
        return true;
    }
}
