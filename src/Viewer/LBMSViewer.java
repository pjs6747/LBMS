package Viewer;


import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.LBMS;
import model.Visitor;
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

import java.io.FileNotFoundException;


public class LBMSViewer extends Application implements Observer<Book>{

    private Node console;
    private Node left;
    private Node right;
    private HBox box;
    private LBMS lbms;


    @Override
    public void start(Stage stage) throws FileNotFoundException {
        this.lbms = new LBMS();
        ConcretConsoleWriter writer = new ConcretConsoleWriter(console);
        CommandLine command = new CommandLine(writer);
        stage.setTitle("Welcome to the LBMS");
        Scene scene = new Scene(new Group(), 450, 250);


        Button login = new Button("Login");
        Button sign_up = new Button("Sign-up");

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("WELCOME TO THE LBMS! PLEASE LOG IN OR SIGN UP"), 0, 0);
        grid.add(login, 0, 4);
        grid.add(new Label("new user?"), 0, 8);
        grid.add(sign_up, 0, 9);

        sign_up.setOnAction(e -> {
            SignUpPage signUp_bnt = new SignUpPage(lbms, stage);
            stage.getScene().setRoot(signUp_bnt.getRootPane());
            stage.setScene(signUp_bnt.getScene());
            stage.show();
        });

        login.setOnAction(e -> {
            LoginPage loginPage = new LoginPage(lbms, stage);
            stage.getScene().setRoot(loginPage.getRootPane());
            stage.setScene(loginPage.getScene());
            stage.show();
        });


        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }

//        TextField username = new TextField ();
//        TextField password = new TextField ();
//        username.setPromptText("Username");
//        password.setPromptText("Password");
//
//        Button login = new Button("Login");
//        Button sign_up = new Button("Sign-up");
//        Label message = new Label();
//
//
//        GridPane grid = new GridPane();
//        grid.setVgap(4);
//        grid.setHgap(10);
//        grid.setPadding(new Insets(5, 5, 5, 5));
//        grid.add(login, 1, 0);
//        grid.add(username, 0, 0);
//        grid.add(password, 0, 1);
//        grid.add(message,1, 2);
//        grid.add(new Label("new user?"),1, 8);
//        grid.add(sign_up,1, 9);
//
//        sign_up.setOnAction(e ->{
//            SignUpPage signUp_bnt = new SignUpPage(lbms, stage);
//            stage.getScene().setRoot(signUp_bnt.getRootPane());
//            stage.setScene(signUp_bnt.getScene());
//            stage.show();
//        });
//
//        login.setOnAction(e ->{
//            if(username.getText() == null || username.getText().isEmpty() || password.getText() == null || password.getText().isEmpty()){
//                message.setText("All fields must be filled out");
//            }else if(lbms.findVisitor(username.getText()) !=null){
//                if(lbms.findVisitor(username.getText()).getPassword() == password.getText()) {
//                    //searchPage searchPage_bnt = new searchPage();
//                    UserHome userHomePage = new UserHome(lbms.findVisitor(username.getText()), lbms, stage);
//                    stage.getScene().setRoot(userHomePage.getRootPane());
//                    stage.setScene(userHomePage.getScene());
//                    stage.show();
//                }else{
//                    message.setText("This password does not match");
//                }
//            }else{
//                message.setText("Cannot find this user");
//            }
//        });
//
//
//        Group root = (Group) scene.getRoot();
//        root.getChildren().add(grid);
//        stage.setScene(scene);
//        stage.show();
//    }

    @Override
    public void update(Book pushValue) {

    }
}
