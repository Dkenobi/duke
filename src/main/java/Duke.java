import java.util.ArrayList;
import java.util.List;

public class Duke {
    private List<Task> tasksList;

    public Duke(){
        tasksList  = new ArrayList<Task>();
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
        printLine();
    }

    public void printLine() {
        System.out.println("____________________________________________________________");
    }

    public String enterCommand(String input) {
        String[] splitString = input.split("\\s+");

        switch(splitString[0])
        {
            case "bye": return bye();
            case "list": return getTasksList();
            case "done": return doneTask(Integer.parseInt(splitString[1]));
            default:
                return addTaskToList(input);
        }
    }

    private String bye() {
        return "Bye. Hope to see you again soon!";
    }

    private String addTaskToList(String message) {
        tasksList.add(new Task(message));
        return "added: " + message;
    }

    private String getTasksList(){
        String listString;
        int index = 1;

        listString = "Here are the tasks in your list.";
        for (var task: tasksList){
            listString += "\n"+ index++ + ". [" + task.getStatusIcon() + "] " + task.description;
        }
        return listString;
    }

    private String doneTask(int index) {
        int zeroIndex = index - 1;

        tasksList.get(zeroIndex).isDone = true;
        return "Nice I've marked this task as done: \n"
                + "[" + tasksList.get(zeroIndex).getStatusIcon() + "] "
                + tasksList.get(zeroIndex).description;
    }
}
