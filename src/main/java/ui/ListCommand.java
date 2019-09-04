package ui;

import model.TaskList;

public class ListCommand extends Command{
    @Override
    public void execute(TaskList taskList, CommandInterfaceView ui) {
        ui.printTaskList(taskList.getTaskList());
    }
}
