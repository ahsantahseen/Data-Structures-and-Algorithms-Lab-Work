
public class DoubleLinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;

    private class ListNode {
        private int data;
        private ListNode next;
        private ListNode previous;

    }

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insertNodeAtStart(int data) {
        ListNode node = new ListNode();
        if (isEmpty()) {
            tail = node;
        } else {
            head.previous = node;
        }
        node.next = head;
        head = node;

    }
}
