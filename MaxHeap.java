import java.util.Arrays;

public class MaxHeap {
    public static void heapify(int[] array) {
        var lastParentIndex = (array.length / 2) - 1;
        for (var i = lastParentIndex; i >= 0; i--) {
            heapify(array, i);
        }

    }

    private static void swap(int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    private static void heapify(int[] array, int index) {
        var largerIndex = index; // First we assuming index passed which is passed is smallest later will change
                                 // if needed
        var leftIndex = index * 2 + 1;
        if (leftIndex < array.length && array[leftIndex] > array[largerIndex]) {
            largerIndex = leftIndex;
        }
        var rightIndex = index * 2 + 2;
        if (rightIndex < array.length && array[rightIndex] > array[largerIndex]) {
            largerIndex = rightIndex;
        }
        // If Largest is not root
        if (largerIndex == index) {
            return;
        }

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    public static void main(String[] args) {
        int[] numbers = { 1, 3, 5, 23 };
        MaxHeap.heapify(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
