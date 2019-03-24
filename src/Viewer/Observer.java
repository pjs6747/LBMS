package Viewer;

import javafx.scene.layout.GridPane;
import java.awt.*;
import java.util.ArrayList;

public class Observer extends Button implements controller.Observer{

    private GridPane grid;
    private ArrayList list_of_grids = new ArrayList();

    @Override
    public void update(Object pushValue) {

    }
}
