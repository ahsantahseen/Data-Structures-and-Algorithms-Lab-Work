public class sorting {

    public static void main(String[] args) {
        int[] items = new int[] { 13, 2, 133, 4, 140, 12, 214 };
        sorting obj = new sorting();
        obj.SelectionSort(items);

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

}
