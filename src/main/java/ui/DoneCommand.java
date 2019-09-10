package ui;

import model.TaskList;

public class DoneCommand extends Command{
    private int taskId;
    /**
     * This constructor takes create an instance of the task id.
     * @param taskId the id of the task.
     */
    public DoneCommand(int taskId){
        this.taskId = taskId;
    }

    /**
     * This method help to set the Task to completed.
     * @param taskList the runtime Task List.
     * @param ui the runtime of the ui elements.
     */
    @Override
    public void execute(TaskList taskList, CommandInterfaceView ui) {
        ui.printCompleteTask(taskList,taskId);
    }
}
