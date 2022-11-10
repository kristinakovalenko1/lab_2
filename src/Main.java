import java.util.Arrays;
import java.util.Random;


public class Main {

    /**
     * Первое задание, вариант 25:
     * Оценки, полученные спортсменом в соревнованиях по фигурному катанию (в баллах), хранятся в массиве из 18 элементов.
     * В первых шести элементах записаны оценки по обязательной программе,
     * с седьмого по двенадцатый — по короткой программе, в остальных — по произвольной программе.
     * Выяснить, по какому виду программы спортсмен показал лучший результат.
     */
    private static void task1() {
        Random rnd = new Random();
        int[] A = new int[18];
        int mainSum = 0;
        int shortSum = 0;
        int arbitarySum = 0;
        for (int i = 0; i < A.length; i++) {
            A[i] = rnd.nextInt(1, 11);
        }
        System.out.println("Your Array of Marks:");
        System.out.println(Arrays.toString(A));

        for (int i = 0; i < 6; i++) {
            mainSum += A[i];
        }
        for (int i = 6; i < 12; i++) {
            shortSum += A[i];
        }

        for (int i = 12; i < A.length; i++) {
            arbitarySum += A[i];
        }
        System.out.println("Main programm (1) mark: " + mainSum + "\nShort programm (2) mark: "
                + shortSum + "\nArbitary programm (3) mark: " + arbitarySum);
        int[] res = {mainSum, shortSum, arbitarySum};
        int max = 0;
        for (int i = 1; i < res.length; i++) {
            if (res[i] > res[max])
                max = i;
        }
        System.out.println("The boggest score is on programm №" + (max + 1));
    }

    /**
     * Второе задание, вариант 50:
     * Задана последовательность N целых чисел.
     * Вычислить сумму элементов массива, у которых порядковый номер совпадает со значением.
     */
    private static void task2() {
        Random rnd = new Random();
        int n = rnd.nextInt(1, 20);
        int[] N = new int[n];
        int sum = 0;
        for (int i = 0; i < N.length; i++) {
            N[i] = rnd.nextInt(0, 20);
        }
        System.out.println("Your Array N:");
        System.out.println(Arrays.toString(N));

        for (int i = 1; i < N.length; i++) {
            if (N[i] == i + 1)
                sum += N[i];
        }
        System.out.println("The sum of elements whose values match the sequence number: " + sum);
    }

    /**
     * Третье задание, вариант 75:
     * Дана непустая последовательность целых чисел, оканчивающаяся числом 100.
     * Определить, есть ли в последовательности число 77.
     * Если имеются несколько таких чисел, то определить порядковый номер первого из них.
     */
    private static void task3() {
        Random rnd = new Random();
        int n = rnd.nextInt(20, 30);
        int[] A = new int[n];
        A[n - 1] = 100;
        for (int i = 0; i < A.length - 1; i++) {
            A[i] = rnd.nextInt(70, 100);
        }
        System.out.println("Your Array A:");
        System.out.println(Arrays.toString(A));
        var No = true;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 77) {
                System.out.println("There is at least one number that equals 77. And this element №" + (i + 1));
                No = false;
                break;
            }
        }
        if (No) {
            System.out.println("There are no numbers equals 77!");
        }
    }

    /**
     * Четвертое задание, вариант 100:
     * Удалить элемент массива вещественных чисел, который больше первого, но меньше 6-го элементов массива.
     * Если таких элементов нет, выдать сообщение «таких элементов нет», иначе удалить первый найденный элемент.
     */
    private static void task4() {
        Random rnd = new Random();
        int n = rnd.nextInt(6, 20);
        float[] A = new float[n];
        float[] result = new float[A.length - 1];

        for (int i = 0; i < A.length; i++) {
            A[i] = rnd.nextFloat(-10, 10);
        }
        System.out.println("Your Array A:");
        System.out.println(Arrays.toString(A));

        var No = true;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > A[0] && A[i] < A[5]) {
                System.out.println("There is at least one element that > than element №1 and < than element №6. " +
                        "\nThis is " + A[i] + " element №" + (i + 1) +
                        "\nWe will delete it.");
                System.arraycopy(A, 0, result, 0, i);
                System.arraycopy(A, i + 1, result, i, A.length - i - 1);
                System.out.println("New Array:");
                System.out.println(Arrays.toString(result));
                No = false;
                break;
            }
        }
        if (No) {
            System.out.println("There are no element that > than element №1 and < than element №6!");
        }
    }

    /**
     * Пятое задание, вариант 125:
     * Даны вещественные числа а1, а2, ..., an. Среди них есть положительные и отрицательные.
     * Заменить нулями те числа, величина которых по модулю больше максимального числа (|ai| > max {a1, a2, …, an}).
     */
    private static void task5() {
        Random rnd = new Random();
        int n = rnd.nextInt(10, 20);
        float[] A = new float[n];
        for (int i = 0; i < n; i++) {
            A[i] = rnd.nextFloat(-10, 10);
        }
        System.out.println("Your Array A:");
        System.out.println(Arrays.toString(A));

        float max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max)
                max = A[i];
        }
        System.out.println("Max element: " + max);

        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i]) > max)
                A[i] = 0;
        }
        System.out.println("New array where all elements whixh abs > than max element:\n" + Arrays.toString(A));
    }

    public static void main(String[] args) {
        System.out.println("Task 25");
        task1();
        System.out.println("\nTask 50");
        task2();
        System.out.println("\nTask 75");
        task3();
        System.out.println("\nTask 100");
        task4();
        System.out.println("\nTask 125");
        task5();
    }
}
