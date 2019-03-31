package model.commands;

import controller.ClientRequest;
import controller.ConsoleWriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main class
 */

public class CommandLine {

    private ConsoleWriter console;
    private boolean loopback = false;

    private void constructorHelper (ConsoleWriter console) {
        //theBoard.createModel (NUM_ROWS, NUM_COLS, NUM_SHIPS);
        this.console = console;
    }

    public CommandLine(ConsoleWriter console){
        constructorHelper(console);
        loopback = true;
    }
    
    public static void main(String args[]){
        String inputString;
        String validCommmand;

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        ClientRequest cr = new ClientRequest();

        System.out.println("Welcome to the Library. Type in a request to get started.\nIf you are new to the library, please type in 'login;'.");

        try {
            inputString = br.readLine();
            System.out.println("you said: " + inputString);
            while(cr.validateRequest(inputString).equals("partial request")){
                System.out.println(cr.PARTIAL_REQUEST);
                inputString += br.readLine();

            }


        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("You goofed up: " + e);
        }

    }

}