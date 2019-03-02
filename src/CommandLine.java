import controller.ClientRequest;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main class
 */

public class CommandLine{
    
    public static void main(String args[]){
        String inputString;

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        ClientRequest cr = new ClientRequest();

        System.out.println("Welcome to the Library. Type in a request to get started\n>");

        try {
            inputString = br.readLine();
            System.out.println("you said: " + inputString);
            System.out.println(cr.validateRequest(inputString));
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("You goofed up: " + e);
        }

    }

}