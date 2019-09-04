package ui;

import model.Deadlines;
import model.TaskList;

public class DeadlineCommand extends Command{
    private String taskDescription;
    private String date;

    public DeadlineCommand(String taskDescription, String date) {
        this.taskDescription = taskDescription;
        this.date = date;
    }

    @Override
    public void execute(TaskList taskList, CommandInterfaceView ui) {
        int id = taskList.addTaskToList(new Deadlines("D",taskDescription,date));
        ui.printToDo(taskList.getTask(id).toString(),taskList.getTasksListSize());
    }
}