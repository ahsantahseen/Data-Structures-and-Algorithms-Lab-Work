import java.util.NoSuchElementException;

class Student {
    private String StudentName;
    private int StudentId;
    private int StudentAge;
    private String StudentGender;

    public Student(int id, String name, int age, String gender) {
        this.StudentId = id;
        this.StudentName = name;
        this.StudentAge = age;
        this.StudentGender = gender;
    }

    public String toString() {
        return (StudentId + "||" + StudentName + "||" + StudentAge + "||" + StudentGender);
    }

}

class QueueStr {

    private Student queueArray[];
    private int frontPointer;
    private int backPointer;

    public QueueStr(int size) {
        this.queueArray = new Student[size];

    }

    public void enqueue(Student StudentObj) {

        if (backPointer == queueArray.length) {
            Student[] newArray = new Student[queueArray.length * 2];
            System.arraycopy(queueArray, 0, newArray, 0, queueArray.length);
            queueArray = newArray;
        }
        queueArray[backPointer] = StudentObj;
        backPointer++;
    }

    public int size() {
        return this.frontPointer - this.backPointer;
    }

    public Student dequeue() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        Student studentObj = queueArray[frontPointer];
        queueArray[frontPointer] = null;
        frontPointer++;
        if (size() == 0) {
            frontPointer = 0;
            backPointer = 0;
        }
        return studentObj;
    }

    public void printQueue() {
        for (int i = frontPointer; i < backPointer; i++) {
            System.out.println(queueArray[i]);
        }
    }

    public void ClearQueue() {
        for (int i = frontPointer; i < backPointer; i++) {
            dequeue();
        }
    }

}

class runner {
    public static void main(String[] args) {
        QueueStr obj = new QueueStr(4);
        Student[] students = new Student[4];
        students[0] = new Student(1, "Ahsan", 19, "Male");
        students[1] = new Student(3, "Shayan", 20, "Male");
        students[2] = new Student(2, "Asaad", 21, "Male");
        students[3] = new Student(4, "Hallar", 22, "Male");
        for (int i = 0; i < students.length; i++) {
            obj.enqueue(students[i]);
        }
        obj.printQueue();
    }
}