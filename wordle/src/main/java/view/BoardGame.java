package view;

import atl.wordle.model.Board;
import atl.wordle.model.Observable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author Nasse
 */
public class BoardGame extends GridPane implements Observer {

    private Case[][] cases = new Case[7][5];
    private int tentative=0;

    public BoardGame() {

        this.setAlignment(Pos.CENTER);
        for (int i = 0; i < this.cases[0].length; i++) {
            for (int j = 0; j < 7; j++) {
                cases[j][i] = new Case();
                this.add(cases[j][i], i,j);
                this.setHgap(10);
                this.setVgap(10);
                this.setPadding(new Insets(20));
            }
        }
        System.out.println("nombre de tentative set à :"+tentative+"dans le constructeur de board");
    }

    private void insertLetter(String mot) {
        System.out.println("index de vue : "+this.tentative);
        for (int i = 0; i < this.cases[0].length; i++) {
            this.cases[tentative][i].setChar(mot.charAt(i));
        }
    }
    private void eraseLetter(){
        //enlevé la constante
        for (int i = 0; i < this.cases[0].length; i++) {
            this.cases[tentative][i].setChar(' ');
        }
    }
    private void setToBlueCases(){
        for (int i = 0; i < this.cases[0].length; i++) {
            this.cases[tentative][i].getRectangle().setFill(Color.LIGHTBLUE);
            this.cases[tentative][i].getCercle().setFill(Color.LIGHTBLUE);
        }
    }
    public void eraseWord(){
        System.out.println("view delete ok");
        this.eraseLetter();
        this.setToBlueCases();
    }
    private void typeLetter(Board board) {
        for (int i = 0; i < this.cases[0].length; i++) {
            switch (board.getBoard()[tentative][i].getState().toString()) {
                case "GOOD_LET_POS":
                    this.cases[tentative][i].getRectangle().setFill(Color.RED);
                    this.cases[tentative][i].getCercle().setFill(Color.RED);
                    break;
                case "GOOD_LET_NO_POS":
                    this.cases[tentative][i].getCercle().setFill(Color.LIGHTSALMON);
                    this.cases[tentative][i].getRectangle().setFill(Color.LIGHTBLUE);
                    break;
                default :
                    this.cases[tentative][i].getRectangle().setFill(Color.LIGHTBLUE);
                    this.cases[tentative][i].getCercle().setFill(Color.LIGHTBLUE);
                    break;
            }
        }
    }

    @Override
    public void update(Observable observable, Object args) {
        Board mot = (Board) args;
        this.setTentative(mot.getAttempt());
        this.insertLetter(mot.getChosenWord());
        this.typeLetter(mot);
        
    }

    public int getTentative() {
        return tentative;
    }

    private void setTentative(int tentative) {
        this.tentative = tentative;
    }
    

}
