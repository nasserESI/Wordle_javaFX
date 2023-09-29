package view;

import alt.wordle.command.CommandManager;
import alt.wordle.command.PlayTurn;
import atl.wordle.model.Board;
import controler.Controler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import javafx.scene.layout.VBox;

/**
 *
 * @author Nasse
 */
public class BoardGameNText extends VBox {

    private BoardGame board;
    private Buttons butons;
    private TextField trial;
    private CommandManager command;

    public BoardGameNText(Board list) {
        Label title = new Label("bienvenue à Wordle ! \n"+"entrez un mot de 5 lettre");
        title.setStyle("-fx-font-size: 20pt;");
        title.setAlignment(Pos.CENTER);
        this.getChildren().add(title);

        board = new BoardGame();
        this.getChildren().add(board);

        trial = new TextField();
        this.getChildren().add(trial);

        butons = new Buttons();
        butons.setHgap(10);
        butons.setAlignment(Pos.CENTER);
        this.getChildren().add(butons);

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(40));
        command = new CommandManager();
    }

    public BoardGame getBoardTiles() {
        return board;
    }

    public Buttons getButons() {
        return butons;
    }

    public TextField getTrial() {
        return trial;
    }

    public void boutonsAction(Controler control) {
        setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                this.command.execute(new PlayTurn(control.getModel(), this.getTrial().getText().toUpperCase()));
                getTrial().setText(null);
            }
        });
        this.butons.getUndo().setOnAction(eh -> {
            this.command.undo();
        });
        this.butons.getRedo().setOnAction(eh -> {
            this.command.redo();
        });

    }

}
