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
        if (arr.length == 2) {
            tree.touch(arr[1]);
        } else if (arr.length == 3) {
            tree.touchPath(arr[1], arr[2]);
        } else {
            HelperFunctions.appendError("touch");
        }
    }

    public static void mkdir(String[] arr, FileSystemTree tree) {
        if (arr.length == 2) {
            tree.mkdir(arr[1]);
        } else if (arr.length == 3) {
            tree.mkdirPath(arr[1], arr[2]);
        } else {
            HelperFunctions.appendError("mkdir");
        }
    }

    public static void ls(String[] arr, FileSystemTree tree) {
        if (arr.length == 1) {
            System.out.println(tree.ls());
        } else if (arr.length == 2 && arr[1].equals("-a")) {
            System.out.println(tree.lsAll());
        } else if (arr.length == 2 && arr[1].equals("-r")) {
            System.out.println(tree.lsReverse());
        } else if (arr.length == 2) {
            System.out.println(tree.lsChild(arr[1]));
        }
    }

    public static void cd(String[] arr, FileSystemTree tree) {
        if (arr.length != 2) {
            HelperFunctions.appendError("cd");
        } else {
            tree.cd(arr[1]);
        }
    }

    public static void pwd(String[] arr, FileSystemTree tree) {
        if (arr.length != 1) {
            HelperFunctions.appendError("pwd");
        } else {
            System.out.println(tree.pwd());
        }
    }

    public static void print(String[] arr, FileSystemTree tree) {
        if (arr.length != 2) {
            HelperFunctions.appendError("print");
        } else {
            System.out.println(tree.print(arr[1]));
        }
    }

    public static void setContent(String[] arr, FileSystemTree tree) {
        if (arr.length != 3) {
            HelperFunctions.appendError("setContent");
        } else {
            tree.setContent(arr[1], arr[2]);
        }
    }

    public static void rm(String[] arr, FileSystemTree tree) {
        if (arr.length != 2) {
            HelperFunctions.appendError("rm");
        } else {
            tree.rm(arr[1]);
        }
    }

    // public static void move(String[] arr, FileSystemTree tree) {
    //     System.out.println("Move");
    // }

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
        // } else if (commandArray[0].equals("move")) {
        //     HelperFunctions.move(commandArray, tree);
        } else {
            HelperFunctions.appendError("command");
        }
    }
}
