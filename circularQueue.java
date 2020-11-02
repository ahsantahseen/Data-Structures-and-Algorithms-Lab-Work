import java.util.NoSuchElementException;

class Employee {
    private String fullname;
    private int ID;

    public Employee(String name, int id) {
        this.fullname = name;
        this.ID = id;
    }

    public String toString() {
        return ("ID:" + ID + "|" + "NAME:" + fullname);
    }
}

public class circularQueue {
    private Employee[] queueArray;
    private int FrontPointer;
    private int BackPointer;

    public circularQueue(int size) {
        this.queueArray = new Employee[size];

    }

    public int size() {
        if (FrontPointer <= BackPointer) {
            return BackPointer - FrontPointer;
        } else {
            return BackPointer - FrontPointer + queueArray.length;
        }
    }

    public void CEnqueue(Employee employee) {
        if (size() == queueArray.length - 1) {
            int numOfitems = size();
            Employee[] newArray = new Employee[queueArray.length * 2];
            // It will copy from front to the last element from the orignal queue//
            System.arraycopy(queueArray, FrontPointer, newArray, 0, queueArray.length - FrontPointer);
            // It will copy from 0 to the back pointer from the orignal queue//
            System.arraycopy(queueArray, 0, newArray, queueArray.length - FrontPointer, BackPointer);
            queueArray = newArray;
            FrontPointer = 0;
            BackPointer = numOfitems;
        }
        queueArray[BackPointer] = employee;
        if (BackPointer < queueArray.length - 1) {
            BackPointer++;
        } else {
            BackPointer = 0;
        }
    }

    public Employee Dequeue() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        Employee employee = queueArray[FrontPointer];
        queueArray[FrontPointer] = null;
        FrontPointer++;
        if (size() == 0) {
            FrontPointer = 0;
            BackPointer = 0;
        } else if (FrontPointer == queueArray.length) {
            FrontPointer = 0;
        }
        return employee;

    }

    public void PrintQueue() {
        if (FrontPointer <= BackPointer) {
            for (int i = 0; i < BackPointer; i++) {
                System.out.println(queueArray[i]);
            }
        } else {
            for (int i = FrontPointer; i < queueArray.length; i++) {
                System.out.println(queueArray[i]);
            }
            for (int i = 0; i < BackPointer; i++) {
                System.out.println(queueArray[i]);
            }
        }
    }

}

class tester {
    public static void main(String[] args) {
        circularQueue cQ = new circularQueue(4);
        Employee ali = new Employee("ali", 1);
        Employee ameen = new Employee("ameen", 2);
        Employee bilal = new Employee("bilal", 3);
        Employee ahsan = new Employee("ahsan", 4);
        Employee ahmed = new Employee("ahmed", 5);
        cQ.CEnqueue(ali);
        cQ.CEnqueue(ameen);
        cQ.CEnqueue(bilal);
        cQ.CEnqueue(ahsan);
        cQ.CEnqueue(ahmed);

        cQ.PrintQueue();
        System.out.println("SIZE OF ARRAY:" + cQ.size());
        cQ.Dequeue();
        cQ.Dequeue();

        cQ.PrintQueue();
        System.out.println("SIZE OF ARRAY:" + cQ.size());
    }

}
