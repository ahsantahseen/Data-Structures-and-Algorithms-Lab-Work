public class heap {

    private int[] items = new int[10];
    private int size;

    public boolean isFull() {
        return (size == items.length);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    private int parent(int index) {
        return ((index - 1) / 2);
    }

    private void swap(int first, int second) {
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    private int largerChildIndex(int index) {
        if (!hasleftChild(index)) { // if node has no children
            return index;
        } else if (!hasRightChild(index)) { // if node has only left children
            return leftChildIndex(index);
        }
        return (items[leftChildIndex(index)] > items[rightChildIndex(index)]) ? leftChildIndex(index)
                : rightChildIndex(index);
    }

    private boolean hasleftChild(int index) {
        return leftChildIndex(index) <= size; // Checking if the root node has left right child by verifying it with
        // total size
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size; // Checking if the root node has left right child by verifying it with
                                               // total size
    }

    private boolean isValidParent(int index) {
        if (!hasleftChild(index)) { // if node has no children then it's leaf node will be eligible to be a valid
                                    // parent
            return true;
        } else if (!hasRightChild(index)) { // if node has only left child then verify it to be <= to it's parent node
                                            // bcz of max heap
            return items[index] >= items[leftChildIndex(index)];
        }
        return items[index] >= items[leftChildIndex(index)] && items[index] >= items[rightChildIndex(index)];

    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    public void bubbleup() {
        var index = size - 1; // index of last element inserted
        while (index > 0 && items[index] > items[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public void bubbledown() {
        var index = 0;
        while (index <= size && !isValidParent(index)) {
            var largeChildIndex = largerChildIndex(index);
            swap(index, largeChildIndex);
            index = largeChildIndex;
        }
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        items[size++] = value;
        // the item we are inserting it should not be greater than parent
        // if not then perform bubbleup()
        bubbleup();
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        var root = items[0];
        items[0] = items[size - 1]; // Taking last element and placing it on the root
        size--; // item(root) < children then need to do bubble down
        bubbledown();
        return root;
    }

    public static void main(String[] args) {
        heap heap = new heap();
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        System.out.println(heap.remove());
    }
}
