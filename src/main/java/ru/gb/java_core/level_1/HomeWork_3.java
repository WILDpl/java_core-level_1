package ru.gb.java_core.level_1;

import java.util.Arrays;

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
        System.out.println(Arrays.toString(createArrayFill(6, "*")));



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
