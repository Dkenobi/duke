public class Duke {
    public static void main(String[] args) {
        printLine();
        printWelcomeMessage();
        printLine();
    }
    private static void printWelcomeMessage(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println(logo);
        System.out.println("Hello! I'm Duke\n" +
                "What can I do for you?");
    }

    private static void printLine(){
        System.out.println("____________________________________________________________");
    }
}
