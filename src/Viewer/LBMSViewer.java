package Viewer;


import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.commands.CommandLine;
import controller.Observer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Book;


public class LBMSViewer extends Application implements Observer<Book>{

    private Node console;
    private Node left;
    private Node right;
    private HBox box;

    @Override
    public void start(Stage stage) {//throws Exception {
        ConcretConsoleWriter writer = new ConcretConsoleWriter(console);
        CommandLine command = new CommandLine(writer);
        stage.setTitle("Welcome to the LBMS");
        Scene scene = new Scene(new Group(), 450, 250);

        TextField username = new TextField ();
        TextField password = new TextField ();
        username.setText("Username");
        password.setText("Password");

        Button login = new Button("Login");
        Button sign_up = new Button("Sign-up");


        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(login, 1, 0);
        grid.add(username, 0, 0);
        grid.add(password, 0, 1);
        grid.add(new Label("new user?"),1, 8);
        grid.add(sign_up,1, 9);

        sign_up.setOnAction(e ->{
            SignUpPage signUp_bnt = new SignUpPage();
            stage.getScene().setRoot(signUp_bnt.getRootPane());
            stage.setScene(signUp_bnt.getScene());
            stage.show();
        });

        login.setOnAction(e ->{
            //if username in users.keys && users[username] = password;
            searchPage searchPage_bnt = new searchPage();
            stage.getScene().setRoot(searchPage_bnt.getRootPane());
            stage.setScene(searchPage_bnt.getScene());
            stage.show();
        });


        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();



//        Button login = new Button("Login");
//        Button sign_up = new Button("Sign-up");

//        final TextField name = new TextField();
//        name.setPromptText("Username");
//        name.setPrefColumnCount(10);
//        name.getText();
//        GridPane.setConstraints(name, 0, 0);
//        grid.getChildren().add(name);
////Defining the Password text field
//        final TextField password = new TextField();
//        password.setPromptText("password");
//        GridPane.setConstraints(password, 0, 1);
//        grid.getChildren().add(password);
////Defining the Login button
//        Button login = new Button("Login");
//        GridPane.setConstraints(login, 1, 0);
//        grid.getChildren().add(login);
////Defining the Sign-Up button
//        Button sign_up = new Button("Sign-up");
//        GridPane.setConstraints(sign_up, 1, 1);
//        grid.getChildren().add(sign_up);

//        StackPane root = new StackPane();
//        root.getChildren().add(login);
//        root.getChildren().add(sign_up);
//        stage.setScene(new Scene(root, 300, 250));
//        stage.show();


////Defining the Comment text field
//        final TextField comment = new TextField();
//        comment.setPrefColumnCount(15);
//        comment.setPromptText("Enter your comment.");
//        GridPane.setConstraints(comment, 0, 2);
//        grid.getChildren().add(comment);
////Defining the Submit button
//        Button submit = new Button("Submit");
//        GridPane.setConstraints(submit, 1, 0);
//        grid.getChildren().add(submit);
////Defining the Clear button
//        Button clear = new Button("Clear");
//        GridPane.setConstraints(clear, 1, 1);
//        grid.getChildren().add(clear);
        //"Search by Author, Title, ISBN, String publisher"

    }

    @Override
    public void update(Book pushValue) {
        
    }
}
