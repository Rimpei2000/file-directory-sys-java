public class HelperFunctions {
    public static String appendError(String errorType) {
        String msg = "";
        if (errorType.equals("command")) {
            msg = "invalid input. Commands are 'cd','print','rm', 'pwd', 'ls' 'mkdir', 'touch, move'";
        } else if (errorType.equals("sameName")) {
            msg = "you already have the file or directory.";
        }
        return msg;
    }

    public static void touch(String[] arr, FileSystemTree tree) {
        System.out.println("touch");
    }

    public static void mkdir(String[] arr, FileSystemTree tree) {
        System.out.println("mkdir");
    }

    public static void ls(String[] arr, FileSystemTree tree) {
        System.out.println("ls");
    }

    public static void cd(String[] arr, FileSystemTree tree) {
        System.out.println("cd");
    }

    public static void pwd(String[] arr, FileSystemTree tree) {
        System.out.println("pwd");
    }

    public static void print(String[] arr, FileSystemTree tree) {
        System.out.println("print");
    }

    public static void setContent(String[] arr, FileSystemTree tree) {
        System.out.println("setContent");
    }

    public static void rm(String[] arr, FileSystemTree tree) {
        System.out.println("rm");
    }

    public static void move(String[] arr, FileSystemTree tree) {
        System.out.println("Move");
    }

    public static void conductCommand(String command, FileSystemTree tree) {
        String[] commandArray = command.split(" ");
        if (commandArray.length == 0) {
            HelperFunctions.appendError("command");
        } else if (commandArray[0].equals("touch")) {
            HelperFunctions.touch(commandArray, tree);
        } else if (commandArray[0].equals("mkdir")) {
            HelperFunctions.mkdir(commandArray, tree);
        } else if (commandArray[0].equals("ls")) {
            HelperFunctions.ls(commandArray, tree);
        } else if (commandArray[0].equals("cd")) {
            HelperFunctions.cd(commandArray, tree);
        } else if (commandArray[0].equals("pwd")) {
            HelperFunctions.pwd(commandArray, tree);
        } else if (commandArray[0].equals("print")) {
            HelperFunctions.print(commandArray, tree);
        } else if (commandArray[0].equals("setContent")) {
            HelperFunctions.setContent(commandArray, tree);
        } else if (commandArray[0].equals("rm")) {
            HelperFunctions.rm(commandArray, tree);
        } else if (commandArray[0].equals("move")) {
            HelperFunctions.move(commandArray, tree);
        } else {
            HelperFunctions.appendError("command");
        }
    }
}
