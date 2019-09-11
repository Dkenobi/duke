import exception.DukeBaseException;
import model.TaskList;
import org.junit.jupiter.api.Test;
import ui.Command;
import ui.CommandInterfaceView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventCommandTest {
    @Test
    void eventCommandTest() throws DukeBaseException {

        String output = "Got it. I've added this task: \n" +
                " [E] [✘] project meeting (by: Mon 2-4pm)\n" +
                "Now you have 1 tasks in the list.";

        CommandInterfaceView cli = new CommandInterfaceView();
        TaskList taskList = new TaskList();
        Command c;
        c = Parser.parse("event project meeting /at Mon 2-4pm");
        assertEquals(output, c.execute(taskList,cli));
    }
}
