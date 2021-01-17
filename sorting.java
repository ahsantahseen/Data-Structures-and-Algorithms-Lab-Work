public class sorting {

    public static void main(String[] args) {
        int[] items = new int[] { 13, 2, 133, 4, 140, 12, 214 };
        int[] items1 = new int[] { 313, 25, 133, 14, 10, 12, 214 };

        int[] items2 = new int[] { 313, 25, 133, 14, 10, 12, 214 };

        int[] items4 = new int[] { 313, 25, 133, 14, 10, 12, 214 };
        String[] names = new String[] { "Charlie", "Alpha", "Bravo", "Tango" };

        String[] names2 = new String[] { "Charlie", "Alpha", "Bravo", "Tango" };

        String[] names3 = new String[] { "Charlie", "Alpha", "Bravo", "Tango" };

        String[] names4 = new String[] { "Charl", "Alph", "Brao", "Tago", "Alpha" };

        String[] names5 = new String[] { "Cherry", "Apple", "Banana", "Pears", "Appricots" };

        String[] names6 = new String[] { "Cherry", "Banana", "Pears", "Appricots" };
        sorting obj = new sorting();
        obj.SelectionSortForInt(items);
        obj.InsertionSortForInt(items1);
        obj.SelectionSortForStrings(names);
        obj.BubbleSortForStrings(names2);
        obj.InsertionSortForStrings(names3);

        System.out.println("\nUNSORTED");
        for (int i = 0; i < names4.length; i++) {
            System.out.print("\t" + names4[i]);
        }
        obj.QuickSortStrings(names4, 0, names4.length - 1);
        System.out.println("\nSORTED");
        for (int i = 0; i < names4.length; i++) {
            System.out.print("\t" + names4[i]);
        }

        System.out.println("\nUNSORTED");
        for (int i = 0; i < items2.length; i++) {
            System.out.print("\t" + items2[i]);
        }
        obj.BubbleSortIntRecursion(items2, items2.length);
        System.out.println("\nSORTED");
        for (int i = 0; i < items2.length; i++) {
            System.out.print("\t" + items2[i]);
        }
        System.out.println("\nUNSORTED");
        for (int i = 0; i < names5.length; i++) {
            System.out.print("\t" + names5[i]);
        }
        obj.BubbleSortStringsRecursion(names5, names5.length);
        System.out.println("\nSORTED");
        for (int i = 0; i < names5.length; i++) {
            System.out.print("\t" + names5[i]);
        }
        System.out.println("\nUNSORTED");
        for (int i = 0; i < items4.length; i++) {
            System.out.print("\t" + items4[i]);
        }
        obj.SelectionSortIntRecursion(items4, items4.length, 0);
        System.out.println("\nSORTED");
        for (int i = 0; i < items4.length; i++) {
            System.out.print("\t" + items4[i]);
        }
        System.out.println("\nUNSORTED");
        for (int i = 0; i < names6.length; i++) {
            System.out.print("\t" + names6[i]);
        }
        obj.SelectionSortStringsRecursion(names6, names6.length, 0);
        System.out.println("\nSORTED");
        for (int i = 0; i < names6.length; i++) {
            System.out.print("\t" + names6[i]);
        }

    }

    public void SelectionSortForInt(int a[]) {
        System.out.println("UNSORTED");
        for (int i = 0; i < a.length; i++) {
            System.out.print("\t" + a[i]);
        }
        for (int i = 0; i < a.length - 1; i++) {
            int smallestElementIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[smallestElementIndex]) {
                    smallestElementIndex = j;
                }
            }
            int temp;
            temp = a[i];
            a[i] = a[smallestElementIndex];
            a[smallestElementIndex] = temp;

        }
        System.out.println();
        System.out.println("SORTED");
        for (int i = 0; i < a.length; i++) {
            System.out.print("\t" + a[i]);
        }
    }

    public void InsertionSortForInt(int a[]) {
        System.out.println();
        System.out.println("UNSORTED");
        for (int i = 0; i < a.length; i++) {
            System.out.print("\t" + a[i]);
        }
        int key, value;
        for (int i = 1; i < a.length; i++) {
            key = i;
            value = a[i];
            while (key > 0 && value < a[key - 1]) {
                a[key] = a[key - 1];
                key--;
            }
            a[key] = value;
        }
        System.out.println();
        System.out.println("SORTED");
        for (int i = 0; i < a.length; i++) {
            System.out.print("\t" + a[i]);
        }
    }

    public void SelectionSortForStrings(String a[]) {

        System.out.println("\nUNSORTED");
        for (int i = 0; i < a.length; i++) {
            System.out.print("\t" + a[i]);
        }
        // Find the string reference that should go in each cell of
        // the array, from cell 0 to the end
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            // Find min: the index of the string reference that should go into cell j.
            // Look through the unsorted strings (those at j or higher) for the one that is
            // first in lexicographic order
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[min]) < 0) { // To set to High to low just swap compare values
                    min = j;
                }
            }
            // Swap the reference at i with the reference at min
            String temp = a[i];
            a[i] = a[min];
            a[min] = temp;

        }
        System.out.println("\nSORTED");
        for (int i = 0; i < a.length; i++) {
            System.out.print("\t" + a[i]);
        }
    }

    public void BubbleSortForStrings(String a[]) {

        System.out.println("\nUNSORTED");
        for (int i = 0; i < a.length; i++) {
            System.out.print("\t" + a[i]);
        }
        // Find the string reference that should go in each cell of
        // the array, from cell 0 to the end
        for (int i = 0; i < a.length - 1; i++) {
            // Find the string and compare it with the next element
            for (int j = 0; j + 1 < a.length - i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) { // To set to High to low just swap compare values
                    // swapping the strings
                    String temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }

            }

        }
        System.out.println("\nSORTED");
        for (int i = 0; i < a.length; i++) {
            System.out.print("\t" + a[i]);
        }
    }

    public void InsertionSortForStrings(String a[]) {
        System.out.println();
        System.out.println("UNSORTED");
        for (int i = 0; i < a.length; i++) {
            System.out.print("\t" + a[i]);
        }
        int key;
        String value;
        for (int i = 1; i < a.length; i++) {
            key = i;
            value = a[i];
            while (key > 0 && a[key - 1].compareTo(value) > 0) { // To set to High to low just swap compare values
                a[key] = a[key - 1];
                key--;
            }
            a[key] = value;
        }
        System.out.println();
        System.out.println("SORTED");
        for (int i = 0; i < a.length; i++) {
            System.out.print("\t" + a[i]);
        }
    }

    // Recursive Sorting Methods

    private int Divide(String array[], int low, int high) {
        String pivot = array[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (pivot.compareTo(array[j]) > 0) {
                i++;

                // swap arr[i] and arr[j]
                String temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        String temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public void QuickSortStrings(String array[], int low, int high) {
        if (low < high) {
            /*
             * pi is partitioning index, arr[pi] is now at right place
             */
            int pi = Divide(array, low, high);

            // Recursively sort elements before
            // partition and after partition
            QuickSortStrings(array, low, pi - 1);
            QuickSortStrings(array, pi + 1, high);
        }
    }

    public void BubbleSortIntRecursion(int[] array, int n) {
        if (n == 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        BubbleSortIntRecursion(array, n - 1);
    }

    public void BubbleSortStringsRecursion(String[] array, int n) {
        if (n == 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                String temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        BubbleSortStringsRecursion(array, n - 1);
    }
    // FUNCTION TO AUTO CALCULATE MIN INDEX

    public int CalcMinIndexInt(int a[], int i, int j) {
        if (i == j) {
            return i;
        }
        // Find minimum of remaining elements
        int k = CalcMinIndexInt(a, i + 1, j);

        // Return minimum of current and remaining.
        return (a[i] < a[k]) ? i : k;
    }

    public int CalcMinIndexString(String a[], int i, int j) {
        if (i == j) {
            return i;
        }
        // Find minimum of remaining elements
        int k = CalcMinIndexString(a, i + 1, j);

        // Return minimum of current and remaining.
        return (a[k].compareTo(a[i]) > 0) ? i : k; // if you wanna set to Des order just swap the compare values
    }

    public void SelectionSortIntRecursion(int[] array, int n, int index) {
        // Return when starting and size are same
        if (index == n)
            return;

        // calling minimum index function for minimum index
        int k = CalcMinIndexInt(array, index, n - 1);

        // Swapping when index nd minimum index are not same
        if (k != index) {
            // swap
            int temp = array[k];
            array[k] = array[index];
            array[index] = temp;
        }
        // Recursively calling selection sort function
        SelectionSortIntRecursion(array, n, index + 1);
    }

    public void SelectionSortStringsRecursion(String[] array, int n, int index) {
        // Return when starting and size are same
        if (index == n)
            return;

        // calling minimum index function for minimum index
        int k = CalcMinIndexString(array, index, n - 1);

        // Swapping when index nd minimum index are not same
        if (k != index) {
            // swap
            String temp = array[k];
            array[k] = array[index];
            array[index] = temp;
        }
        // Recursively calling selection sort function
        SelectionSortStringsRecursion(array, n, index + 1);
    }
}
