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
import model.LBMS;
import model.Visitor;

public class SignUpPage{

    private final BorderPane rootPane ; // or any other kind of pane, or  Group...
    Scene scene;

    public SignUpPage(LBMS lbms) {
        rootPane = new BorderPane();

        // build UI, register event handlers, etc etc
        scene = new Scene(new Group(), 450, 250);
        TextField username = new TextField ();
        TextField password = new TextField ();
        TextField fName = new TextField ();
        TextField lName = new TextField ();
        TextField address = new TextField ();
        TextField phoneNum = new TextField ();
        phoneNum.setPromptText("phone number");
        address.setPromptText("address");
        lName.setPromptText("last name");
        fName.setPromptText("first name");
        username.setPromptText("Username");
        password.setPromptText("Password");
        Button sign_up = new Button("signup!");
        Label message = new Label();

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(username, 0, 0);
        grid.add(password, 0, 1);
        grid.add(fName, 0, 2);
        grid.add(lName, 0, 3);
        grid.add(address, 0, 4);
        grid.add(phoneNum, 0, 5);
        grid.add(message, 1, 6);
        grid.add(sign_up,1, 7);

        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);

        sign_up.setOnAction(e ->{
            if(username.getText() == null || username.getText().isEmpty() || password.getText() == null || password.getText().isEmpty() || fName.getText() == null || fName.getText().isEmpty() || lName.getText() == null || lName.getText().isEmpty()|| address.getText() == null || address.getText().isEmpty()|| phoneNum.getText() == null || phoneNum.getText().isEmpty()){
                message.setText("All fields must be filled out");
            }else if(lbms.findVisitor(username.getText()) !=null){
                message.setText("This username is already Taken");
            } else{
                if(phoneNum.getText().chars().allMatch(Character::isDigit )){
                lbms.registerVisitor(fName.getText(), lName.getText(), address.getText(), Long.parseLong(phoneNum.getText()), username.getText(), password.getText());
                lbms.startVisit(username.getText());
                message.setText("You have successfully signed up");
                searchPage searchPage = new searchPage();
                scene = searchPage.getScene();
                }else{message.setText("phone number must be all numbers");}
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
