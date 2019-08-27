import expection.DukeBaseException;
import expection.DukeException;
import model.Deadlines;
import model.Event;
import model.ToDo;
import util.ConstantHelper;
import util.DateTimeHelper;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Duke {
    public static void main(String[] args) throws IOException {
        String input;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TaskList taskList = new TaskList();
        new ReadWriteUtility().loadFile(ConstantHelper.dukeFilePath,taskList);

        printWelcomeMessage();
        while(!(input = reader.readLine()).isEmpty()) {
            printLine();
            try {
                System.out.println(enterCommand(taskList, input));
            }
            catch (DukeBaseException e){
                System.out.println(e.getMessage());
            }
            printLine();
        }
    }

    public static void printWelcomeMessage()  {
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

    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    public static String enterCommand(TaskList taskList, String input) throws DukeBaseException {
        String[] splitString = input.split("\\s+");

        switch(splitString[0])
        {
            case "bye":
                System.out.print(bye());
                System.exit(0);
            case "list": return taskList.getTaskList();
            case "done": return taskList.completeTask(Integer.parseInt(splitString[1]));
            default:
                return addTaskToList(taskList,input);
        }
    }

    public static String bye() {
        return "Bye. Hope to see you again soon!";
    }

    private static String addTaskToList(TaskList taskList, String message) throws DukeBaseException {

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
                        + "\nNow you have " + taskList.getListSize() +" tasks in the list.";

            case "deadline":
                if (description.equals(""))
                    throw new DukeException.DeadlineException();
                String[] splitByBy = description.split("/by ");
                id = taskList.addTaskToList(new Deadlines("D",splitByBy[0],new DateTimeHelper().getFormattedDate(splitByBy[1])));
                return "Got it. I've added this task: \n"
                        + taskList.getTask(id).toString()
                        + "\nNow you have " + taskList.getListSize() +" tasks in the list.";

            case "event":
                if (description.equals(""))
                    throw new DukeException.EventException();
                String[] splitByAt = description.split("/at ");
                id = taskList.addTaskToList(new Event("E", splitByAt[0],new DateTimeHelper().getFormattedDate(splitByAt[1])));
                return "Got it. I've added this task: \n"
                        + taskList.getTask(id).toString()
                        + "\nNow you have " + taskList.getListSize() +" tasks in the list.";

            default:
                throw new DukeException.WrongCommandException();
        }
    }
}