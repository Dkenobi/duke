import exception.DukeBaseException;

import model.TaskList;
import org.junit.jupiter.api.Test;
import ui.Command;
import ui.CommandInterfaceView;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ByeCommandTest {
    @Test
    void byeCommandTest() throws DukeBaseException {

        CommandInterfaceView cli = new CommandInterfaceView();
        TaskList taskList = new TaskList();

        Command c = Parser.parse("bye");
        assertEquals("Bye. Hope to see you again soon!", c.execute(taskList,cli));
    }
}
