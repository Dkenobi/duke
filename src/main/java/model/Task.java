package model;

public interface Task {

    public void setIsDone(boolean isDone);

    public String getStatusIcon();

    public String getDescription();

    public String saveToFile();
}
