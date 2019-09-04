package ui;

import model.TaskList;

public class ByeCommand extends Command{
    public ByeCommand (){
        this.isExit = true;
    }

    @Override
    public void execute(TaskList taskList, CommandInterfaceView ui) {
        ui.bye();
    }
}
