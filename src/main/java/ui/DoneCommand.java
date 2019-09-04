package ui;

import model.TaskList;

public class DoneCommand extends Command{
    private int taskId;

    public DoneCommand(int taskId){
        this.taskId = taskId;
    }

    @Override
    public void execute(TaskList taskList, CommandInterfaceView ui) {
        ui.printCompleteTask(taskList,taskId);
    }
}
