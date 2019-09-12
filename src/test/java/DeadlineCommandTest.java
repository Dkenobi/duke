import exception.DukeBaseException;
import model.TaskList;
import org.junit.jupiter.api.Test;
import ui.Command;
import ui.CommandInterfaceView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineCommandTest {
    @Test
    public void testDeadlineCommand() throws DukeBaseException {

        String output = "Got it. I've added this task: \n" +
                " [D] [✘] return Table (by: 2nd of December 2019 6 pm)\n" +
                "Now you have 1 tasks in the list.";

        CommandInterfaceView cli = new CommandInterfaceView();
        TaskList taskList = new TaskList();
        Command c;
        c = Parser.parse("deadline return Table /by 2/12/2019 1800");
        assertEquals(output, c.execute(taskList,cli));
    }
}
