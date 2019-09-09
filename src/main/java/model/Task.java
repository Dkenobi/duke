package model;
import java.util.List;

/**
 * The user of this interface have control on how each method are handled.
 * This interface give the user a guideline of the required method to be implemented in the sub-class.
 */

public interface Task {
    /**
     * This method is used to set the Task status of the task.
     * @param isDone a value that the Task is completed/not completed.
     */
    public void setIsDone(boolean isDone);

    /**
     * The method retrieve the status of the Task.
     * @return the Icon in string format of the status of the task.
     */
    public String getStatusIcon();

    /**
     * This method will retrieve the description of the Task.
     * @return the description that describe the task.
     */
    public String getDescription();

    /**
     * This method will be used to convert the relevant Task description into a
     * formatted text to save in a text file.
     * @return the format for the text file.
     */
    public String saveToFile();
}
