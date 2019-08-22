public class Duke {

    public Duke(){

    }

    public void printWelcomeMessage(){
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

    public void echo(String string){
        System.out.println(string);
        printLine();
    }
}
