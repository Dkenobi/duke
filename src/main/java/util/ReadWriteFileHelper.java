package util;

import model.TaskList;

import model.Deadlines;
import model.Event;
import model.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The ReadWriteFileHelper class helps to save the current state of the current Task ArrayList and
 * load the text file into the Task ArrayList at runtime.
 */
public class ReadWriteFileHelper {
    /**
     * This method help to load the previously saved Task ArrayList and help to retain the state from the previous runtime.
     * @param fullPath the directory of the save Task ArrayList text file.
     * @param taskList the current runtime of the TaskList which the save state will be loaded into it.
     */
    public void loadFile(String fullPath, TaskList taskList) {
        try {
            Scanner s = new Scanner(new File(fullPath));

            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] splitLine = line.split(" \\| ");

                switch(splitLine[0]){
                    case "T":
                        taskList.addTaskToList(new ToDo(splitLine[0],splitLine[2],splitLine[1].equals("1")));
                        break;
                    case "D":
                        taskList.addTaskToList(new Deadlines(splitLine[0],splitLine[2],splitLine[3],splitLine[1].equals("1")));
                        break;
                    case "E":
                        taskList.addTaskToList(new Event(splitLine[0],splitLine[2],splitLine[3],splitLine[1].equals("1")));
                        break;
                    default:
                        break;
                }
            }
            System.out.println("Lists successfully loaded.");
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
    }

    /**
     * This method save the TaskList in a text file when executed.
     * @param fullPath the directory of the save Task ArrayList text file.
     * @param taskList the String format of the current state of the taskList.
     */
    public void saveFile(String fullPath, ArrayList<String> taskList) {
        try{
            Path file = Paths.get(fullPath);
            Files.write(file, taskList, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
