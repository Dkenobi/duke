package ui;

import model.TaskList;

public class DeleteCommand extends Command{
    private int taskId;


    public DeleteCommand(int taskId){
        this.taskId = taskId;
    }

    /**
     * This method help to delete the task by execute the the deleteTask method from TaskList.
     * @param taskList the runtime Task List.
     * @param ui the runtime of the ui elements.
     */
    //Need to reimplement this method again.
    @Override
    public String execute(TaskList taskList, CommandInterfaceView ui) {
        return ui.printDeleteTask(taskList,taskId);
    }
}
