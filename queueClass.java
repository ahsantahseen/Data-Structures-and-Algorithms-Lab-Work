import java.util.NoSuchElementException;

class employeeDS {
    private int id;
    private String firstName;
    private String lastName;

    public employeeDS(int id, String fname, String lname) {
        this.id = id;
        this.firstName = fname;
        this.lastName = lname;
    }

    public String toString() {
        return ("Employe:" + id + "|| " + firstName + "  ||" + lastName);
    }
}

class QueueDS {
    private employeeDS[] queueArray;
    private int frontPointer;
    private int backPointer;

    public QueueDS(int size) {
        this.queueArray = new employeeDS[size];

    }

    public void enqueue(employeeDS employeeOBJ) {
        if (backPointer == queueArray.length) {
            employeeDS[] newArray = new employeeDS[queueArray.length * 2];
            System.arraycopy(queueArray, 0, newArray, 0, queueArray.length);
            queueArray = newArray;
        }

        queueArray[backPointer] = employeeOBJ;
        backPointer++;
    }

    public void print() {
        for (int i = frontPointer; i < backPointer; i++) {
            System.out.println(queueArray[i]);
        }
    }

    public void sizeOfQueue() {
        System.out.println("SIZE OF QUEUE IS:" + queueArray.length);
    }

    public int size() {
        return backPointer - frontPointer;
    }

    public employeeDS peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return queueArray[frontPointer];
    }

    public employeeDS dequeue() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        employeeDS employeeObj = queueArray[frontPointer];
        queueArray[frontPointer] = null;
        frontPointer++;
        if (size() == 0) {
            frontPointer = 0;
            backPointer = 0;
        }
        return employeeObj;
    }

}

public class queueClass {
    public static void main(String[] args) {
        QueueDS obj = new QueueDS(5);
        employeeDS emp[] = new employeeDS[5];
        emp[0] = new employeeDS(1, "Ali", "Tahseen");
        emp[1] = new employeeDS(2, "Ameen", "Tahseen");
        emp[2] = new employeeDS(3, "Bilal", "Tahseen");
        emp[3] = new employeeDS(4, "Ahsan", "Tahseen");
        emp[4] = new employeeDS(5, "Test", "Subject");
        for (int i = 0; i < emp.length; i++) {
            obj.enqueue(emp[i]);
        }
        obj.print();
        obj.sizeOfQueue();
        System.out.println("\nPEEEKING FRONT:" + obj.peek());

        for (int i = 0; i < emp.length; i++) {
            obj.dequeue();
        }
        obj.print();
        System.out.println("\n PEEKING FRONT:" + obj.peek());
        obj.sizeOfQueue();
    }
}