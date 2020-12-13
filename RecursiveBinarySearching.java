public class RecursiveBinarySearching {

    public static void main(String[] args) {
        RecursiveBinarySearching obj = new RecursiveBinarySearching();
        long[] items = new long[] { 1, 2, 3, 4, 10, 24, 12 };
        obj.RecursiveBinarySearchingMethod(items, 0, items.length - 1, 24);
    }

    public void RecursiveBinarySearchingMethod(long a[], int start, int end, int number) {
        int mid = (start + end) / 2;
        if (start > end) {
            System.out.println("ITEM NOT FOUND");
        }
        if (a[mid] == number) {
            System.out.println("NUMBER " + number + " found at postion " + mid);
        } else if (number > a[mid]) {
            RecursiveBinarySearchingMethod(a, mid + 1, end, number);
        } else {
            RecursiveBinarySearchingMethod(a, start, mid - 1, number);
        }
    }

}
