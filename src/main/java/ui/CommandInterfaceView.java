package ui;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class CommandInterfaceView {

    private Scanner scanner;
    public CommandInterfaceView () {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Method to call when Duke is started.
     */
    public String readCommand() {
        return this.scanner.nextLine();
    }

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

    public void printLine() {
        System.out.println("____________________________________________________________");
    }

    public void bye() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void printTaskList(ArrayList<Task> tasksList) {
        StringBuilder listString;
        int index = 1;

        listString = new StringBuilder("Here are the tasks in your list.");
        for (var task: tasksList){
            listString.append("\n").append(index++).append(".").append(task.toString());
        }
        System.out.println(listString);
    }

    public void  printCompleteTask(TaskList taskList, int taskId){
        taskList.completeTask(taskId);

        System.out.println( "Nice I've marked this task as done: \n"
                + "[" + taskList.getTask(taskId).getStatusIcon() + "] "
                + taskList.getTask(taskId).getDescription());
    }

    public void printDeleteTask(TaskList taskList, int taskId){
        String removedTask = taskList.getTask(taskId).toString();
        taskList.deleteTask(taskId);

        System.out.println( "Noted. I've removed this task: \n"
                + removedTask
                + "\nNow you have "
                + taskList.getTasksListSize()
                +" tasks in the list.");
    }

    public ArrayList<String> saveTaskList(ArrayList<Task> taskList){
        ArrayList<String> tasksSaveAsList = new ArrayList<>();;
        //Find out if can cover ArrayList<Task> to ArrayList<String>
        for(Task a: taskList)
            tasksSaveAsList.add(a.saveToFile());
        return tasksSaveAsList;
    }

    public void printFoundList(String foundListString){
        System.out.println("Here are the tasks in your list."
                + foundListString);

    }

    public void printToDo(String task, int sizeOfTaskList){
        System.out.println("Got it. I've added this task: \n"
                + task + "\nNow you have " + sizeOfTaskList + " tasks in the list.");
    }
}
