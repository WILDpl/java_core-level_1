package ru.gb.java_core.level_1.Homework_6;

public class Cat extends Animal {

    private static final String kind = "Cat";
    private static int countCat = 0;

    public Cat(String name) {
        super(name);
        countCat++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.printf(kind + " %s run " + distance + "m \n", name);
        } else {
            System.out.printf(kind + " %s can't run " + distance + "m (only 200 m)\n", name);
        }
    }

    @Override
    public void swim(int distance) {
        System.out.printf(kind + " %s can't swim!\n", name);
    }

    public static int getCountCat() {
        return countCat;
    }
}
