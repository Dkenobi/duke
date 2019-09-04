package ui;

import model.TaskList;

public class FindCommand extends Command{
    private String findString;

    public FindCommand(String findString) {
        this.findString = findString;
    }

    @Override
    public void execute(TaskList taskList, CommandInterfaceView ui) {
        ui.printFoundList(taskList.listFoundTask(findString));
    }
}
