package ui;

import model.Deadlines;
import model.TaskList;

public class EventCommand extends Command {
    private String taskDescription;
    private String date;

    /**
     * This constructor takes create an instance with the task description and the date of the event.
     *
     * @param taskDescription the description of the event task.
     * @param date            the date of the event.
     */
    public EventCommand(String taskDescription, String date) {
        this.taskDescription = taskDescription;
        this.date = date;
    }

    /**
     * This method helps to create and instance if the event task.
     *
     * @param taskList the runtime Task List.
     * @param ui       the runtime of the ui elements.
     */
    @Override
    public String execute(TaskList taskList, CommandInterfaceView ui) {
        int id = taskList.addTaskToList(new Deadlines("E", taskDescription, date));
        return ui.printToDo(taskList.getTask(id).toString(), taskList.getTasksListSize());
    }
}
