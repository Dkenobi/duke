package ui;

import model.Deadlines;
import model.TaskList;


public class DeadlineCommand extends Command{
    private String taskDescription;
    private String date;

    /**
     * This constructor takes create an instance with the task description and the date to be completed.
     * @param taskDescription the description of the deadline task.
     * @param date the date which the deadline tasks has to be completed.
     */
    public DeadlineCommand(String taskDescription, String date) {
        this.taskDescription = taskDescription;
        this.date = date;
    }

    /**
     * This method helps to create and instance if the deadline task.
     * @param taskList the runtime Task List.
     * @param ui the runtime of the ui elements.
     */
    @Override
    public String execute(TaskList taskList, CommandInterfaceView ui) {
        int id = taskList.addTaskToList(new Deadlines("D",taskDescription,date));
        return ui.printToDo(taskList.getTask(id).toString(),taskList.getTasksListSize());
    }
}
