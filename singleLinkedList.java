public class singleLinkedList {
    private Node first;
    public int size;

    public singleLinkedList() {

    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int data) {
        Node newNode = new Node(); // making object of linkedListClass NodeClass
        newNode.Data = data;
        newNode.next = first;
        first = newNode;
        size++;
    }

    public Node deleteFirst() {
        Node temp = first;
        if (temp != null) {

            first = first.next;
            size--;
        }

        return temp;
    }

    public void displayList() {
        System.out.println("Linked List(first Node --> last Node)");
        Node currentNode = first;
        while (currentNode != null) {
            currentNode.DisplayNode();
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public void InsertLast(int data) {
        Node currentNode = first;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        Node newNode = new Node();
        newNode.Data = data;
        currentNode.next = newNode;
        size++;
    }

    public Node DeleteLast() {
        Node tempNode = first;
        while (tempNode.next.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = null;
        size--;
        return tempNode;

    }

    public void InsertMiddle(int data) {
        Node newNode = new Node();
        newNode.Data = data;
        Node tempNode, current;
        int count = (size % 2 == 0) ? (size / 2) : ((size + 1) / 2);
        tempNode = first;
        current = null;
        for (int i = 0; i < count; i++) {
            current = tempNode;
            tempNode = tempNode.next;

        }
        current.next = newNode;
        newNode.next = tempNode;

        size++;
    }

    public Node DeleteMiddle() {
        Node temp, current;
        int count = (size % 2 == 0) ? (size / 2) : ((size + 1) / 2);
        temp = first;
        current = null;
        for (int i = 0; i < count - 1; i++) {
            current = temp;
            temp = temp.next;
        }
        if (current != null) {
            current.next = temp.next;
            temp = null;
        }
        size--;
        return current;

    }
}

class mainC {
    public static void main(String[] args) {
        singleLinkedList obj = new singleLinkedList();
        obj.insertFirst(1);
        obj.insertFirst(11);
        obj.insertFirst(111);
        obj.InsertLast(5);
        obj.InsertMiddle(10);
        obj.DeleteMiddle();
        obj.displayList();

    }
}