
class Node {
    public int Data;
    public Node next = null;

    public void LengthOfLinkList(Node node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        System.out.println("LENGTH OF LINK LIST IS:" + len);
    }

    public void DisplayNode() {
        System.out.println("Data = " + Data);
    }
}

class Mc {
    public static void main(String[] args) {
        singleLinkedList obj = new singleLinkedList();
        obj.insertFirst(1);
        obj.insertFirst(11);
        obj.insertFirst(111);
        obj.insertFirst(1111);

    }
}