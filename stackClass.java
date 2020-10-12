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

    public boolean inEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (maxSize - 1 == top);
    }

}

public class stackClass {

    public static void main(String[] args) {
        StackDS obj = new StackDS(4);
        obj.push(0);
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println("The top element is :" + obj.peek());
        System.out.println("We have removed :" + obj.pop());
        System.out.println("The top element is :" + obj.peek());
        System.out.println("Is stack empty:" + obj.inEmpty());
        System.out.println("Is stack full:" + obj.isFull());

    }
}
