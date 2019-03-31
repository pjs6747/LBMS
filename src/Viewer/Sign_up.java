package Viewer;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Sign_up {
        private final BorderPane rootPane ; // or any other kind of pane, or  Group...

        public Sign_up() {
            rootPane = new BorderPane();

            // build UI, register event handlers, etc etc
            //stage.setTitle("Welcome to the LBMS");
            Scene scene = new Scene(new Group(), 450, 250);
            TextField username = new TextField ();
            TextField password = new TextField ();
            username.setText("Username");
            password.setText("Password");

        }

        public Pane getRootPane() {
            return rootPane ;
        }
}
