public class singleLinkedList {
    private Node first;

    public singleLinkedList() {

    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int data) {
        Node newNode = new Node();// making object of linkedListClass NodeClass
        newNode.Data = data;
        newNode.next = first;
        first = newNode;
    }

    public Node deleteFirst() {
        Node temp = first;
        if (temp != null) {

            first = first.next;
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
    }

}

class mainC {
    public static void main(String[] args) {
        singleLinkedList obj = new singleLinkedList();
        obj.insertFirst(1);
        obj.insertFirst(11);
        obj.insertFirst(111);
        obj.insertFirst(1111);
        obj.InsertLast(5);
        obj.deleteFirst();
        obj.displayList();

    }
}