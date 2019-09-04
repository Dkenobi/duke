import expection.DukeBaseException;
import model.TaskList;
import ui.Command;
import ui.CommandInterfaceView;
import util.ConstantHelper;
import util.ReadWriteFileHelper;

public class Duke {
    public static void main(String[] args) {

        CommandInterfaceView cli = new CommandInterfaceView();

        TaskList taskList = new TaskList();
        new ReadWriteFileHelper().loadFile(ConstantHelper.dukeFilePath,taskList);

        cli.printWelcomeMessage();
        cli.printLine();
        boolean isExit = false;

        while(!isExit) {
            try {
                String fullCommand = cli.readCommand();
                cli.printLine();
                Command c = Parser.parse(fullCommand);
                c.execute(taskList,cli);
                isExit = c.isExit();
                cli.printLine();
//                new  ReadWriteFileHelper().saveFile(ConstantHelper.dukeFilePath,saveTaskList(taskList.getTaskList()));
            }
            catch (DukeBaseException e){
                System.out.println(e.getMessage());
            }
        }
    }
}