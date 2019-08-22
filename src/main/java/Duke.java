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
    }

    private static void printLine() {
        System.out.println("____________________________________________________________");
    }

    public void enterCommand(String string) {
        String[] splited = string.split("\\s+");

        switch(splited[0])
        {
            case "bye": bye();
                break;
            case "list": getTasksList();
                break;
            case "done": doneTask(Integer.parseInt(splited[1]));
            break;
            default:
                addToList(string);
        }
    }

    private void bye() {
        printLine();
        echo("Bye. Hope to see you again soon!");
        printLine();
        System.exit(0);
    }

    private void echo(String message){
        System.out.println(message);
    }

    private void addToList(String message) {
        printLine();
        tasksList.add(new Task(message));
        echo("added: " + message);
        printLine();
    }

    private void getTasksList(){
        int index = 1;
        printLine();
        echo("Here are the tasks in your list. ");
        for (var task: tasksList){
            echo(index++ + ". [" + task.getStatusIcon() + "] " + task.description);
        }
        printLine();
    }

    private void doneTask(int index) {
        int zeroIndex = index - 1;
        printLine();
        tasksList.get(zeroIndex).isDone = true;
        echo("Nice I've marked this task as done: \n" + " [" + tasksList.get(zeroIndex).getStatusIcon() + "] " + tasksList.get(zeroIndex).description);
        printLine();
    }

}
