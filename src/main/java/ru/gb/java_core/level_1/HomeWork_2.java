package ru.gb.java_core.level_1;

public class HomeWork_2 {

    public static void main(String[] args) {

//        rndN();

        // 1
        System.out.println("-----------");
        System.out.println(checkSumNumInRange(1, 2));
        System.out.println(checkSumNumInRange(1, 12));
        System.out.println(checkSumNumInRange(1, 21));
        System.out.println("-----------");
        // 2
        checkNumPrint(rndN(-10, 10));
        System.out.println("-----------");
        // 3
        System.out.println(checkNum(rndN(-10, 10)));
        System.out.println("-----------");
        // 4
        printStrN("Новая строка", 5);
        System.out.println("-----------");
        // 5*
        System.out.println(checkYear(1980));
        System.out.println(checkYear(1900));
        System.out.println(checkYear(1910));
        System.out.println("-----------");

    }

    // генератор случайного числа в задаваемом диапазоне
    private static int rndN(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    // 1 - проверка суммы двух чисел на вхождение в диапазон от 10 до 20 включительно
    private static boolean checkSumNumInRange(int firstNum, int secondNum) {
        int intSum = firstNum + secondNum;
        return intSum >= 10 && intSum <= 20;
    }

    // 2 - проверка числа на положительное или отрицательное (консоль)
    private static void checkNumPrint(int num) {
        System.out.println(num >= 0);
    }

    // 3 - проверка числа на положительное или отрицательное
    private static boolean checkNum(int num) {
        return num >= 0;
    }

    // 4 - печать строки несколько раз
    public static void printStrN(String str, int count) {
        for (int i = 1; i <= count; i++) {
//            System.out.println(i + "/" + count + ". " +str);
            System.out.printf("%d/%d. %s\n", i, count, str);
        }
    }

    // 5* - определение високосного года
    private static boolean checkYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }

}
