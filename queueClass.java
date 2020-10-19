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
}

class main {
    public static void main(String[] args) {
        QueueDS obj = new QueueDS(5);
        employee ali = new employee(1, "Ali  ", "Khan");
        employee ahsan = new employee(2, "Ahsan", "Khan");
        employee ameen = new employee(3, "Ameen", "Khan");
        obj.enqueue(ali);
        obj.enqueue(ahsan);
        obj.enqueue(ameen);
        obj.print();
    }
}