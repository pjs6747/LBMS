package model.State;

/**
 * Implementation of Library state made to use the 'State' design pattern
 */
public interface LibraryState {

    /**
     * Determine state of Library if it is open or closed
     * @return boolean true if library is open and false if it is closed
     */
    boolean isOpen();

}
