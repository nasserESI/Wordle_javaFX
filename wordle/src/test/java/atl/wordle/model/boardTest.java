package atl.wordle.model;


import atl.wordle.model.Board;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
/**
 *
 * @author Nasse
 */
public class boardTest {
     private Board board;

    @BeforeEach     // Exécutée avant chaque test
    public void setUp() throws IOException {
        board = new Board();
    }
    
    @Test
    public void isTooShort() {
        String word = "abc";
        assertThrows(IllegalArgumentException.class,
                () -> board.addWord(word), "word too short or too wide");
    }
    @Test
    public void isTooWide() {
        String word = "abcdezaaa";
        assertThrows(IllegalArgumentException.class,
                () -> board.addWord(word), "word too short or too wide");
    }
    @Test
    public void wordDoesntExist() {
        String word = "abcdd";
        assertThrows(IllegalArgumentException.class,
                () -> board.addWord(word.toUpperCase()), "the word doesn't exist....");
    }
    @Test
    public void goodWord() { 
        this.board.checkScore(this.board.getHiddenWord());
        assertTrue(this.board.getScore()==10);
    }
    @Test
    public void hasWonThusTrue() { 
        this.board.checkScore(this.board.getHiddenWord());
        assertTrue(this.board.isHasWon()==true);
    }  
}
