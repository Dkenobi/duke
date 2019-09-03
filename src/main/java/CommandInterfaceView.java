import expection.DukeBaseException;
import expection.DukeException;
import model.*;
import util.ConstantHelper;
import util.DateTimeHelper;
import util.ReadWriteFileHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class CommandInterfaceView {

    public CommandInterfaceView () {
    }

    /**
     * Method to call when View model is started.
     */
    public void start() throws IOException {
        String input;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TaskList taskList = new TaskList();
        new ReadWriteFileHelper().loadFile(ConstantHelper.dukeFilePath,taskList);

        printWelcomeMessage();
        while(!(input = reader.readLine()).isEmpty()) {
            printLine();
            try {
                System.out.println(enterCommand(taskList, input));
                new  ReadWriteFileHelper().saveFile(ConstantHelper.dukeFilePath,saveTaskList(taskList.getTaskList()));
            }
            catch (DukeBaseException e){
                System.out.println(e.getMessage());
            }
            printLine();
        }
    }

    private void printWelcomeMessage()  {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println(logo);
        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?");
        printLine();
    }

    private void printLine() {
        System.out.println("____________________________________________________________");
    }

    private String enterCommand(TaskList taskList, String input) throws DukeBaseException {
        String[] splitString = input.split("\\s+",2);

        switch(splitString[0])
        {
            case "bye":
                System.out.print(bye());
                System.exit(0);
            case "list": return printTaskList(taskList.getTaskList());
            case "done": return completeTask(taskList,Integer.parseInt(splitString[1]));
            case "delete": return deleteTask(taskList,Integer.parseInt(splitString[1]));
            case "find": return taskList.listFoundTask(splitString[1]);
            default:
                return addTaskToList(taskList,input);
        }
    }

    private String bye() {
        return "Bye. Hope to see you again soon!\n";
    }

    private String addTaskToList(TaskList taskList, String message) throws DukeBaseException {

        int id;
        String[] splitString = message.split("\\s+");
        ArrayList<String> descriptionArgs = new ArrayList<>(Arrays.asList(splitString));
        descriptionArgs.remove(0);
        String description = String.join(" ",descriptionArgs);

        String pattern = "dd/MM/yyyy HHmm";
        DateFormat df = new SimpleDateFormat(pattern);

        switch(splitString[0])
        {
            case "todo":
                if (description.equals(""))
                    throw new DukeException.ToDoExceptionDuke();
                id = taskList.addTaskToList(new ToDo("T",description));
                return "Got it. I've added this task: \n"
                        + taskList.getTask(id).toString()
                        + "\nNow you have " + taskList.getTasksListSize() +" tasks in the list.";

            case "deadline":
                if (description.equals(""))
                    throw new DukeException.DeadlineException();
                String[] splitByBy = description.split(" /by ");
                id = taskList.addTaskToList(new Deadlines("D",splitByBy[0],new DateTimeHelper().getFormattedDate(splitByBy[1])));
                return "Got it. I've added this task: \n"
                        + taskList.getTask(id).toString()
                        + "\nNow you have " + taskList.getTasksListSize() +" tasks in the list.";

            case "event":
                if (description.equals(""))
                    throw new DukeException.EventException();
                String[] splitByAt = description.split(" /at ");
                id = taskList.addTaskToList(new Event("E", splitByAt[0],new DateTimeHelper().getFormattedDate(splitByAt[1])));
                return "Got it. I've added this task: \n"
                        + taskList.getTask(id).toString()
                        + "\nNow you have " + taskList.getTasksListSize() +" tasks in the list.";

            default:
                throw new DukeException.WrongCommandException();
        }
    }

    private String printTaskList(ArrayList<Task> tasksList) {
        StringBuilder listString;
        int index = 1;

        listString = new StringBuilder("Here are the tasks in your list.");
        for (var task: tasksList){
            listString.append("\n").append(index++).append(".").append(task.toString());
        }

        return listString.toString();
    }

    private String completeTask(TaskList taskList, int taskId){
        taskList.completeTask(taskId);

        return "Nice I've marked this task as done: \n"
                + "[" + taskList.getTask(taskId).getStatusIcon() + "] "
                + taskList.getTask(taskId).getDescription();
    }

    private String deleteTask(TaskList taskList, int taskId){
        String removedTask = taskList.getTask(taskId).toString();
        taskList.deleteTask(taskId);

        return "Noted. I've removed this task: \n"
                + removedTask
                + "\nNow you have "
                + taskList.getTasksListSize()
                +" tasks in the list.";
    }

    private ArrayList<String> saveTaskList(ArrayList<Task> taskList){
        ArrayList<String> tasksSaveAsList = new ArrayList<>();;
        //Find out if can cover ArrayList<Task> to ArrayList<String>
        for(Task a: taskList)
            tasksSaveAsList.add(a.saveToFile());

        return tasksSaveAsList;
    }
}
