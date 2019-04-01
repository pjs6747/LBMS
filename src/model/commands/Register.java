package model.commands;
import model.LBMS;
import model.Visitor;

import java.io.FileNotFoundException;

/**
 * This is the Register class for the register command.
 */
public class Register implements Command {
    private String[] parsedRequest;
    private final String MISSING_PARAMETERS = "missing parameters";
    private final String DUPLICATE = "duplicate";
    private LBMS library = new LBMS();

    /**
     * Command Object
     * @param request - user request string
     */
     public Register(String request) throws FileNotFoundException {
         this.parsedRequest = request.split(",");
    }
    /**
     * Registers a new visitor so that they can access the library. Visitors are assigned
     * a unique, 10 digit id by the LBMS
     *
     * register,first name,last name,address, phone-number;
     * */
    @Override
    public void execute() {
        String first_name;
        String last_name;
        String address;
        long phone_number;
        String username;
        String password;

        first_name = parsedRequest[1];
        last_name = parsedRequest[2];
        address = parsedRequest[3];
        phone_number = Long.parseLong(parsedRequest[4]);
        username = parsedRequest[5];
        password = parsedRequest[6];

        library.registerVisitor(first_name, last_name, address, phone_number, username, password);
        System.out.println("Successfully Registered");
    }

    @Override
    public String requestParams() {
        String params_needed;
        String result = "";

        if (parsedRequest[0].equals(("no_params"))) {
            params_needed = "register, missing-parameters, first_name, last_name, address, phone_number;";
            System.out.println(params_needed);
            result = MISSING_PARAMETERS;
        }
        if(parsedRequest[0].equals(("duplicate"))){
            params_needed = "register, duplicate";
            System.out.println(params_needed);
            result = DUPLICATE;
        }

        return result;
    }
}
