class StackDS {
    private int maxLen;
    private int[] stackArray;
    private int top;

    public StackDS(int size) {
        this.maxLen = size;
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
}

public class stackClass {

    public static void main(String[] args) {

    }
}
