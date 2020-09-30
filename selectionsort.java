class sort {

    public static void main(String[] args) {
        int[] input = { 1, 3432, 43, 12, 53, 2 };
        System.out.println("UNSORTED");
        for (int i = 0; i < input.length; i++) {

            System.out.print("\t" + input[i]);
        }
        for (int i = 0; i < input.length-1; i++) {
            int indexOfSmallest = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[indexOfSmallest]) {
                    indexOfSmallest = j;
                }

            }
            int temp;
            temp = input[i];
            input[i] = input[indexOfSmallest];
            input[indexOfSmallest] = temp;
        }
        System.out.println("\n SORTED");
        for (int i = 0; i < input.length; i++) {
            System.out.print("\t" + input[i]);
        }
    }
}