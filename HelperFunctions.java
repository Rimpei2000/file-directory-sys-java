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
}
