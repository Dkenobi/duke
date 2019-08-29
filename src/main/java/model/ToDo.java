package model;

public class ToDo implements Task {

    private String description;
    private boolean isDone;
    private String taskType;

    public ToDo(String taskType, String description){
        this.description = description;
        this.taskType = taskType;
        this.isDone = false;
    }

    public ToDo(String taskType, String description, boolean isDone){
        this.description = description;
        this.taskType = taskType;
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return " [" + taskType + "] [" + getStatusIcon() + "] "+  description;
    }

    @Override
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String saveToFile(){
        return  taskType  + " | " + (isDone ? "1" : "0") +" | " +  description;
    }
}
