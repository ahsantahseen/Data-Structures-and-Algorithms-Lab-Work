class bsort {

    public static void main(String[] args) {
        int[] input = { 1, 34, 43, 12, 53, 2 };
        System.out.println("UNSORTED");
        for (int i = 0; i < input.length; i++) {

            System.out.print("\t" + input[i]);
        }
        for (int i = 0; i < input.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j + 1 < input.length - i; j++) {
                if (input[j] > input[j + 1]) {
                    swap = true;
                    int temp;
                    temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;

                }
            }

            if (!swap) {

                System.out.println("\n SORTED");
                for (i = 0; i < input.length; i++) {

                    System.out.print("\t" + input[i]);
                }
                return;
            }
        }

    }

}