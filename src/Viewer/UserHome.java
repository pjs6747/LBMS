package Viewer;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.LBMS;
import model.Transaction;
import model.Visitor;
import java.util.ArrayList;

public class UserHome {
    private final BorderPane rootPane ; // or any other kind of pane, or  Group...
    Scene scene;
    Stage stage;
    LBMS lbms;
    Visitor visitor;

    public UserHome(Visitor visitor, LBMS lbms, Stage stage) {
        rootPane = new BorderPane();
        this.stage = stage;
        this.lbms = lbms;
        this.visitor =visitor;

        // build UI, register event handlers, etc etc
        scene = new Scene(new Group(), 450, 250);
        Button search = new Button("SEARCH!");
        Button logOut = new Button("log out!");
        Label welcome = new Label();
        Label fine = new Label();
        Label borrowed_books = new Label();
        welcome.setText("WELCOME " + visitor.getFirstName());
        fine.setText("You owe: $" + visitor.getBalance());
        borrowed_books.setText("Books you have out:");
        ArrayList<Label> transactions = new ArrayList();
        for (Transaction transaction: visitor.getTransactions()){
            Label trans = new Label();
            String book = transaction.getBook().getTitle() + "by: " + transaction.getBook().getAuthor() + "due: " + transaction.getDueBack();
            trans.setText(book);
            transactions.add(trans);
        }

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(welcome, 3, 0);
        grid.add(search,5, 0);
        grid.add(logOut,0, 0);
        grid.add(fine, 0, 2);
        grid.add(borrowed_books, 0, 3);
        int i = 4;
        for(Label trans: transactions){
            grid.add(trans, 1, i);
            i++;
        }

        search.setOnAction(e ->{
            searchPage search_bttn = new searchPage(visitor, lbms, stage);
            stage.getScene().setRoot(search_bttn.getRootPane());
            stage.setScene(search_bttn.getScene());
            stage.show();
        });

        logOut.setOnAction(e ->{
            lbms.endVisit(visitor.getID());
            LoginPage loginPage = new LoginPage(lbms, stage);
            stage.getScene().setRoot(loginPage.getRootPane());
            stage.setScene(loginPage.getScene());
            stage.show();
        });

        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
    }


    public Pane getRootPane() {
        return rootPane ;
    }

    public Scene getScene() {
        return scene;
    }
}
