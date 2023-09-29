package alt.wordle.command;

/**
 * this is the interface used to implement our only command
 * @author Nasse
 */
public interface Command {
    /**
     * Executes the command
     */
    public void execute();
    /**
     *  get back one step earlier
     */
    public void undo();
}

