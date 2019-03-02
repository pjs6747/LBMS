package controller;

/**
 * This class is in charge of accepting user requests
 * and delegating them where they need to go
 * 
 */

 public class ClientRequest implements Request{

    public String validateRequest(String r){
        
        if(r.endsWith(";"))
            return "Command successful";
        else
            return "bruh good try";
    }

    public void execute(){}


 }