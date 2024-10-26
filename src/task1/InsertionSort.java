package task1;

public class InsertionSort {
    public static void insertionSort(int[] A) {
        int n = A.length;
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %n", "i", "j", "A[1]", "A[2]", "A[3]", "A[4]"); // Заголовок таблицы

        for (int i = 1; i < n; i++) {
            int key = A[i];
            int j = i - 1;

            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key;

            // Вывод текущего состояния массива после каждой итерации
            System.out.printf("%-10d %-10d %-10d %-10d %-10d %-10d %n", i, j + 1, A[0], A[1], A[2], A[3]);
        }
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4};
        insertionSort(A);
    }
}
