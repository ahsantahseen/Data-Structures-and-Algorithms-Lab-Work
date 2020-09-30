public class mainClass {
  public static void main(String[] args) {
    arrayClass obj = new arrayClass(3, 3);
    obj.insertIntoArray(3);
    obj.insertIntoArray(4);
    obj.insertIntoArray(534);
    obj.insertIntoArray(677);
    obj.insertIntoAnotherArray(3);
    obj.insertIntoAnotherArray(4);
    obj.printArray();
    obj.sizeOfArray();
    obj.removeAt(1);
    obj.printArray();
    obj.sizeOfArray();
    obj.largestNumberInArray();
    obj.findCommonInArrays();
    System.out.println(obj.indexOf(3));
  }
}
