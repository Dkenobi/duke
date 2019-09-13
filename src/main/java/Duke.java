import exception.DukeBaseException;
import model.TaskList;
import ui.Command;
import ui.CommandInterfaceView;
import util.ConstantHelper;
import util.ReadWriteFileHelper;

/**
 * This class is the main class of the duke application which will trigger the various function base on the user input.
 *
 * @author Dillen
 * @version 0.1
 * @since 2019-08-13
 */
public class Duke {
    /**
     * The constructor of duke.
     */
    public Duke() {
    }

    /**
     * This method runs the main duke application in a loop till the exit command is executed.
     */
    public void run() {
        CommandInterfaceView cli = new CommandInterfaceView();

        TaskList taskList = new TaskList();
        new ReadWriteFileHelper().loadFile(ConstantHelper.dukeFilePath, taskList);

        cli.printWelcomeMessage();
        cli.printLine();
        boolean isExit = false;

        while (!isExit) {
            try {
                String fullCommand = cli.readCommand();
                cli.printLine();
                Command c = Parser.parse(fullCommand);
                System.out.println(c.execute(taskList, cli));
                isExit = c.isExit();
                cli.printLine();
                new ReadWriteFileHelper().saveFile(ConstantHelper.dukeFilePath, cli.saveTaskList(taskList.getTaskList()));
            } catch (DukeBaseException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * This method is where the main duke is execute to perform the task base on the input of the user.
     *
     * @param args
     */
    public static void main(String[] args) {
        new Duke().run();
    }
}