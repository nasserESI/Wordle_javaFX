package alt.wordle.command;

import java.util.Stack;

/**
 * this class is the one which has the command but also the background of the game
 * @author Nasse
 */
public class CommandManager {
    /**
     * undoStack : the stacke with the previous command
     * and the datas.
     */
    private final Stack<Command> undoStack = new Stack<>();
    /**
     * redoStack : the stacke with the commands repeated
     * and the datas.
     */
    private final Stack<Command> redoStack = new Stack<>();
   /**
     * execute the command
     *
     * @param command the command to execute
     */
    public void execute(Command command) {

        if (command == null) {
            throw new IllegalArgumentException("the command must be not null");
        }

        command.execute();

        undoStack.add(command);
        redoStack.clear();
    }

    /**
     * this methods get one step back
     */
    public void undo() {

        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();

            redoStack.add(command);
        }
    }

    /**
     * this methode does the previpus command again
     */
    public void redo() {

        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();

            undoStack.add(command);
        }
    }
}
 
  
