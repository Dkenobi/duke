import exception.DukeBaseException;
import model.TaskList;
import org.junit.jupiter.api.Test;
import ui.Command;
import ui.CommandInterfaceView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteCommandTest {
    @Test
    void deleteCommandTest() throws DukeBaseException {

        String output  = "Noted. I've removed this task: \n" +
                " [T] [✘] to watch GOT\n" +
                "Now you have 0 tasks in the list.";

        CommandInterfaceView cli = new CommandInterfaceView();
        TaskList taskList = new TaskList();
        Command c;
        c = Parser.parse("todo to watch GOT");
        c.execute(taskList,cli);
        c = Parser.parse("delete 1");
        assertEquals(output, c.execute(taskList,cli));
    }
}
