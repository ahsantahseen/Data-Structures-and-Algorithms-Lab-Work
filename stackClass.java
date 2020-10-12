class StackDS {
    private int maxLen;
    private int[] stackArray;
    private int top;

    public StackDS(int size) {
        this.maxLen = size;
        this.stackArray = new int[size];
        this.top = -1;// because when we add it will be 0 and array starting element index is 0

    }

    public void push(int j) {
        top++;
        stackArray[top] = j;
    }
}

public class stackClass {

    public static void main(String[] args) {

    }
}
