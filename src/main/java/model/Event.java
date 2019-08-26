package model;

public class Event extends  Task {
    private String taskType;
    private String date;

    public Event(String description,String taskType, String date ){
        super(description);
        this.taskType = taskType;
        this.date = date;
    }

    @Override
    public String toString(){
        return " " + taskType + " [" + super.getStatusIcon() + "] "+  description +
                "(at: " + date + ")";
    }
}
