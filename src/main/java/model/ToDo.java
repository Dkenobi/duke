package model;

public class ToDo extends Task{

    private String taskType;

    public ToDo(String taskType, String description){
        super(description);
        this.taskType = taskType;
    }

    public ToDo(String taskType, String description, boolean isDone){
        super(description);
        this.taskType = taskType;
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return " [" + taskType + "] [" + super.getStatusIcon() + "] "+  description;
    }

    @Override
    public String saveToFile(){
        return  taskType  + " | " + (super.isDone ? "1" : "0") +" | " +  description;
    }
}
