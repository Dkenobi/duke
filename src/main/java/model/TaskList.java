package model;

import java.util.ArrayList;

/**
 * The TaskList class keep a state of all the added task in the @param tasksList.
 *
 * @author Dillen
 * @version 0.1
 * @since 2019-08-13
 */
public class TaskList {

    private ArrayList<Task> tasksList;

    /**
     * Constructor of the TaskList that initialize the taskList at once instantiate.
     */
    public TaskList() {
        tasksList = new ArrayList<>();
    }

    /**
     * This method return the size of the task list.
     *
     * @param task a new task to be added into the task list.
     * @return the index of the task that was added in the task list.
     */
    public int addTaskToList(Task task) {
        tasksList.add(task);
        return tasksList.size();
    }

    /**
     * This method return the task list in ArrayList type.
     *
     * @return the task list.
     */
    public ArrayList<Task> getTaskList() {
        return this.tasksList;
    }

    /**
     * This method set a particular task to done given the id of the task.
     *
     * @param index the id of the task.
     */
    public void completeTask(int index) {
        tasksList.get(index - 1).setIsDone(true);
    }

    /**
     * The method deletes the task given the id of the task.
     *
     * @param index the id of the task.
     */
    public void deleteTask(int index) {
        tasksList.remove(index - 1);
    }

    /**
     * The method return the size of the task list.
     *
     * @return the taskList size in int.
     */
    public int getTasksListSize() {
        return tasksList.size();
    }

    /**
     * The method returns the instance of the task given the id.
     */
    public Task getTask(int id) {
        return tasksList.get(id - 1);
    }

    /**
     * This method returns the list of task found given the search query.
     *
     * @param findString the string of the query.
     * @return the list of task in string.
     */
    public String listFoundTask(String findString) {
        StringBuilder listString = new StringBuilder();
        int index = 1;
//        listString = new StringBuilder("Here are the tasks in your list.");
        for (Task task : tasksList)
            if (task.toString().contains(findString))
                listString.append("\n").append(index++).append(".").append(task.toString());

        return listString.toString();
    }

}
