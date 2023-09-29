package view;

import atl.wordle.model.Observable;
import java.util.ArrayList;

/**
 * An Observer object in the Observer/Observable pattern.
 * Essentially presents an update method which permits the Observable 
 * to notify it of any changes.
 * 
 * @author Frédéric Servais
 */
public interface Observer {
 
    /**
     * This method is called whenever the observed object has changed.
     */
    void update(Observable observable,Object args);
    
}
