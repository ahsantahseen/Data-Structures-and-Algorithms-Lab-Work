public class RecursiveLinearSearch {

    public static void main(String[] args) {
        RecursiveLinearSearch obj = new RecursiveLinearSearch();
        long[] items = new long[] { 1, 2, 3, 4, 10, 24, 12 };
        obj.RecursiveLinearSearchMethod(items, 0, 12);

    }

    public void RecursiveLinearSearchMethod(long a[], int pos, int number) {
        // ARRAY,POSTION WHERE U WANT THE SEARCH TO START FROM,WHAT ELEMENT TO SEARCH

        if (pos > a.length - 1) {
            System.out.println("CANNOT FIND");
        } else if (a[pos] == number) {
            System.out.println("NUMBER " + number + " found at postion " + pos);
        } else {
        
            RecursiveLinearSearchMethod(a, pos + 1, number);

        }

    }

}