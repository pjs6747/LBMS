package Viewer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.LBMS;
import model.Visit;
import model.Visitor;

public class searchPage {

    private static Scene scene;
    private final BorderPane rootPane ; // or any other kind of pane, or  Group...
    //UserHome userHome;

    public searchPage(Visitor visitor, LBMS lbms, Stage stage) {
        rootPane = new BorderPane();
        //this.userHome = userHome;

        // build UI, register event handlers, etc etc
        scene = new Scene(new Group(), 450, 250);
        TextField search_field = new TextField ();
        search_field.setPromptText("Search by Author, Title, ISBN, publisher");
        Button search = new Button("search!");
        Button back = new Button("go back!");
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Author",
                        "Title",
                        "ISBN",
                        "Publisher"
                );
        final ComboBox search_options = new ComboBox(options);

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(search_field, 1, 0);
        grid.add(search_options, 0, 0);
        grid.add(search,1, 3);
        grid.add(back,10, 0);

        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);

        search.setOnAction(e ->{
            //System.out.println(search_field.getText());
            //if search option valid
            //return search results
            //else
            //Label label = new Label();
            //label.setText("This isn't a valid search.");
        });

        back.setOnAction(e ->{
            UserHome userHome = new UserHome(visitor, lbms, stage);
            stage.getScene().setRoot(userHome.getRootPane());
            stage.setScene(userHome.getScene());
            stage.show();
        });
    }

    public Pane getRootPane() {
        return rootPane ;
    }

    public static Scene getScene() {
        return scene;
    }
}
