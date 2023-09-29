package controler;

import alt.wordle.command.Command;
import alt.wordle.command.PlayTurn;
import view.View;
import atl.wordle.model.Board;

/**
 *
 * @author Nasse
 */
public class Controler {

    private View vue;
    private Board model;
    private Command command;

    public Controler(View vue, Board model) {
        this.vue = vue;
        this.model = model;
    }

    public void winningWord(String mot) {
        if (!this.getModel().isHasWon()) {
            command = new PlayTurn(this.model, mot);
            this.command.execute();
        }

    }

    public void undo() {
        if (this.getModel().getAttempt() > 0) {
            command = new PlayTurn(this.model, null);
            this.command.undo();
        }
        
    }

    public void redo() {
        command = new PlayTurn(this.model, null);
        
    }

    public View getVue() {
        return vue;
    }

    public Board getModel() {
        return model;
    }
}
