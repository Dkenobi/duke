package ui;

import model.TaskList;
import model.ToDo;

public class ToDoCommand extends Command{
    private String taskDescription;

    /**
     * This constructor takes create an instance with the task description.
     * @param taskDescription the description of the todo task.
     */
    public ToDoCommand(String taskDescription){
        this.taskDescription = taskDescription;
    }

    /**
     * This method helps to create and instance if the todo task.
     * @param taskList the runtime Task List.
     * @param ui the runtime of the ui elements.
     */
    @Override
    public void execute(TaskList taskList, CommandInterfaceView ui) {
        int id = taskList.addTaskToList(new ToDo("T",taskDescription));
        ui.printToDo(taskList.getTask(id).toString(),taskList.getTasksListSize());
    }
}
