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

    public ArrayList<Task> getTaskList(){
        return this.tasksList;
    }

    public void completedTask(int index) {
        tasksList.get(index - 1).setIsDone(true);
    }
    public int getTasksListSize(){
        return tasksList.size();
    }

    public Task getTask(int id){
        return tasksList.get(id - 1);
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
