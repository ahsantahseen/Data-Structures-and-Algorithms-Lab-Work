public class sorting {

    public static void main(String[] args) {
        int[] items = new int[] { 13, 2, 133, 4, 140, 12, 214 };
        int[] items1 = new int[] { 313, 25, 133, 14, 10, 12, 214 };
        sorting obj = new sorting();
        obj.SelectionSort(items);
        obj.InsertionSort(items1);

    }

    public void SelectionSort(int a[]) {
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

    public void InsertionSort(int a[]) {
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

}
