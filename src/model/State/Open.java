package model.State;

/**
 * Open used for state of library when it is open
 */
public class Open implements LibraryState{

    /**
     * States that the library is open
     * @return true that library is open in open state
     */
    public boolean isOpen() {
        return true;
    }
}
