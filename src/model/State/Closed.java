package model.State;

/**
 * Closed used for state of library when it is closed
 */
public class Closed implements model.State.LibraryState {

    /**
     * States that the library is closed
     * @return false that library is open in open state, library is closed
     */
    public boolean isOpen() {
        return false;
    }
}
