import controller.ClientRequest;
import model.LBMS;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * Main class
 */

public class CommandLine{
    public static void main(String args[]) throws FileNotFoundException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        ClientRequest cr = new ClientRequest();

        LBMS lbms = new LBMS();

        System.out.println("Welcome to the Library. Type in a request to get started.\nIf you are new to the library, please type in 'login;'.");

        try {
            while(true) {
                // System.out.println("you said: " + inputString);
                while (!cr.validateRequest(br.readLine()).equals("valid request")) {
                    System.out.println(cr.getRequestType());
                    // inputString += br.readLine();
                }

                if (cr.getRequestType().equals("valid request")) {
                    // System.out.println(cr.getRequestType());
                    cr.validateRequest(br.readLine());
                }
            }

        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("You goofed up: " + e);
        }

    }

//    public LBMS getLbms() {
//        return this.lbms;
//    }
}