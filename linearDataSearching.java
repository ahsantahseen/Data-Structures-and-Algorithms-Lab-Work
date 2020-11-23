class Search {
    public static void main(String[] args) {
        int arr1[] = { 1, 22, 43, 12, 4, 14, 155 };
        int a = linearseach(arr1, 4);
        if (a == -1) {
            System.out.println("NUMBER NOT FOUND");
        } else {
            System.out.println("NUMBER FOUND AT " + a + "th position in the array");
        }
    }

    public static int linearseach(int a[], int num) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] == num) {

                return i;
            }

        }
        return -1;
    }
}