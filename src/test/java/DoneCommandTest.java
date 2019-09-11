import exception.DukeBaseException;
import model.TaskList;
import org.junit.jupiter.api.Test;
import ui.Command;
import ui.CommandInterfaceView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoneCommandTest {
    @Test
    void doneCommandTest() throws DukeBaseException {

        String output = "Nice I've marked this task as done: \n" +
                "[✓] to watch GOT";

        CommandInterfaceView cli = new CommandInterfaceView();
        TaskList taskList = new TaskList();
        Command c;
        c = Parser.parse("todo to watch GOT");
        c.execute(taskList,cli);
        c = Parser.parse("done 1");
        assertEquals(output, c.execute(taskList,cli));
    }
}
