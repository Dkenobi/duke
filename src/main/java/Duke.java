import java.util.ArrayList;
import java.util.List;

public class Duke {
    private List<String> tasksList;

    public Duke(){
        tasksList  = new ArrayList<String>();
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
        switch(string)
        {
            case "bye": bye();
                break;
            case "list": getTasksList();
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
        tasksList.add(message);
        echo("added: " + message);
        printLine();
    }

    private void getTasksList(){
        int index = 1;
        printLine();
        for(var x: tasksList){
            echo(index++ + ". " + x);
        }
        printLine();
    }

}
