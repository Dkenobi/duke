package ui;

import model.TaskList;

public class ListCommand extends Command{
    /**
     * This method helps to list out the current task in the ArrayList.
     * @param taskList the runtime Task List.
     * @param ui the runtime of the ui elements.
     */
    @Override
    public String execute(TaskList taskList, CommandInterfaceView ui) {
        return ui.printTaskList(taskList.getTaskList());
    }
}
