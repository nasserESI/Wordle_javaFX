
package atl.wordle.model;

/**
 * this enumeration is done to code the true colors of the tiles of the windows.
 * @author Nasse
 */
public enum LetterState {
    ///good letter into the good position
    GOOD_LET_POS,
    //good letter in the wroug position
    GOOD_LET_NO_POS,
    // that might be empty of a wrong letter
    EMPTY
    
}
