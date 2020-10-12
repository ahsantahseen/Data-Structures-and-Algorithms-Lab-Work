import java.util.Stack;

class StackDS {
    private int maxSize;
    private int[] stackArray;
    private char[] stackChar;
    private int top;
    private int charTop;

    public StackDS(int size) {
        this.maxSize = size;
        this.stackArray = new int[size];
        this.top = -1;// because when we add it will be 0 and array starting element index is 0

        this.charTop = -1;

    }

    public void reverseArrayNew(String x) {
        StackDS stackObj = new StackDS(x.length());

        for (int i = 0; i <= x.length() - 1; i++) {
            stackObj.push(x.charAt(i));
        }
        for (int i = 0; i <= x.length() - 1; i++) {

            System.out.println(((char) stackObj.pop()));
        }
    }

    public void charArray(int size) {
        this.stackChar = new char[size];
    }

    public void pushChar(char item) {

        charTop++;
        stackChar[charTop] = item;
    }

    public char popChar() {
        int oldCharTop = charTop;
        charTop--;
        return stackChar[oldCharTop];
    }

    public void reverseArray() {
        while (!isCharArrayEmpty()) {
            System.out.println(popChar());
        }
    }

    public boolean isCharArrayEmpty() {
        return (charTop == -1);
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

    public boolean isEmpty() {
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
        System.out.println("Is stack empty:" + obj.isEmpty());
        System.out.println("Is stack full:" + obj.isFull());
        while (!obj.isEmpty()) {

            System.out.println("We have removed :" + obj.pop());

        }

        System.out.println("Is stack empty:" + obj.isEmpty());
        System.out.println("Is stack full:" + obj.isFull());
        obj.charArray(6);
        obj.pushChar('a');
        obj.pushChar('h');
        obj.pushChar('s');
        obj.pushChar('a');
        obj.pushChar('n');
        obj.reverseArray();
        obj.reverseArrayNew("AHSAN");
    }
}
