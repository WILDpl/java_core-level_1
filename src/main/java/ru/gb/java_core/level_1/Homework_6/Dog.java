package ru.gb.java_core.level_1.Homework_6;

public class Dog extends Animal {

    private static final String kind = "Dog";
    private static int countDog = 0;

    public Dog(String name) {
        super(name);
        countDog++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.printf(kind + " %s run " + distance + "m \n", name);
        } else {
            System.out.printf(kind + " %s can't run " + distance + "m (only 500 m)\n", name);
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.printf(kind + " %s swim " + distance + "m \n", name);
        } else {
            System.out.printf(kind + " %s can't swim " + distance + "m (only 10 m)\n", name);
        }
    }

    public static int getCountDog() {
        return countDog;
    }
}
