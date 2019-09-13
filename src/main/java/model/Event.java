package model;

/**
 * The Event class that keeps the information about the added Event task.
 * Which implement the method of the Task Interface.
 *
 * @author Dillen
 * @version 0.1
 * @since 2019-08-13
 */
public class Event implements Task {

    private String description;
    private boolean isDone;
    private String taskType;
    private String date;

    /**
     * Constructor of the Event Task.
     *
     * @param taskType    a initial that describe the task.
     * @param description a String that describe the task.
     */
    public Event(String taskType, String description, String date) {
        this.description = description;
        this.isDone = false;
        this.taskType = taskType;
        this.date = date;
    }

    /**
     * Another Constructor that take in a extra argument.
     *
     * @param taskType    a initial that describe the task.
     * @param description a String that describe the task.
     * @param isDone      a boolean that describe the current state of the Task to be created.
     */
    public Event(String taskType, String description, String date, boolean isDone) {
        this.description = description;
        this.taskType = taskType;
        this.date = date;
        this.isDone = isDone;
    }

    /**
     * This method return the information about the current state of the Event Task.
     *
     * @return the String format of the Event Task.
     */
    @Override
    public String toString() {
        return " [" + taskType + "] [" + getStatusIcon() + "] " + description +
                " (at: " + date + ")";
    }

    /**
     * This method set the completion of the Task.
     *
     * @param isDone a value that the Task is completed/not completed.
     */
    @Override
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * {@inheritDoc}
     *
     * @return the status of the task in unicode format.
     */
    @Override
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * {@inheritDoc}
     *
     * @return the description of the Event task.
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * {@inheritDoc}
     *
     * @return a String format to save in the text file of the Event task.
     */
    @Override
    public String saveToFile() {
        return taskType + " | " + (isDone ? "1" : "0") + " | " + description + " | " + date;
    }
}
