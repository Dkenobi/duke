import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
class DukeTest {

    String dukeAddedString = "added: ";
    
    @Test
    void testByeCommand(){
        Duke dukeTest = new Duke();
        assertEquals("Bye. Hope to see you again soon!", dukeTest.enterCommand("bye"));
    }

    @Test
    void testInputCommand(){
        Duke dukeTest = new Duke();
        assertEquals(dukeAddedString + "Read book", dukeTest.enterCommand("Read book"));
    }

    @Test
    void testListCommand(){
        String duekeTestList = "Here are the tasks in your list." +
                "\n1. [✘] read book" +
                "\n2. [✘] watch GOT";

        String dukeDoneList = "Nice I've marked this task as done: \n" +
                "[✓] watch GOT";

        Duke dukeTest = new Duke();
        dukeTest.enterCommand("read book");
        dukeTest.enterCommand("watch GOT");
        assertEquals(duekeTestList, dukeTest.enterCommand("list"));
        assertEquals(dukeDoneList, dukeTest.enterCommand("done 2"));
    }


}