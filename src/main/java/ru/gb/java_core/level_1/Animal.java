package ru.gb.java_core.level_1;

public abstract class Animal extends Object {

    protected String name;
//    protected int distance;
//    int countAnimal;

    public Animal() {
        System.out.println("Animal born!");
    }

    public Animal(String name) {
        this();
        this.name = name;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

}


