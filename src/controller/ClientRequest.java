package controller;

import model.LBMS;
import model.Visitor;
import model.commands.Register;
import model.commands.Search;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This class is in charge of accepting user requests
 * and delegating them where they need to go
 * 
 */

 public class ClientRequest implements Request{

    private String request = "";
    private String PARTIAL_REQUEST = "partial request";
    private String VALID_REQUEST = "valid request";
    private String DUPLICATE = "duplicate";
    private LBMS library = new LBMS();

    public ClientRequest() throws FileNotFoundException {
    }


    public String validateRequest(String r) throws FileNotFoundException {
        
        if(!r.endsWith(";")) {
            this.request = PARTIAL_REQUEST;
            return request;
        }
        else
            return execute(r);
    }

    public String execute(String r) throws FileNotFoundException {
        String user_request = r.substring(0, r.length()-1);
        String request_type = user_request.split(",")[0];

        switch(request_type){

            case("login"):
            request = "Type in your first name, last name, address, and phone number";
            break;

            /*
              Search Command
             */
            case("search"):
                if (user_request.split(",").length == 1) {
                    Search search = new Search("no_params");
                    search.requestParams();
                    request = VALID_REQUEST;
                }
                else {
                    Search searchBook = new Search(user_request);
                    searchBook.execute();
                }
                break;

            /*
              Register Command
             */
            case("register"):
                ArrayList<Visitor> visitors = library.getVisitors();
                String[] user_info = user_request.split(",");
                if(user_request.length() == 1) {
                    Register register = new Register("no_params");
                    register.requestParams();
                    request = VALID_REQUEST;
                }
                else {
                    for (Visitor v : visitors) {
                        if (user_info[1].equalsIgnoreCase(v.getFirstName()) && user_info[2].equalsIgnoreCase(v.getLastName())
                                && user_info[3].equalsIgnoreCase(v.getAddress()) && Long.parseLong(user_info[4]) == (v.getPhoneNumber())) {
                            Register register = new Register("duplicate");
                            register.requestParams();
                            request = DUPLICATE;
                        }
                    }
                    if(!request.equals("duplicate")){
                        Register register = new Register(user_request);
                        register.execute();
                        request = VALID_REQUEST;
                        break;
                    }
                }
                break;

            case("arrive"):
                break;

            case("depart"):
                break;

            case("info"):
                break;

            case("borrow"):
                break;

            case("borrowed"):
                break;

            case("return"):
                break;

            case("pay"):
                break;

            case("buy"):
                break;

            case("advance"):
                break;

            case("datetime"):
                break;



        }

        return request;
    }


    public String getRequestType() {
        return request;
    }
}