import java.util.Arrays;

public class MinHeap {
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
        var smallerIndex = index; // First we assuming index passed which is passed is smallest later will change
                                  // if needed
        var leftIndex = index * 2 + 1;
        if (leftIndex < array.length && array[leftIndex] < array[smallerIndex]) {
            smallerIndex = leftIndex;
        }
        var rightIndex = index * 2 + 2;
        if (rightIndex < array.length && array[rightIndex] < array[smallerIndex]) {
            smallerIndex = rightIndex;
        }
        // If Smallest is not root
        if (smallerIndex == index) {
            return;
        }

        swap(array, index, smallerIndex);
        heapify(array, smallerIndex);
    }

    public static void main(String[] args) {
        int numbers[] = { 12, 313, 43, 1 };
        MinHeap.heapify(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
