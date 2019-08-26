package model;

public class ToDo extends Task{

    private String taskType;

    public ToDo(String description, String taskType){
        super(description);
        this.taskType = taskType;
    }

    @Override
    public String toString() {
        return " " + taskType + " [" + super.getStatusIcon() + "] "+  description;
    }
}
