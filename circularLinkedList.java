
public class circularLinkedList {

    private Node first;
    private Node last;

    public circularLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertAtfirst(int data) {
        Node newNode = new Node();
        newNode.Data = data;
        if (isEmpty()) {
            last = newNode;
        }
        newNode.next = first;
        first = newNode;
    }

    public void insertAtlast(int data) {
        Node newNode = new Node();
        newNode.Data = data;
        if (isEmpty()) {
            first = newNode;
        }
        last.next = newNode;
        last = newNode;

    }

    public Node deleteAtFirst() {
        Node temp = first;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
    }

    public Node deleteAtLast() {
        Node temp = first;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        last = temp;
        last.next = null;
        temp = temp.next;
        return temp;

    }

}
