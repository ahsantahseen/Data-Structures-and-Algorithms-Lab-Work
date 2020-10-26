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

    public void Enqueue() {
        if (size() == queueArray.length - 1) {
            int numOfitems = size();
            Employee[] newArray = new Employee[queueArray.length * 2];
            //It will copy from front to the last element from the orignal queue//
            System.arraycopy(queueArray, FrontPointer, newArray, 0, queueArray.length - FrontPointer);
            //It will copy from 0 to the back pointer from the orignal queue//
            System.arraycopy(queueArray, 0, newArray, queueArray.length-FrontPointer, BackPointer);
            FrontPointer=0;
            BackPointer=numOfitems;
        }
    }
}
