class StackDB {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackDB(int size) {

        this.maxSize = size;
        this.stackArray = new int[size];
        this.top = -1;

    }

    public void push(int elem) {
        top++;
        stackArray[top] = elem;

    }

    public int pop() {
        int old_top = top;
        top--;
        return stackArray[old_top];

    }

    public int peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {

        return (top == -1);
    }

    public boolean isFull() {
        return (maxSize - 1 == top);
    }

    public void StackRev(String str) {
        StackDB stack = new StackDB(str.length());
        for (int i = 0; i <= str.length()-1; i++) {
            stack.push(str.charAt(i));
        }
        for (int i = 0; i <= str.length()-1; i++) {
            System.out.println((char)stack.pop());
        }

    }

}

public class practiceStack {
    public static void main(String[] args) {
        StackDB obj = new StackDB(3);
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.peek());
        while (!obj.isEmpty()) {
            obj.pop();
        }
        System.out.println("IS STACK EMPTY?:" + obj.isEmpty());
        System.out.println("IS STACK FULL?:" + obj.isFull());
        obj.StackRev("AHSAN");

    }
}
