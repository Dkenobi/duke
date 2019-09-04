package ui;

import model.TaskList;
import model.ToDo;

public class ToDoCommand extends Command{
    private String taskDescription;

    public ToDoCommand(String taskDescription){
        this.taskDescription = taskDescription;
    }

    @Override
    public void execute(TaskList taskList, CommandInterfaceView ui) {
        int id = taskList.addTaskToList(new ToDo("T",taskDescription));
        ui.printToDo(taskList.getTask(id).toString(),taskList.getTasksListSize());
    }
}
