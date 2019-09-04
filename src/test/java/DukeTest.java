//import model.TaskList;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;
//class DukeTest {
//
//    String dukeAddedString = "added: ";
//
//    @Test
//    void testByeCommand(){
//        assertEquals("Bye. Hope to see you again soon!", Duke.enterCommand(new TaskList(),"bye"));
//    }
//
//    @Test
//    void testInputCommand(){
//        assertEquals(dukeAddedString + "Read book", Duke.enterCommand(new TaskList(),"Read book"));
//    }
//
//    @Test
//    void testListCommand(){
//        String duekeTestList = "Here are the tasks in your list." +
//                "\n1. [✘] read book" +
//                "\n2. [✘] watch GOT";
//
//        String dukeDoneList = "Nice I've marked this task as done: \n" +
//                "[✓] watch GOT";
//
//        TaskList taskList = new TaskList();
//
//        Duke.enterCommand(taskList,"read book");
//        Duke.enterCommand(taskList,"watch GOT");
//        assertEquals(duekeTestList, Duke.enterCommand(taskList,"list"));
//        assertEquals(dukeDoneList, Duke.enterCommand(taskList,"done 2"));
//    }
//}