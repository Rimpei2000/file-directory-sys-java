import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileSystemTree tree = new FileSystemTree();

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("user@recursionist: ");
            String input = scanner.nextLine();
            HelperFunctions.conductCommand(input, tree);
        }
        
        
    }
}
