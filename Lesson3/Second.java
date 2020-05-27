/*Разработать и написать на Java алгоритм вычисления чисел Фибоначчи. Определить сложность алгоритма.*/
public class Second {

    public static void main(String[] args) {
        calculate(10);
    }

    //алгоритм вычисления первых n чисел Фибоначчи. Сложность O(N)
    private static void calculate(int n) {
        int a = 1;
        int b = 1;
        if (n == 1) System.out.print(a);
        if (n == 2) System.out.print(a + " " + b);
        if (n > 2) {
            System.out.print(a + " " + b + " ");
            for (int i = 2; i < n; i++) {
                int current = a + b;
                System.out.print(current);
                System.out.print(" ");
                a = b;
                b = current;
            }
        }
    }
}
