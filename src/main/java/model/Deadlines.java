package model;

public class Deadlines extends Task{
    private String taskType;
    private String date;

    public Deadlines(String description,String taskType, String date ){
        super(description);
        this.taskType = taskType;
        this.date = date;
    }

    @Override
    public String toString(){
        return " " + taskType + " [" + super.getStatusIcon() + "] "+  description +
                "(by: " + date + ")";
    }
}
