import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Duke {
    public static void main(String[] args) throws IOException {

        String name;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        printLine();
        printWelcomeMessage();
        printLine();

        while(!(name = reader.readLine()).isEmpty()) {
            if (name.equals("bye")){
                echo("Bye. Hope to see you again soon!");
                System.exit(0);
            }
            else
                echo(name);
        }
    }
    private static void printWelcomeMessage(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println(logo);
        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?");
    }

    private static void printLine(){
        System.out.println("____________________________________________________________");
    }

    private static void echo(String string){
        System.out.println(string);
        printLine();
    }
}
