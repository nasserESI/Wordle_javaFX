package view;

import atl.wordle.model.Board;
import atl.wordle.model.Observable;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

/**
 *
 * @author Nasse
 */
public class ListWord extends VBox implements Observer {

    private int score = 0;
    private ListView<String> myListView;
    private Label scoreLabel;
    private Label displayAttempt;

    public ListWord(ArrayList<String> list1) {
        myListView = new ListView();
        myListView.getItems().addAll(list1);
        this.getChildren().add(myListView);
        this.scoreLabel = new Label(" le score est de : " + this.score);
        this.getChildren().add(this.scoreLabel);
        this.displayAttempt = new Label("le nombre de tentatives est de : 0");
        this.getChildren().add(this.displayAttempt);
        this.setSpacing(10);
        this.setMaxSize(250, 900);
        this.setAlignment(Pos.CENTER);

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ListView<String> getMyListView() {
        return myListView;
    }

    public void setDisplayAttempt(int numberOfAttempt) {
        this.displayAttempt.setText(numberOfAttempt + " tentatives");
    }

    public void setMyListView(ArrayList<String> myListView) {
        this.myListView.getItems().addAll(myListView);
    }


    @Override
    public void update(Observable observable, Object args) {
        var board = (Board) args;
        this.getMyListView().getItems().addAll(board.getWords().getListWords());
        int score = board.getScore();
        this.getScoreLabel().setText(" le score est de : " + board.getScore());
        this.getDisplayAttempt().setText("tentative numéro : " + board.getAttempt());

    }

    public Label getDisplayAttempt() {
        return displayAttempt;
    }

    public Label getScoreLabel() {
        return scoreLabel;
    }
    
}
