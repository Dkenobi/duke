import model.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Duke {
    public static void main(String[] args) throws IOException {
        String input;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        TaskList taskList = new TaskList();
        printWelcomeMessage();

        while(!(input = reader.readLine()).isEmpty()) {
            printLine();
            System.out.println(enterCommand(taskList,input));
            printLine();

            if (input.equals("bye"))
                System.exit(0);
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

    public static String enterCommand(TaskList taskList, String input) {
        String[] splitString = input.split("\\s+");

        switch(splitString[0])
        {
            case "bye": return bye();
            case "list": return taskList.getTaskList();
            case "done": return taskList.completeTask(Integer.parseInt(splitString[1]));
            default:
                return addTaskToList(taskList,input);
        }
    }

    public static String bye() {
        return "Bye. Hope to see you again soon!";
    }

    private static String addTaskToList(TaskList taskList, String message) {
        taskList.addTaskToList(new Task(message));
        return "added: " + message;
    }

}