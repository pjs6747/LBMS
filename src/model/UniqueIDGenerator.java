package model;

/**
 * This class creates a unique 10-digit id for users of the LBMS
 */
public class UniqueIDGenerator {
    private static long id = 1168100000;
    /**
     * Constructor for the generator
     */
    public UniqueIDGenerator(){}

    /**
     * Creates the unique id
     * @return : 10 digit id
     */
    public long generateID(){
        return id++;
    }
}
