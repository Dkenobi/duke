package model;

public class Event implements Task {

    private String description;
    private boolean isDone;
    private String taskType;
    private String date;

    public Event(String taskType, String description, String date ){
        this.description = description;
        this.isDone = false;
        this.taskType = taskType;
        this.date = date;
    }

    public Event(String taskType, String description, String date, boolean isDone ){
        this.description = description;
        this.taskType = taskType;
        this.date = date;
        this.isDone = isDone;
    }

    @Override
    public String toString(){
        return " [" + taskType + "] [" + getStatusIcon() + "] "+  description +
                " (at: " + date + ")";
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
