public class FileSystemTree {
    public Node root;
    public Node current;

    public FileSystemTree() {
        this.root = new Node("root", null, "directory");
        this.current = this.root;
    }
}