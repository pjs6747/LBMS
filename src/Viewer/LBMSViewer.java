package Viewer;

//import controller.BattleShip;

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

    @Override
    public void update(Book pushValue) {
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
