package model.commands;

import model.LBMS;

import java.io.FileNotFoundException;

public class Search implements Command {
    private String[] parsedRequest;
    private String MISSING_PARAMETERS = "missing parameters";
    private LBMS library = new LBMS();

    public Search(String request) throws FileNotFoundException {
        this.parsedRequest = request.split(",");
    }

    public String requestParams() {
        String params_needed = "";

        if (parsedRequest[0].equals(("no_params"))) {
            params_needed = "search, missing-parameters, { title,[{authors},isbn[,publisher[,sort order]]] };";
            System.out.println(params_needed);
        }

        return MISSING_PARAMETERS;
    }

    @Override
    public void execute() {
        String title;
        String authors;
        int ISBN;
        String publisher;
        String sort_order;

        int params = parsedRequest.length - 1;

        // search,*,{J.K Rowling}
        switch (params) {
            case (1):
                title = parsedRequest[1];
                break;

            case (2):
                title = parsedRequest[1];
                authors = parsedRequest[2];
                break;

            case (3):
                title = parsedRequest[1];
                authors = parsedRequest[2];
                ISBN = Integer.parseInt(parsedRequest[3]);
                break;
        }
    }
}

