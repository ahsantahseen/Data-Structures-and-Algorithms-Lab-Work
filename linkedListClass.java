
class Node {
    public int Data;
    public Node next = null;

    public static void main(String[] args) {
        Node A = new Node();
        Node B = new Node();

        Node C = new Node();
        A.Data = 1;
        B.Data = 2;
        C.Data = 3;
        A.next = B;
        B.next = C;
        LengthOfLinkList(A);
    }

    public static void LengthOfLinkList(Node node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        System.out.println("LENGTH OF LINK LIST IS:" + len);
    }
}