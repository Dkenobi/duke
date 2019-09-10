package ui;

import model.TaskList;

public class FindCommand extends Command{
    private String findString;

    public FindCommand(String findString) {
        this.findString = findString;
    }

    /**
     * This method helps to execute the listFroundTask method from TaskList and
     * and help print out the found task from the queried string.
     * @param taskList the runtime Task List.
     * @param ui the runtime of the ui elements.
     */
    @Override
    public void execute(TaskList taskList, CommandInterfaceView ui) {
        ui.printFoundList(taskList.listFoundTask(findString));
    }
}
