import exception.DukeBaseException;
import model.TaskList;
import org.junit.jupiter.api.Test;
import ui.Command;
import ui.CommandInterfaceView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindCommandTest {
    @Test
    void findCommandTest() throws DukeBaseException {

        String output = "Here are the matching tasks in your list:\n" +
                "1. [T] [✘] to watch GOT";

        CommandInterfaceView cli = new CommandInterfaceView();
        TaskList taskList = new TaskList();
        Command c;
        c = Parser.parse("todo to watch GOT");
        c.execute(taskList,cli);
        c = Parser.parse("deadline return Table /by 2/12/2019 1800");
        c.execute(taskList,cli);
        c = Parser.parse("event project meeting /at Mon 2-4pm");
        c.execute(taskList,cli);
        c = Parser.parse("find watch");
        assertEquals(output, c.execute(taskList,cli));
    }
}
