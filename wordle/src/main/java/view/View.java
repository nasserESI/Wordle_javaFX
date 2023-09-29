package view;

import atl.wordle.model.Board;
import atl.wordle.model.Observable;
import controler.Controler;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 *
 *
 * @author Nasse
 */
public class View extends StackPane implements Observer {

    private BoardGameNText board;
    private ListWordBox list;

    public View(Board list1) throws IOException {
        InputStream stream = new FileInputStream("src/resources/font.jpg");
        Image image = new Image(stream);
        ImageView vue = new ImageView(image);
        vue.fitWidthProperty().bind(this.widthProperty());
        vue.fitHeightProperty().bind(this.heightProperty());
        this.getChildren().add(vue);

        GridPane unionTwoPieces = new GridPane();
        board = new BoardGameNText(list1);
        unionTwoPieces.add(board, 0, 0);
        list = new ListWordBox(list1.getWords().getListWords());
        unionTwoPieces.add(list, 1, 0);
        this.getChildren().add(unionTwoPieces);

        board.setAlignment(Pos.CENTER);
        list.setAlignment(Pos.CENTER);
    }

    public BoardGameNText getBoard() {
        return board;
    }

    public ListWordBox getList() {
        return list;
    }


    public String getInput() {
        return getBoard().getTrial().getText().toUpperCase();
    }

    

    @Override
    public void update(Observable observable, Object args) {
        getList().getList().update(observable, args);
        getBoard().getBoardTiles().update(observable, args);
    }

}
