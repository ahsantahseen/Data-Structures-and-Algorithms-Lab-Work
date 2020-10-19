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
class QueueDS{
    private employee[] queueArray;
    private int frontPointer;
    private int backPointer;

    public QueueDS(int size){
        this.queueArray=new employee[size];

    }   
    

}