public class DukeBaseException extends Exception{

    private String message;

    public DukeBaseException(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }
}
