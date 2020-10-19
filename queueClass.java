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

class main {
    public static void main(String[] args) {
        QueueDS obj = new QueueDS(4);
        employee ali = new employee(1, "Ali  ", "Khan");
        employee ahsan = new employee(2, "Ahsan", "Khan");
        employee ameen = new employee(3, "Ameen", "Khan");
        employee bilal = new employee(4, "Bilal", "Khan");
        employee test = new employee(5, "Test", "GUY");
        obj.enqueue(ali);
        obj.enqueue(ahsan);
        obj.enqueue(ameen);
        obj.enqueue(bilal);
        obj.enqueue(test);
        obj.print();
        obj.sizeOfQueue();
    }
}