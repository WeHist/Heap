import java.util.Arrays;

class Heapify {

    public static void heapify(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(array, n, i);
        }
    }

    private static void siftDown(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(array, i, largest);
            siftDown(array, n, largest);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3, 5, 1, 10, 2, 7};
        System.out.println("Исходный массив: " + Arrays.toString(array));

        heapify(array);

        System.out.println("Массив после преобразования в кучу: " + Arrays.toString(array));
    }
}
