import exception.DukeBaseException;
import exception.DukeException;
import ui.*;
import util.DateTimeHelper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Parser class help to determine the action along with the the additional argument to
 * determine the command to execute.
 *
 * @author Dillen
 * @version 0.1
 * @since 2019-08-13
 */
public class Parser {
    /**
     * This method determine the command to be execute base on the input given
     * @param fullCommand the user input at runtime.
     * @return the action to be executed base on the input given.
     * @throws DukeBaseException throws and error when a wrong command is entered.
     */
    public static Command parse(String fullCommand) throws DukeBaseException {
        String[] splitString = fullCommand.split("\\s+", 2);

        switch (splitString[0]) {
            case "bye":
                return new ByeCommand();
            case "list":
                return new ListCommand();
            case "done":
                return new DoneCommand(Integer.parseInt(splitString[1]));
            case "delete":
                return new DeleteCommand(Integer.parseInt(splitString[1]));
            case "find":
                return new FindCommand(splitString[1]);
            default:
                return addTaskToList(fullCommand);

        }
    }

    /**
     * Similar to the above function however, this function only handle the various task
     * to be executed.
     * @param message the input after the command
     * @return the action to be executed base on the input given.
     * @throws DukeBaseException throws and error if missing information is entered.
     */
    private static Command addTaskToList(String message) throws DukeBaseException {
        String[] splitString = message.split("\\s+");
        ArrayList<String> descriptionArgs = new ArrayList<>(Arrays.asList(splitString));
        descriptionArgs.remove(0);
        String description = String.join(" ", descriptionArgs);

        switch (splitString[0]) {
            case "todo":
                if (description.equals(""))
                    throw new DukeException.ToDoExceptionDuke();
                return new ToDoCommand(description);
            case "deadline":
                if (description.equals(""))
                    throw new DukeException.DeadlineException();
                String[] splitByBy = description.split(" /by ");
                return new DeadlineCommand(splitByBy[0], new DateTimeHelper().getFormattedDate(splitByBy[1]));
            case "event":
                if (description.equals(""))
                    throw new DukeException.EventException();
                String[] splitByAt = description.split(" /at ");
                return new EventCommand(splitByAt[0], new DateTimeHelper().getFormattedDate(splitByAt[1]));
            default:
                throw new DukeException.WrongCommandException();
        }
    }
}
