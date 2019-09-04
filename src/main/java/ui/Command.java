package ui;

import expection.DukeException;
import model.TaskList;

public abstract class Command {
    protected boolean isExit;

    public boolean isExit() {
        return this.isExit;
    }

    abstract public void execute(TaskList taskList,CommandInterfaceView ui);
}
