package atl.wordle.model;

import view.Observer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * this class is our facade class build for Observable purposes
 *
 * @author Nasser Abattouy
 */
public class Board implements Observable {

    //this is the board makes with letters and enumeration which matches with the color.
    private Square[][] board = new Square[7][5];
    //the hiddenWord is the word that the player need to guess.
    private String hiddenWord;
    // chosenWord is the input of the player until the next one.
    // it means that if we undo an input, we need to setup back the last word recorded
    private String chosenWord = null;
    // words is an object from a class build for the good of the dictionary datas
    private Words words;
    // this attribut count how many times we try to guess
    private int attempt;
    //the total amount of points scored by the user
    private int score;

    //private History history;
    private List<Observer> observers = new ArrayList<>();
    // says if the player/user has won or not yet.
    private boolean hasWon;

    public Board() throws IOException {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Square();
            }
        }
        words = new Words();

        this.attempt = 0;

        this.setRandomWord();
    }

    /**
     * get score
     *
     * @return an integer as a score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * this methode is made to get a random word to guess
     */
    private void setRandomWord() {
        int IndexHiddenWord = (int) (Math.random() * (words.getSize() - 1)) + 1;
        this.setHiddenWord(words.getListWords().get(IndexHiddenWord));
    }

    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    /**
     * this methode is set for the opposite process of the game. it removes the
     * words already displayed. even if we have won. it goes before you won, for
     * exemple
     */
    public void removeWord() {

        this.setHasWon(false);

        for (int i = 0; i < this.getHiddenWord().length(); i++) {
            this.setChosenWord(this.getChosenWord().replace(this.chosenWord.charAt(i), ' '));
            this.getBoard()[this.getAttempt()][i].setState(LetterState.EMPTY);
        }
        System.out.println("|" + this.chosenWord + "|");

    }

    public void setScore(int score) {
        this.score += score;
    }

    /**
     * it make a subtraction in order to get the previous total amout of points
     * granted.
     */
    public void removeScore() {
        Integer calculationSum = 0;
        if (!this.getWords().getListWords().contains(this.getChosenWord())) {
            calculationSum -= 1;
        } else {
            for (int i = 0; i < this.getBoard()[this.getAttempt()].length; i++) {
                String lettre = "" + this.getChosenWord().charAt(i);
                if (this.getBoard()[this.getAttempt()][i].getLetter() == this.getHiddenWord().charAt(i)) {
                    calculationSum += 2;
                } else if ((this.getBoard()[this.getAttempt()][i].getLetter() != this.getHiddenWord().charAt(i)) && this.getHiddenWord().contains(lettre)) {
                    calculationSum += 1;
                }
                lettre = null;
            }
        }
        this.score = this.score - calculationSum;
    }

    /**
     * this methode gives the opportunity to moves back in the game an thus, to
     * undo
     */
    public void setAttemptDown() {
        this.attempt--;
    }

    /**
     * this methods helps the games to go trought the steps
     */
    public void setAttemptUp() {
        this.attempt++;
    }

    /**
     * addWord is a methode set to put each lettter into the board
     *
     * @param mot : the specified word written by the player
     */
    public void addWord(String playedWord) {
        if (playedWord.length() > this.getHiddenWord().length() || playedWord.length() < this.getHiddenWord().length()) {
            throw new IllegalArgumentException("word too short or too wide");
        }
        if (!this.getWords().getListWords().contains(playedWord)) {
            throw new IllegalArgumentException("the word doesn't exist....");
        }
        for (int i = 0; i < this.getHiddenWord().length(); i++) {
            this.getBoard()[this.getAttempt()][i].setLetter(playedWord.charAt(i));
        }
        this.setChosenWord(playedWord);
    }

    private void setChosenWord(String chosenWord) {
        this.chosenWord = chosenWord.toUpperCase();
    }

    /**
     * this Setter helps us to change the state of the game. the player keep
     * going with the game only if it stays on "false". othwerwise it is true,
     * and the game stops
     *
     * @param hasWon boolean to know if we win or not
     */
    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    /**
     * this methods make a calculation i order to know how many points has the
     * user won in totals
     *
     * @param playedWord the word played by the user(the input)
     */
    public void checkScore(String playedWord) {
        Integer calculationSum = 0;
        if (playedWord.length() != 5 || !this.getWords().getListWords().contains(playedWord)) {
            calculationSum -= 1;
        } else {
            for (int i = 0; i < playedWord.length(); i++) {
                String lettre = "" + playedWord.charAt(i);
                if (playedWord.charAt(i) == this.getHiddenWord().charAt(i)) {
                    this.getBoard()[this.getAttempt()][i].setState(LetterState.GOOD_LET_POS);
                    calculationSum += 2;
                } else if ((playedWord.charAt(i) != this.getHiddenWord().charAt(i)) && this.getHiddenWord().contains(lettre)) {
                    this.getBoard()[this.getAttempt()][i].setState(LetterState.GOOD_LET_NO_POS);
                    calculationSum += 1;
                }
                lettre = null;
            }
        }
        if(calculationSum == 10){
            this.setHasWon(true); 
        }
        this.setScore(calculationSum);
    }

    /**
     * this getter shows if the game is finish or not.
     *
     * @return true if the game is stopped of false if we keep going.
     */
    public boolean isHasWon() {
        return hasWon;
    }

    /**
     * this methodes gives à string which is the current chosen word.
     *
     * @return the last chosen word
     */
    public String getChosenWord() {
        return chosenWord;
    }

    /**
     * gives the numbers of attempts
     *
     * @return an integer between 0 and 6
     */
    public int getAttempt() {
        return attempt;
    }

    /**
     * this methods gives the board game with a letter in each tile
     *
     * @return a 2D array with a letter and a letter state for each case
     */
    public Square[][] getBoard() {
        return board;
    }

    /**
     * this getter gives the hiddenWord to guess. obviously : for a programming
     * purpose
     *
     * @return a string with is the mysterious words
     */
    public String getHiddenWord() {
        return hiddenWord;
    }

    public Words getWords() {
        return words;
    }
//    /**
//     * this methodes conforms if the words match with the hiddenword in order to
//     * stop the game
//     * @param word
//     * @return 
//     */
//    public boolean isTheGoodWord(String word) {
//        return this.getHiddenWord().toString().equals(word.toString());
//    }

    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(view.Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this, this);
        }
    }

}
