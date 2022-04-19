package ru.gb.java_core.level_1.Homework_6;

public abstract class Animal extends Object {

    protected String name;
    private static int countAnimal = 0;
//    protected int distance;
//    int countAnimal;

    public Animal() {
        System.out.println("Animal born!");
        countAnimal++;
    }

    public Animal(String name) {
        this();
        this.name = name;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static int getCountAnimal() {
        return countAnimal;
    }
}


