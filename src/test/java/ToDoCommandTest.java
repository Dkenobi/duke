import exception.DukeBaseException;
import model.TaskList;
import org.junit.jupiter.api.Test;
import ui.Command;
import ui.CommandInterfaceView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoCommandTest {
    @Test
    public void testToDoCommandtest() throws DukeBaseException {

        String output = "Got it. I've added this task: \n" +
                " [T] [✘] to watch GOT\n" +
                "Now you have 1 tasks in the list.";

        CommandInterfaceView cli = new CommandInterfaceView();
        TaskList taskList = new TaskList();
        Command c;
        c = Parser.parse("todo to watch GOT");
        assertEquals(output, c.execute(taskList,cli));
    }
}
