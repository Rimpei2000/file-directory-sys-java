public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(Node node) {
        if (this.head == null) {
            this.head = node;
        } else if (this.tail == null) {
            this.tail = node;
            this.head.setNext(this.tail);
        } else {
            this.tail.setNext(node);
            this.tail = this.tail.getNext();
        }
    }

    public String removeNode(String nodeName) {
        // remove head
        if (this.head.getName().equals(nodeName)) {
            this.head = this.head.getNext();
            return nodeName;
        }
        Node iterator = this.head;
        if (iterator.getNext() == null) {
            return "No File";
        }

        while (iterator.getNext() != null) {
            if (iterator.getNext().getName().equals(nodeName)) {
                // remove tail
                if (iterator.getNext() == this.tail) {
                    this.tail = iterator;
                }
                // remove middle
                iterator.setNext(iterator.getNext().getNext());
                return nodeName;
            }
            iterator = iterator.getNext();
        }
        return "No File";
    }

    public Node getNode(String nodeName) {
        Node iterator = this.head;
        while (iterator != null) {
            if (iterator.getName().equals(nodeName)) {
                return iterator;
            }
            iterator = iterator.getNext();
        }
        return null;
    }

    public String toString() {
        String str = "";
        Node iterator = this.head;
        while (iterator != null) {
            if (iterator.getName().charAt(0) != '.') {
                str += iterator.getName() + " ";
            }
            iterator = iterator.getNext();
        }
        return str;
    }

    public String toStringAll() {
        String str = "";
        Node iterator = this.head;
        while (iterator != null) {
            if (iterator.getName().charAt(0) != '.') {
                str = iterator.getName() + " " + str;
            }
            iterator = iterator.getNext();
        }
        return str;
    }

    public String toStringReverse() {
        String str = "";
        Node iterator = this.head;
        while (iterator != null) {
            str = iterator.getName() + " " + str;
            iterator = iterator.getNext();
        }
        return str;
    }
}