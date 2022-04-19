package ru.gb.java_core.level_1.Homework_1;

public class HomeWork_1 {

    // 1
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    // 2 - три слова в столбик
    private static void printThreeWords() {
        System.out.println("-----------");
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
        System.out.println("-----------");
    }

    // 3 - сумма случайных чисел
    private static void checkSumSign() {
        int a = (int) (Math.random() * -10);
        int b = (int) (Math.random() * 10);
        int c = a + b;

        if (c > 0) {
            System.out.println("Сумма положительная: " + c);
        } else if (c == 0) {
            System.out.println("Сумма равна нулю: " + c);
        } else {
            System.out.println("Сумма отрицательная: " + c);
        }

        System.out.println("-----------");
    }

    //4 - случайный цвет
    private static void printColor() {
        int value = (int) (Math.random() * 100) - (int) (Math.random() * 100) + (int) (Math.random() * 100);

        if (value <= 0) {
            System.out.println("Красный (" + value + ")" );
        } else if (value <= 100) {
            System.out.println("Желтый (" + value + ")" );
        } else {
            System.out.println("Зеленый (" + value + ")" );
        }

        System.out.println("-----------");
    }

    //5 - сравнение двух случайных чисел
    private static void compareNumbers() {
        int a = (int) (Math.random() * 100);
        int b = (int) (Math.random() * 100);

        if (a >= b) {
            System.out.println("a >= b: (" + a + " >= " + b + ")");
        } else {
            System.out.println("a < b: (" + a + " < " + b + ")");
        }

        System.out.println("-----------");
    }


}
