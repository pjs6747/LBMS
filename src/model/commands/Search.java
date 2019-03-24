package model.commands;

public class Search implements Command{
    private String[] parsedRequest;

    public Search(String request){
        this.parsedRequest = request.split(",");
    }

    public String requestParams(){
        String params_needed = "";
        String title;
        String authors;
        int ISBN;
        String publisher;
        String sort_order;

        int params = parsedRequest.length - 1;

        if(parsedRequest[0].equals(("no_params")))
            params_needed = "search, missing-parameters, { title,[{authors},isbn[,publisher[,sort order]]] };";
        else{
            // search,*,{J.K Rowling}
            switch(params) {
                case(1):
                    title = parsedRequest[1];

                case(2):
                    title = parsedRequest[1];
                    authors = parsedRequest[2];

                case(3):
                    title = parsedRequest[1];
                    authors = parsedRequest[2];
                    ISBN = Integer.parseInt(parsedRequest[3]);
            }
        }

        return params_needed;
    }

    @Override
    public void execute() {
    }
}

