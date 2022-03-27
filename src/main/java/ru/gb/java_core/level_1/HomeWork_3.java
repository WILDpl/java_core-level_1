package ru.gb.java_core.level_1;

import java.util.Arrays;
import java.util.Random;

public class HomeWork_3 {

    public static void main(String[] args) {

        // 1
//        System.out.println("-----------");
//        int[] arrZeroOne = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
//        changeInArrayZeroOne(arrZeroOne);
//        System.out.println("-----------");

        // 2
//        int[] arrFill = new int[100];
//        arrayFullFill(arrFill);
//        System.out.println("-----------");

        // 3
//        int[] arrXTwo = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
//        changeInArrayXTwo(arrXTwo);
//        System.out.println("-----------");

        // 4
//        createArrayXSquare(8);
//        System.out.println("-----------");

        // 5
//        System.out.println(Arrays.toString(createArrayFill(6, "*")));
//        System.out.println("-----------");

        // 6*
//        int[] arrMinMax = createArrayWithRandomValuesRange(10, -100, 100);
//        arrayMinMax(arrMinMax);
//        System.out.println("-----------");

        // 7**
        int[] arrBalance = createArrayWithRandomValuesRange(8, -10, 10);
        // фиксированные примеры положительных результатов
//        int[] arrBalance = {2, 2, 2, 1, 2, 2, 10, 1}; // true
//        int[] arrBalance = {6, 4, 5, 6, 9, -5, -8, -5}; // true
//        int[] arrBalance = {6, 9, 1, 2, 8, 5, 3, -2}; // true
//        int[] arrBalance = {8, 7, -3, -1, 3, -6, 9, -1}; // true
//        int[] arrBalance = {1, -1, -5, 2, -8, -6, 3, 4}; // true
        System.out.println(Arrays.toString(arrBalance));

        int arrSum = 0;
        boolean result = false;
        int sum = 0;
        int sumI = 0;

        for (int i = 0; i < arrBalance.length; i++) {
            arrSum += arrBalance[i];
        }
        System.out.println("Сумма массива: " + arrSum);
        System.out.println("Сумма массива / 2: " + arrSum / 2);
        System.out.println();

        for (int i = 0; i < arrBalance.length; i++) {
            sum += arrBalance[i];
//            if (arrSum % 2 == 0 && sum < arrSum / 2) {
//                sumI = -1;
//            } else if (arrSum % 2 == 0 && sum == arrSum / 2) {
//                sumI = i;
//                result = true;
//                break;
//            } else if (arrSum % 2 != 0 || sum > arrSum / 2) {
//                sumI = -1;
//                break;
//            } else {
//                sumI = -1;
//            }
            if (arrSum % 2 == 0 && sum == arrSum / 2) {
                sumI = i;
                result = true;
                break;
            } else {
                sumI = -1;
            }
        }

        System.out.println("Сумма подсчитываемых элементов массива: " + sum);
        System.out.println("Элемент стопа: " + sumI);
        System.out.println("Результат: " + result);
        System.out.println();

        int[] arrBalanceFillStart = new int[sumI + 1];
        System.arraycopy (arrBalance, 0, arrBalanceFillStart, 0, sumI + 1);
//        System.out.println(Arrays.toString(arrBalanceFillStart));

        int[] arrBalanceFillFinish = new int[arrBalance.length - sumI - 1];
        System.arraycopy (arrBalance, sumI + 1, arrBalanceFillFinish, 0, arrBalance.length - sumI - 1);
//        System.out.println(Arrays.toString(arrBalanceFillFinish));

        System.out.println(Arrays.toString(arrBalanceFillStart) + "|||" + Arrays.toString(arrBalanceFillFinish));
    }



    // генератор массива заданной длинны с заполнением значениями из заданного диапазона
    public static int[] createArrayWithRandomValuesRange(int length, int lowBound, int highBound) {
        int range = highBound - lowBound;
        int[] arr = new int[length];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = lowBound + random.nextInt(range) + 1;
        }

        return  arr;
    }

    // 7** -

    // 6* - найти минимальный и максимальный элемент массива
    private static void arrayMinMax(int[] arr) {
        int min = arr[0];
        int max = min;
        int minI = 0;
        int maxI = minI;

         for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minI = i;
            } else if (max < arr[i]) {
                max = arr[i];
                maxI = i;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.printf("Минимальный элемент массива: %d [%d]\nМаксимальный элемент массива: %d [%d]\n", minI, min, maxI, max);
    }

    // 5 - создать одноменый массив и заполнить заданными значениями
    private static String[] createArrayFill(int length, String value) {
        String[] arr = new String[length];

        for (int i = 0; i < length; i++) {
            arr[i] = value;
        }
        return arr;
    }

    // 4 - создать квадратный двумерный массив и заполнить диагонали единицами 1, остальное, например, 0
    private static void createArrayXSquare(int length) {
        int[][] arr = new int[length][length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j || arr.length - i - 1 == j) {
                    arr[i][j] = 1;
                }
            System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // 3 - проверить массив и умножить на 2 значения меньше 6
    private static void changeInArrayXTwo(int[] arr) {
        System.out.println("Before:\t" + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println("After:\t" + Arrays.toString(arr));
    }

    // 2 - заполнить пустой массив размером 100 значениями 1..100
    private static void arrayFullFill(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i + 1;
//        }
        for (int i = 0, j = 1; i < arr.length; i++, j++) {
            arr[i] = j;
        }
        System.out.println(Arrays.toString(arr));
    }

    // 1 - инвертировать в массиве (0 в 1) и (1 в 0)
    private static void changeInArrayZeroOne(int[] arr) {
        System.out.println("Before:\t" + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
//            switch (arr[i]) {
//                case 0:
//                    arr[i] = 1;
//                    break;
//                case 1:
//                    arr[i] = 0;
//                    break;
//            }
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println("After:\t" + Arrays.toString(arr));
    }

}
