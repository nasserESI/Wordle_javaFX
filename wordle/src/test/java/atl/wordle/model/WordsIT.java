/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atl.wordle.model;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nasse
 */
public class WordsIT {
    
    public WordsIT() {
    }
    
    @BeforeEach
    public void setUp() {
    }

    /**
     * Test of getListWords method, of class Words.
     */
    @Test
    public void testGetListWords() throws IOException {
        System.out.println("getListWords");
        Words instance = new Words();
        ArrayList<String> expResult = new ArrayList();
        ArrayList<String> result = instance.getListWords();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSize method, of class Words.
     */
    @Test
    public void testGetSize() throws IOException {
        System.out.println("getSize");
        Words instance = new Words();
        Words expResult = new Words();
        int result = instance.getSize();
        assertEquals(expResult.getSize(),instance.getSize());
    }

    
}
