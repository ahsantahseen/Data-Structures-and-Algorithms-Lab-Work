class StackDS {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackDS(int size) {
        this.maxSize = size;
        this.stackArray = new int[size];
        this.top = -1;// because when we add it will be 0 and array starting element index is 0

    }

    public void push(int item) {
        top++;
        stackArray[top] = item;// item wll be pushed to 0 then 1 the 2 and so on...
    }

    public int pop() {
        int old_top = top;
        top--;
        return stackArray[old_top];

    }

    public int peek() {
        return stackArray[top];
    }

}

public class stackClass {

    public static void main(String[] args) {

    }
}
