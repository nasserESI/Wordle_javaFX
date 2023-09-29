package alt.wordle.command;

import atl.wordle.model.Board;

/**
 *
 * @author Nasser Abattouy
 */
public class PlayTurn implements Command {

    private Board model;
    private String theWord;

    public PlayTurn(Board board, String theWord) {
        this.model = board;
        this.theWord = theWord;
    }

    @Override
    public void execute() {
        if (!this.model.isHasWon()) {
            this.model.addWord(theWord);
            this.model.checkScore(theWord);
            this.model.notifyObservers();
            this.model.setAttemptUp();
        }
    }

    @Override
    public void undo() {
        this.model.setAttemptDown();
        this.model.removeScore();
        this.model.removeWord();
        this.model.notifyObservers();
    }

    public String getTheWord() {
        return theWord;
    }

}
