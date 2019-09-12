import model.Deadlines;
import model.Event;
import model.TaskList;
import model.ToDo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {

    @Test
    public void testGetTaskListSize(){
        TaskList taskList = new TaskList();
        taskList.addTaskToList(new ToDo("T","watch GOT"));
        taskList.addTaskToList(new Deadlines("D","Have to pick some stuff","9/10/2019"));
        taskList.addTaskToList(new Event("E","Avengers End Game","9/10/2019"));
        assertEquals(3,taskList.getTasksListSize());
    }

    @Test
    public void testGetTaskList(){
        TaskList taskList = new TaskList();
        taskList.addTaskToList(new ToDo("T","watch GOT"));
        taskList.addTaskToList(new Deadlines("D","Have to pick some stuff","9/10/2019"));
        taskList.addTaskToList(new Event("E","Avengers End Game","9/10/2019"));
        assertEquals("Avengers End Game",taskList.getTask(3).getDescription());
    }

    @Test
    public void testDeleteTaskList(){
        TaskList taskList = new TaskList();
        taskList.addTaskToList(new ToDo("T","watch GOT"));
        taskList.addTaskToList(new Deadlines("D","Have to pick some stuff","9/10/2019"));
        taskList.addTaskToList(new Event("E","Avengers End Game","9/10/2019"));
        taskList.deleteTask(3);
        assertEquals(2,taskList.getTasksListSize());
    }

    @Test
    public void testFindTaskList(){
        TaskList taskList = new TaskList();
        taskList.addTaskToList(new ToDo("T","watch GOT"));
        taskList.addTaskToList(new Deadlines("D","Have to pick some stuff","9/10/2019"));
        taskList.addTaskToList(new Event("E","Avengers End Game","9/10/2019"));

        assertEquals("\n1. [E] [✘] Avengers End Game (at: 9/10/2019)",taskList.listFoundTask("End Game"));
    }
}
