import java.util.Arrays;

class MinHeap1 {
    private int[] heap; // Массив для хранения элементов кучи
    private int size;   // Текущий размер кучи (количество элементов)
    private int capacity; // Максимальная ёмкость кучи

    // Конструктор, инициализирующий кучу с заданной ёмкостью
    public MinHeap1(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity]; // Создание массива фиксированной ёмкости
    }

    // Метод для получения индекса родительского элемента
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Метод для получения индекса левого дочернего элемента
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Метод для получения индекса правого дочернего элемента
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Метод для обмена значениями двух элементов в куче
    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    // Метод для вставки нового элемента в кучу
    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full"); // Проверка на переполнение
        }
        heap[size] = value; // Добавление нового элемента в конец массива
        size++; // Увеличение размера кучи
        heapifyUp(size - 1); // Восстановление свойств кучи
    }

    // Вспомогательный метод для восстановления свойств кучи вверх
    private void heapifyUp(int index) {
        // Пока текущий элемент не является корнем и меньше родительского
        while (index > 0 && heap[parent(index)] > heap[index]) {
            swap(parent(index), index); // Обмен значениями с родителем
            index = parent(index); // Переход к родительскому элементу
        }
    }

    // Метод для извлечения минимального элемента из кучи
    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty"); // Проверка на пустоту
        }
        int min = heap[0]; // Сохранение минимального элемента
        heap[0] = heap[size - 1]; // Замена корня последним элементом
        size--; // Уменьшение размера кучи
        heapifyDown(0); // Восстановление свойств кучи вниз
        return min; // Возврат минимального элемента
    }

    // Вспомогательный метод для восстановления свойств кучи вниз
    private void heapifyDown(int index) {
        int smallest = index; // Изначально предполагаем, что текущий элемент - наименьший
        int left = leftChild(index); // Индекс левого дочернего элемента
        int right = rightChild(index); // Индекс правого дочернего элемента

        // Проверка, является ли левый дочерний элемент меньше текущего
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left; // Обновление индекса наименьшего элемента
        }
        // Проверка, является ли правый дочерний элемент меньше текущего
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right; // Обновление индекса наименьшего элемента
        }
        // Если наименьший элемент не текущий, обмен значениями и продолжение
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest); // Рекурсивный вызов для восстановления свойств кучи
        }
    }

    // Метод для получения минимального элемента без его удаления
    public int getMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty"); // Проверка на пустоту
        }
        return heap[0]; // Возврат корневого элемента
    }

    // Метод для проверки, пуста ли куча
    public boolean isEmpty() {
        return size == 0; // Возврат true, если размер равен 0
    }

    // Метод для получения текущего размера кучи
    public int getSize() {
        return size; // Возврат текущего размера
    }
    // Переопределение метода toString для удобного отображения содержимого кучи
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(heap, size)); // Возврат массива, содержащего только элементы кучи
    }
    // Главный метод для тестирования работы кучи
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10); // Создание новой мин-кучи с ёмкостью 10
        minHeap.insert(3); // Вставка элемента 3
        minHeap.insert(1); // Вставка элемента 1
        minHeap.insert(6); // Вставка элемента 6
        minHeap.insert(5); // Вставка элемента 5
        minHeap.insert(2); // Вставка элемента 2
        minHeap.insert(4); // Вставка элемента 4

        // Вывод текущего состояния кучи
        System.out.println("Min-Heap array: " + minHeap);
        // Извлечение минимального элемента и вывод его значения
        System.out.println("Extracted min: " + minHeap.extractMin());
        // Вывод состояния кучи после извлечения минимального элемента
        System.out.println("Min-Heap array after extraction: " + minHeap);
    }
}
