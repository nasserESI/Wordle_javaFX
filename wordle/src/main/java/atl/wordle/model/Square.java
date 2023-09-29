package atl.wordle.model;

/**
 * i have written this class in order to define what a tile of a grid is. 
 * so, a tile is composed by a letter and a color represented in that case by a 
 * "State"
 *
 * @author Nasse
 */
public class Square {

    private char letter;
    private LetterState state;

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public LetterState getState() {
        return state;
    }

    public void setState(LetterState state) {
        this.state = state;
    }

    public Square() {

        this.state = LetterState.EMPTY;
    }
}
