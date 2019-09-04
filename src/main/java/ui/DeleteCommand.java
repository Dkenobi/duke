package ui;

import model.TaskList;

public class DeleteCommand extends Command{
    private int taskId;

    public DeleteCommand(int taskId){
        this.taskId = taskId;
    }
    @Override
    public void execute(TaskList taskList, CommandInterfaceView ui) {
        ui.printDeleteTask(taskList,taskId);
    }
}
