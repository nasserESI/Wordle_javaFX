package atl.wordle.main;

import view.Observer;
import view.View;
import atl.wordle.model.Board;
import controler.Controler;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * this main classe is the one which setup the frame and the containers 
 * in order to not miss any component.it is also here that we can get the control
 * @author Nasse
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    /**
     * 
     * @param stage the stage is the window. this object is a ready-to-use object 
     * in order to makes windowses in our programmes.
     * @throws Exception
     * @throws FileNotFoundException 
     */
    @Override
    public void start(Stage stage) throws Exception,FileNotFoundException {
        stage.setTitle("Wordle Nasser Abattouy");
        stage.setMinWidth(450);
        stage.setMinHeight(300);       
        
        Board board = new Board();
        
        View vue = new View(board);
        Controler control = new Controler(vue,board);
        vue.getBoard().boutonsAction(control);
        vue.setAlignment(Pos.CENTER);
        board.addObserver((Observer) vue);
        Scene scene = new Scene(vue);
        System.out.println(board.getHiddenWord());
        stage.setScene(scene);
        
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
    }

}
