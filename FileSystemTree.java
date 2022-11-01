import java.util.HashMap;

public class FileSystemTree {
    public static HashMap<String, String> map = new HashMap<String, String>();
    public Node root;
    public Node current;

    public FileSystemTree() {
        this.root = new Node("root", null, "directory");
        this.current = this.root;
    }

    public Node findNode(String filePath) {
        Node iterator = this.root;
        String[] pathArr = filePath.split("/", filePath.length());
        if (pathArr[0] != "root") {
            return null;
        }
        for (int i = 1; i < pathArr.length; i++) {
            if (iterator == null) {
                return null;
            }
            iterator = iterator.getChild(pathArr[i]);
        }
        return iterator;
    }

    public void touch(String fileName) {
        if (map.get(fileName) != null) {
            HelperFunctions.appendError("sameName");
            return;
        }
        this.current.addChild(new Node(fileName, this.current, "file"));
        map.put(fileName, fileName); 
    }

    public void touchPath(String path, String fileName) {
        Node targetNode = findNode(path);
        if (targetNode == null) {
            HelperFunctions.appendError("pathError");
        } else {
            targetNode.addChild(new Node(fileName, targetNode, "file"));
        }
    }

    public void mkdir(String dirName) {
        if (map.get(dirName) != null) {
            HelperFunctions.appendError("sameName");
            return;
        }
        this.current.addChild(new Node(dirName, this.current, "directory"));
        map.put(dirName, dirName);
    }

    public void mkdirPath(String path, String dirName) {
        Node targetNode = this.findNode(path);
        if (targetNode == null) {
            HelperFunctions.appendError("pathError");
        } else {
            targetNode.addChild(new Node(dirName, targetNode, "directory"));
        }
    }

    public String ls() {
        return this.current.getChildrenString();
    }

    public String lsChild(String nameOrPath) {
        Node child = this.current.getChild(nameOrPath);
        Node targetNode = this.findNode(nameOrPath);

        if (child != null) {
            return child.getChildrenString();
        } else if (targetNode != null) {
            return targetNode.getChildrenString();
        }
        return nameOrPath + "does not exist";
    }

    public String lsAll() {
        return this.current.getChildrenStringAll();
    }

    public String lsReverse() {
        return this.current.getChildrenStringReverse();
    }

    public void cd(String dirNameOrPath) {
        Node child = this.current.getChild(dirNameOrPath);
        Node targetNode = this.findNode(dirNameOrPath);

        if (dirNameOrPath.equals("..") && this.current != this.root) {
            this.current = this.current.getParentNode();
        } else if (child != null && child.getType().equals("directory")) {
            this.current = child;
        } else if (targetNode != null && targetNode.getType().equals("directory")) {
            this.current = targetNode;
        }
        return;
    }

    public String pwd() {
        String path = "";
        Node iterator = this.current;
        while (iterator != null) {
            path = iterator.getName() + "/" + path;
            if (iterator == this.root) {
                return "/" + path;
            }
            iterator = iterator.getParentNode();
        }
        return path;
    }

    public String print(String fileNameOrPath) {
        Node child = this.current.getChild(fileNameOrPath);
        Node targetNode = this.findNode(fileNameOrPath);

        if (child != null && child.getType().equals("file")) {
            return child.getContent();
        } else if (targetNode != null && targetNode.getType().equals("file")) {
            return targetNode.getContent();
        } else {
            return "No File";
        }
    }

    public void setContent(String fileNameOrPath, String content) {
        Node child = this.current.getChild(fileNameOrPath);
        Node targetNode = this.findNode(fileNameOrPath);

        if (child != null && child.getType().equals("file")) {
            child.setContent(content);
        } else if (targetNode != null && targetNode.getType().equals("file")) {
            targetNode.setContent(content);
        }
    }

    public String rm(String nameOrPath) {
        Node child = this.current.getChild(nameOrPath);
        Node targetNode = this.findNode(nameOrPath);

        if (child != null) {
            return this.current.getChildren().removeNode(nameOrPath);
        } else if (targetNode != null) {
            String[] name = nameOrPath.split("/");
            // return targetNode.getParentNode().children.remove(name[])
            return "Need to work on here";
        } else {
            return "There is no such path";
        }
    }

    public void move(String targetPath, String goalPath) {
        Node targetNode = this.findNode(targetPath);
        Node goalNode = this.findNode(goalPath);

        if (targetNode == null || goalNode == null || goalNode.getType().equals("file")) {
            return;
        }
        if (this.rm(targetPath) != null) {
            targetNode.setParent(goalNode);
            goalNode.addChild(targetNode);
        }
        return;
    }
}