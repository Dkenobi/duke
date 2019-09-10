package ui;

import model.TaskList;

/**
 * The user of this abstract class have to implement the abstract method .
 *
 * @author Dillen
 * @version 0.1
 * @since 2019-08-13
 */
public abstract class Command {
    protected boolean isExit;

    /**
     * This method return the boolean exit value of the command to determine to quit
     * the program.
     *
     * @return the boolean value of isExit.
     */
    public boolean isExit() {
        return this.isExit;
    }

    /**
     * Accept the reference value of TaskLists and CommandInterfaceView and allow the
     * implementer to execute the correct method for each different commands.
     *
     * @param taskList the runtime Task List.
     * @param ui the runtime of the ui elements.
     */
    abstract public String execute(TaskList taskList,CommandInterfaceView ui);
}
