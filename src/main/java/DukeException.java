public class DukeException {

    public static class ToDoExceptionDuke extends DukeBaseException {
        public ToDoExceptionDuke() {
            super("☹ OOPS!!! The description of a todo cannot be empty.");
        }
    }

    public static class DeadlineException extends DukeBaseException{
        public DeadlineException() {
            super("☹ OOPS!!! The description of a deadline cannot be empty.");
        }
    }

    public static class EventException extends DukeBaseException{
        public EventException() {
            super("☹ OOPS!!! The description of a deadline cannot be empty.");
        }
    }

    public static class WrongCommandException extends DukeBaseException{
        public WrongCommandException() {
            super("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
