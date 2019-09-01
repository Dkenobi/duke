package model;

import util.ConstantHelper;
import util.ReadWriteFileHelper;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> tasksList;
    private ArrayList<String> tasksSaveAsList;

    public TaskList(){
        tasksList = new ArrayList<>();
        tasksSaveAsList = new ArrayList<>();;
    }

    public int addTaskToList(Task task){
        tasksList.add(task);
        tasksSaveAsList.add(task.saveToFile());
        new ReadWriteFileHelper().saveFile(ConstantHelper.dukeFilePath,tasksSaveAsList);
        return tasksList.size() - 1;
    }

    public String getTaskList(){
        StringBuilder listString;
        int index = 1;

        listString = new StringBuilder("Here are the tasks in your list.");
        for (var task: tasksList){
            listString.append("\n").append(index++).append(".").append(task.toString());
        }
        return listString.toString();
    }

    public String completeTask(int index) {
        int zeroIndex = index - 1;

        tasksList.get(zeroIndex).setIsDone(true);
        return "Nice I've marked this task as done: \n"
                + "[" + tasksList.get(zeroIndex).getStatusIcon() + "] "
                + tasksList.get(zeroIndex).getDescription();
    }
    public int getListSize(){
        return tasksList.size();
    }

    public Task getTask(int id){
        return tasksList.get(id);
    }

    public ArrayList<String> asList(){
        return tasksSaveAsList;
    }

    public String deleteTask(int num){
        int index = num - 1;
        String removedTask = tasksSaveAsList.get(index);
        tasksList.remove(index);
        tasksSaveAsList.remove(index);
        return "Noted. I've removed this task: \n"
                + removedTask + "\nNow you have "+ tasksList.size() +" tasks in the list.";
    }
}
