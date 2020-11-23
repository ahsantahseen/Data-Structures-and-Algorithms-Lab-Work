public class arrayClass {
    private int[] ArrayItems, AnotherArrayItems;
    private int count;
    private int anotherCount;

    public arrayClass(int ArrayLength, int AnotherArrayLength) {
        ArrayItems = new int[ArrayLength];

        AnotherArrayItems = new int[AnotherArrayLength];

    }

    public void printArray() {
        for (int i = 0; i < count; i++) {
            System.out.println(ArrayItems[i]);

        }
    }

    public void insertIntoArray(int Item) {
        if (ArrayItems.length == count) {
            int[] newArrayItems = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newArrayItems[i] = ArrayItems[i];

            }
            ArrayItems = newArrayItems;

        }
        ArrayItems[count++] = Item;
    }

    public void insertIntoAnotherArray(int AnotherItem) {
        if (AnotherArrayItems.length == anotherCount) {
            int[] newAnotherArrayItems = new int[anotherCount * 2];
            for (int i = 0; i < anotherCount; i++) {
                newAnotherArrayItems[i] = AnotherArrayItems[i];

            }
            AnotherArrayItems = newAnotherArrayItems;

        }
        AnotherArrayItems[anotherCount++] = AnotherItem;
    }

    public void sizeOfArray() {
        System.out.println("The Size Of Array Is:" + count);
    }

        public void removeAt(int index) {
            if (index < 0 || index >= count) {
                throw new IllegalArgumentException();
            }
            for (int i = index; i < count; i++) {
                ArrayItems[i] = ArrayItems[i + 1];
            }
            count--;
        }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (ArrayItems[i] == item) {
                return i;

            }
        }
        return -1;
    }

    public void largestNumberInArray() {
        int largestNumber = ArrayItems[0];//O(1)
        for (int i = 1; i < count; i++) {//O(n)
            if (ArrayItems[i] > largestNumber) {
                int temp = 0;//O(1)
                temp = largestNumber;
                largestNumber = ArrayItems[i];
                ArrayItems[i] = temp;
            }
        }
        System.out.println("LARGEST NUMBER IS " + largestNumber);
    }
    //RUNTIME COMPLEXITY WILL BE 0(n+2) 

    public void findCommonInArrays() {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < anotherCount; j++) {
                if (ArrayItems[i] == AnotherArrayItems[j]) {
                    System.out.println("COMMON ELEMENT IS " + ArrayItems[i]);
                }
            }
        }
    }
}