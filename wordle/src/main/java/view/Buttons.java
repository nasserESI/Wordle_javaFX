package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Nasse
 */
public class Buttons extends GridPane {

    private Button undo;
    private Button redo;

    public Buttons() {

        setAlignment(Pos.CENTER);
        
        add(undo = new Button("UNDO"), 1, 2);
        add(redo = new Button("REDO"), 2, 2);
        setVgap(5);
        setHgap(5);
    }

    public Button getUndo() {
        return undo;
    }

    public Button getRedo() {
        return redo;
    }

   

}
