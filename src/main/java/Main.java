import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String input;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Duke duke = new Duke();
        duke.printWelcomeMessage();

        while(!(input = reader.readLine()).isEmpty()) {
            if (input.equals("bye")){
                duke.echo("Bye. Hope to see you again soon!");
                System.exit(0);
            }
            else
                duke.echo(input);
        }
    }
}