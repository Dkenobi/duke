package model;

public class Deadlines implements Task{

    private String description;
    private boolean isDone;
    private String taskType;
    private String date;

    public Deadlines(String taskType, String description, String date ){
        this.description = description;
        this.isDone = false;
        this.taskType = taskType;
        this.date = date;
    }

    public Deadlines(String taskType, String description, String date,boolean isDone ){
        this.description = description;
        this.taskType = taskType;
        this.date = date;
        this.isDone = isDone;
    }

    @Override
    public String toString(){
        return " [" + taskType + "] [" + getStatusIcon() + "] "+  description +
                " (by: " + date + ")";
    }

    @Override
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String saveToFile(){
        return  taskType  + " | " + (isDone ? "1" : "0") +" | " +  description + " | " + date;
    }
}
