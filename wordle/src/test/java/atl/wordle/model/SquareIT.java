
package atl.wordle.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nasse
 */
public class SquareIT {
    private Square square;
    public SquareIT() {
        this.square = new Square();
    }
  
    @BeforeEach
    public void setUp() {
          this.square = new Square();
    }
    

    /**
     * Test of getLetter method, of class Square.
     */
    @Test
    public void testGetLetter() {
        System.out.println("getLetter");
        Square instance = new Square();
        char expResult = 0;
        char result = instance.getLetter();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setLetter method, of class Square.
     */
    @Test
    public void testSetLetter() {
        System.out.println("setLetter");
        char letter = ' ';
        Square instance = new Square();
        instance.setLetter(letter);
    }

    /**
     * Test of getState method, of class Square.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Square instance = new Square();
        LetterState expResult = LetterState.EMPTY;
        LetterState result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of setState method, of class Square.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        LetterState state = null;
        Square instance = new Square();
        instance.setState(state);
    }
    
}
