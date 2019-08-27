package model;

public class Event extends  Task {
    private String taskType;
    private String date;

    public Event(String taskType, String description, String date ){
        super(description);
        this.taskType = taskType;
        this.date = date;
    }

    public Event(String taskType, String description, String date, boolean isDone ){
        super(description);
        this.taskType = taskType;
        this.date = date;
        this.isDone = isDone;
    }

    @Override
    public String toString(){
        return " [" + taskType + "] [" + super.getStatusIcon() + "] "+  description +
                " (at: " + date + ")";
    }

    @Override
    public String saveToFile(){
        return  taskType  + " | " + (super.isDone ? "1" : "0") +" | " +  description + " | " + date;
    }
}
