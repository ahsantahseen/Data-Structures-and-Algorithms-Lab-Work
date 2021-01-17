
public class PriorityQueue {
    private heap heap = new heap();

    public void enqueue(int item) {
        heap.insert(item);
    }

    public int dequeue() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public static void main(String[] args) {
        PriorityQueue PQ = new PriorityQueue();
        System.out.println("Priority Queue using HEAP");
        PQ.enqueue(1);
        PQ.enqueue(13);
        PQ.enqueue(112);
        for(var i=0;i<3;i++){
            System.out.println(PQ.dequeue());
        }
    }
}
