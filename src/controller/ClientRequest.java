package controller;

/**
 * This class is in charge of accepting user requests
 * and delegating them where they need to go
 * 
 */

 public class ClientRequest implements Request{

    public String validateRequest(String r){
        
        if(!r.endsWith(";"))
            return "partial request";
        else
            return execute(r);
    }

    public String execute(String r) {
        String request = "";

        switch(r){
            case("login;"):
            request = "Type in your first name, last name, address, and phone number";
        }

        return request;
    }


 }