package ru.gb.java_core.level_1;

import java.util.Arrays;

public class HomeWork_3 {

    public static void main(String[] args) {

        // 1
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        changeInArrayZeroOne(arr);

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
