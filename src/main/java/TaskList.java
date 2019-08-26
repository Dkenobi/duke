import model.Task;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> tasksList;

    public TaskList(){
        tasksList = new ArrayList<>();
    }

    public void addTaskToList(Task task){
        tasksList.add(task);
    }

    public String getTaskList(){
        StringBuilder listString;
        int index = 1;

        listString = new StringBuilder("Here are the tasks in your list.");
        for (var task: tasksList){
            listString.append("\n").append(index++).append(". [").append(task.getStatusIcon()).append("] ").append(task.getDescription());
        }
        return listString.toString();
    }
}
