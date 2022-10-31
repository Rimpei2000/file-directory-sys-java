public class Node {
    private String name;
    private Node parent;
    private String type;
    private String content;
    private LinkedList children;
    private Node next;

    public Node(String name, Node parent, String type) {
        this.name = name;
        this.parent = parent;
        this.type = type;
        this.content = "empty";
        this.children = new LinkedList();
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public Node getParentNode() {
        return parent;
    }

    public String getParentName() {
        return parent.getName();
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public LinkedList getChildren() {
        return children;
    }

    public String getChildrenString(){
        return this.children.toString();
    }
    public String getChildrenStringAll(){
        return this.children.toStringAll();
    }
    public String getChildrenStringReverse(){
        return this.children.toStringReverse();
    }

    public Node getNext() {
        return next;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addChild(Node childNode) {
        this.children.add(childNode);
    }

    public boolean isChildExist(String name) {
        return children.getNode(name) != null;
    }

    public Node getChild(String name) {
        if (!this.isChildExist(name)) {
            return null;
        }
        return children.getNode(name);
    }

    public void setNext(Node next) {
        this.next = next;
    }
}