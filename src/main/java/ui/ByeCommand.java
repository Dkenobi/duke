package ui;

import model.TaskList;

public class ByeCommand extends Command{
    /**
     * When the bye command is instantiated the isExit is set to true to allow the program to exit.
     */
    public ByeCommand (){
        this.isExit = true;
    }

    /**
     * This method execute the ui bye method.
     * @param taskList the runtime Task List.
     * @param ui the runtime of the ui elements.
     */
    @Override
    public void execute(TaskList taskList, CommandInterfaceView ui) {
        ui.bye();
    }
}
