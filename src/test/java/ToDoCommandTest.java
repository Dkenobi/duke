import exception.DukeBaseException;
import exception.DukeException;
import model.TaskList;
import org.junit.jupiter.api.Test;
import ui.Command;
import ui.CommandInterfaceView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ToDoCommandTest {

    String output = "Got it. I've added this task: \n" +
            " [T] [✘] to watch GOT\n" +
            "Now you have 1 tasks in the list.";
    @Test
    public void testToDoCommand() throws DukeBaseException {

        CommandInterfaceView cli = new CommandInterfaceView();
        TaskList taskList = new TaskList();
        Command c;
        c = Parser.parse("todo to watch GOT");
        assertEquals(output, c.execute(taskList,cli));
    }

    @Test
    public void testToDoCommandException(){

        CommandInterfaceView cli = new CommandInterfaceView();
        TaskList taskList = new TaskList();
        Command c;

        try {
            c = Parser.parse("todo");
            assertEquals(output, c.execute(taskList,cli));
            fail();
        }
        catch (Exception e){
            assertEquals(new DukeException.ToDoExceptionDuke().getMessage(), e.getMessage());
        }
    }

    @Test
    public void testInvalidCommandException(){

        CommandInterfaceView cli = new CommandInterfaceView();
        TaskList taskList = new TaskList();
        Command c;

        try {
            c = Parser.parse("t0do to watch GOT");
            assertEquals(output, c.execute(taskList,cli));
            fail();
        }
        catch (Exception e){
            assertEquals(new DukeException.WrongCommandException().getMessage(), e.getMessage());
        }
    }
}
