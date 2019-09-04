package model;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> tasksList;

    public TaskList(){
        tasksList = new ArrayList<>();
    }

    public int addTaskToList(Task task){
        tasksList.add(task);
        return tasksList.size();
    }

    public ArrayList<Task> getTaskList(){
        return this.tasksList;
    }

    public void completeTask(int index) {
        tasksList.get(index - 1).setIsDone(true);
    }

    public void deleteTask(int index){
        tasksList.remove(index - 1);
    }

    public int getTasksListSize(){
        return tasksList.size();
    }

    public Task getTask(int id){
        return tasksList.get(id - 1);
    }

    public String listFoundTask(String findString) {
        StringBuilder listString = new StringBuilder();
        int index = 1;
//        listString = new StringBuilder("Here are the tasks in your list.");
        for(Task task: tasksList)
            if(task.toString().contains(findString))
                listString.append("\n").append(index++).append(".").append(task.toString());

        return listString.toString();
    }

}
