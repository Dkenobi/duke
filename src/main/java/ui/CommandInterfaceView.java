package ui;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class handle the UI element of the Duke application with various
 * method tie to specific command executed
 */
public class CommandInterfaceView {

    private Scanner scanner;
    public CommandInterfaceView () {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Method to read  the user input when Duke is started.
     */
    public String readCommand() {
        return this.scanner.nextLine();
    }

    /**
     * This method handle the initial message of the application.
     */
    public void printWelcomeMessage()  {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println(logo);
        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?");
    }

    /**
     * This method prints a line separator.
     */
    public void printLine() {
        System.out.println("____________________________________________________________");
    }

    /**
     * This method handle the ui of the bye command.
     */
    public String bye() {
       return "Bye. Hope to see you again soon!";
    }
    /**
     * This method handle the ui of the list command.
     */
    public String printTaskList(ArrayList<Task> tasksList) {
        StringBuilder listString;
        int index = 1;

        listString = new StringBuilder("Here are the tasks in your list.");
        for (var task: tasksList){
            listString.append("\n").append(index++).append(".").append(task.toString());
        }
        return listString.toString();
    }

    /**
     * This method handles the ui of the completed task command.
     * @param taskList the runtime task list
     * @param taskId the id of the task
     */
    public String  printCompleteTask(TaskList taskList, int taskId){
        taskList.completeTask(taskId);

        return "Nice I've marked this task as done: \n"
                + "[" + taskList.getTask(taskId).getStatusIcon() + "] "
                + taskList.getTask(taskId).getDescription();
    }

    /**
     * This method handle the ui of the deleted task command.
     * @param taskList the runtime task list
     * @param taskId the id of the task
     */
    public String printDeleteTask(TaskList taskList, int taskId){
        String removedTask = taskList.getTask(taskId).toString();
        taskList.deleteTask(taskId);

        return "Noted. I've removed this task: \n"
                + removedTask
                + "\nNow you have "
                + taskList.getTasksListSize()
                +" tasks in the list.";
    }

    /**
     * This method prepare the format to save the current stat me of the Task List
     * into the text file.
     * @param taskList the Task List in array list format.
     * @return a a formatted ArrayList<String>
     */
    public ArrayList<String> saveTaskList(ArrayList<Task> taskList){
        ArrayList<String> tasksSaveAsList = new ArrayList<>();;
        //Find out if can cover ArrayList<Task> to ArrayList<String>
        for(Task a: taskList)
            tasksSaveAsList.add(a.saveToFile());
        return tasksSaveAsList;
    }

    /**
     * This method handles the ui of the find command.
     * @param foundListString the query input from the user.
     */
    public String printFoundList(String foundListString){
        return "Here are the matching tasks in your list:"
                + foundListString;
    }

    /**
     * This method handles the ui of the newly added task.
     * @param task is the task information.
     * @param sizeOfTaskList the current size of the task to determine the index position
     *                       when printed out
     */
    public String printToDo(String task, int sizeOfTaskList){
        return "Got it. I've added this task: \n"
                + task + "\nNow you have " + sizeOfTaskList + " tasks in the list.";
    }
}
