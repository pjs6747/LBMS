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

public class SignUpPage{

    private final BorderPane rootPane ; // or any other kind of pane, or  Group...
    Scene scene;

    public SignUpPage() {
        rootPane = new BorderPane();

        // build UI, register event handlers, etc etc
        scene = new Scene(new Group(), 450, 250);
        TextField username = new TextField ();
        TextField password = new TextField ();
        username.setText("Username");
        password.setText("Password");
        Button sign_up = new Button("signup!");

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(username, 0, 0);
        grid.add(password, 0, 1);
        grid.add(sign_up,1, 2);

        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);

        sign_up.setOnAction(e ->{
            //if username  not in users.keys
            // add username to key and set users[username] = password;
            searchPage searchPage_bnt = new searchPage();
            scene = searchPage.getScene();

            //else
            //Label label = new Label();
            //label.setText("This username s already taken.");
            });
        }

        public Pane getRootPane() {
            return rootPane ;
        }

    public Scene getScene() {
        return scene;
    }
}
