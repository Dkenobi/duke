import exception.DukeBaseException;
import model.TaskList;
import org.junit.jupiter.api.Test;
import ui.Command;
import ui.CommandInterfaceView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListCommandTest {
    @Test
    void listCommandTest() throws DukeBaseException {

        String output = "Here are the tasks in your list.\n" +
                "1. [T] [✘] to watch GOT\n" +
                "2. [D] [✘] return Table (by: 2nd of December 2019 6 pm)\n" +
                "3. [E] [✘] project meeting (by: Mon 2-4pm)";

        CommandInterfaceView cli = new CommandInterfaceView();
        TaskList taskList = new TaskList();
        Command c;
        c = Parser.parse("todo to watch GOT");
        c.execute(taskList,cli);
        c = Parser.parse("deadline return Table /by 2/12/2019 1800");
        c.execute(taskList,cli);
        c = Parser.parse("event project meeting /at Mon 2-4pm");
        c.execute(taskList,cli);
        c = Parser.parse("list");
        assertEquals(output, c.execute(taskList,cli));
    }
}
