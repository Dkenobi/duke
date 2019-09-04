package exception;

public class DukeException {

    public static class ToDoExceptionDuke extends DukeBaseException {
        public ToDoExceptionDuke() {
            super("\u2639 OOPS!!! The description of a todo cannot be empty.");
        }
    }

    public static class DeadlineException extends DukeBaseException{
        public DeadlineException() {
            super("\u2639 OOPS!!! The description of a deadline cannot be empty.");
        }
    }

    public static class EventException extends DukeBaseException{
        public EventException() {
            super("\u2639 OOPS!!! The description of a deadline cannot be empty.");
        }
    }

    public static class WrongCommandException extends DukeBaseException{
        public WrongCommandException() {
            super("\u2639 OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
