package Viewer;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.LBMS;

public class LoginPage {

    private final BorderPane rootPane ; // or any other kind of pane, or  Group...
    Scene scene;
    Stage stage;
    LBMS lbms;

    public LoginPage(LBMS lbms, Stage stage) {
        rootPane = new BorderPane();
        this.stage = stage;
        this.lbms = lbms;

        scene = new Scene(new Group(), 450, 250);
        TextField username = new TextField ();
        TextField password = new TextField ();
        username.setPromptText("Username");
        password.setPromptText("Password");

        Button login = new Button("Login");
        Button sign_up = new Button("Sign-up");
        Label message = new Label();


        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(login, 1, 0);
        grid.add(username, 0, 0);
        grid.add(password, 0, 1);
        grid.add(message,1, 2);
        grid.add(new Label("new user?"),1, 8);
        grid.add(sign_up,1, 9);

        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);

        sign_up.setOnAction(e ->{
            SignUpPage signUp_bnt = new SignUpPage(lbms, stage);
            stage.getScene().setRoot(signUp_bnt.getRootPane());
            stage.setScene(signUp_bnt.getScene());
            stage.show();
        });

        login.setOnAction(e ->{
            if(username.getText() == null || username.getText().isEmpty() || password.getText() == null || password.getText().isEmpty()){
                message.setText("All fields must be filled out");
            }else if(lbms.findVisitor(username.getText()) !=null){
                if(lbms.findVisitor(username.getText()).getPassword() == password.getText()) {
                    //searchPage searchPage_bnt = new searchPage();
                    UserHome userHomePage = new UserHome(lbms.findVisitor(username.getText()), lbms, stage);
                    stage.getScene().setRoot(userHomePage.getRootPane());
                    stage.setScene(userHomePage.getScene());
                    stage.show();
                }else{
                    message.setText("This password does not match");
                }
            }else{
                message.setText("Cannot find this user");
            }
        });

    }

    public Pane getRootPane() {
        return rootPane ;
    }

    public Scene getScene() {
        return scene;
    }
}
