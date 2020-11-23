public class BinaryDataSearching {
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };// Array needs to be sorted
        int a = BinearySearch(arr1, 9);
        if (a == -1) {
            System.out.println("NUMBER NOT FOUND");
        } else {
            System.out.println("NUMBER FOUND AT " + a + "th position in the array");
        }
    }

    public static int BinearySearch(int a[], int num) {

        int p = 0, q;
        int r = a.length - 1;
        while (p <= r) {
            q = (p + r) / 2;
            if (a[q] == num) {
                return q;
            } else if (a[q] > num) {
                r = q - 1;
            } else {
                p = q + 1;
            }
        }
        return -1;
    }
}
