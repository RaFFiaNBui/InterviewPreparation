/*Разработать и написать на Java алгоритм сортировки методом вставки (поиском максимума или минимума). Определить сложность алгоритма.*/
public class First {

    public static void main(String[] args) {

        int[] array = new int[]{1, 5, 9, 12, 4, 7, 3};

        print(array);
        sort(array);
        print(array);
    }

    //сортировка массива методом вставки (поиск минимума). Сложность О(N^2)
    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = min + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    private static void print(int[] arr) {
        for (int value : arr) {
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println();
    }
}
