import java.util.NoSuchElementException;

class employee {
    private int id;
    private String firstName;
    private String lastName;

    public employee(int id, String fname, String lname) {
        this.id = id;
        this.firstName = fname;
        this.lastName = lname;
    }

    public String toString() {
        return ("Employe:" + id + "|| " + firstName + "  ||" + lastName);
    }
}

class QueueDS {
    private employee[] queueArray;
    private int frontPointer;
    private int backPointer;

    public QueueDS(int size) {
        this.queueArray = new employee[size];

    }

    public void enqueue(employee employeeOBJ) {
        if (backPointer == queueArray.length) {
            employee[] newArray = new employee[queueArray.length * 2];
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

    public employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return queueArray[frontPointer];
    }

    public employee dequeue() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        employee employeeObj = queueArray[frontPointer];
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
        employee emp[] = new employee[5];
        emp[0] = new employee(1, "Ali", "Tahseen");
        emp[1] = new employee(2, "Ameen", "Tahseen");
        emp[2] = new employee(3, "Bilal", "Tahseen");
        emp[3] = new employee(4, "Ahsan", "Tahseen");
        emp[4] = new employee(5, "Test", "Subject");
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