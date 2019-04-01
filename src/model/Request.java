package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import model.GoogleBook.GoogleBookRepsonse;


public class Request {

    public static ArrayList<Book> buyBooksFromGoogle(String[] isbns) {
        ArrayList<Book> books = new ArrayList<>();

        for (String isbn: isbns) {
            // Template request
            String apiURL = generateBuyAPIURL(isbn);
            // Make request
            String response = requestBooks(apiURL);
            // Parse response to object
            Gson gson = new Gson();
            GoogleBookRepsonse responseObj = gson.fromJson(response,GoogleBookRepsonse.class);
            books.add(new Book(responseObj));
        }

        return books;
    }

    public static Book searchBooksFromGoogle(String title, String author, String isbn, String publisher) {

        // Template request
        String apiURL = generateSearchAPIURL(title, author, isbn, publisher);
        // Make request
        String response = requestBooks(apiURL);
        // Parse response to object
        Gson gson = new Gson();
        GoogleBookRepsonse responseObj = gson.fromJson(response,GoogleBookRepsonse.class);

        return new Book(responseObj);
    }

    private static String generateBuyAPIURL(String isbn) {
        return String.format("https://www.googleapis.com/books/v1/volumes?q=isbn:%s", isbn);
    }

    private static String requestBooks(String url) {
        try {

            // Create a URL and open a connection
            URL BookURL = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) BookURL.openConnection();

            // Set the paramters for the HTTP Request
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestProperty("Accept", "application/json");

            // Create an input stream and wrap in a BufferedReader to read the
            // response.
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            // MAKE SURE TO CLOSE YOUR CONNECTION!
            in.close();

            // response is the contents of the JSON
            return response.toString();
        }
        catch (FileNotFoundException e) {
            System.out.print("URL not found: ");
            System.out.println(e.getMessage());
        }
        catch (MalformedURLException e) {
            System.out.print("Malformed URL: ");
            System.out.println(e.getMessage());
        }
        catch (ProtocolException e) {
            System.out.print("Unsupported protocol: ");
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    private static String generateSearchAPIURL(String title, String author, String isbn, String publisher) {

        ArrayList<String> queries = new ArrayList<>();

        if (title != "*") {
            queries.add(String.format("intitle:%s", title));
        }

        if (author != "*") {
            queries.add(String.format("inauthor:%s", author));
        }

        if (isbn != "*") {
            queries.add(String.format("isbn:%s", isbn));
        }

        if (publisher != "*") {
            queries.add(String.format("inpublisher:%s", publisher));
        }

        return String.format("https://www.googleapis.com/books/v1/volumes?q=%s", String.join("+", queries));

    }

}
