package ru.gb.java_core.level_1;

public class Homework {

    public static void main(String[] args) {

        Animal cat = new Cat("Barsik");
        cat.run(100);
        cat.run(300);
        cat.swim(50);

        System.out.println();

        Animal dog = new Dog("Bobik");
        dog.run(200);
        dog.run(600);
        dog.swim(5);
        dog.swim(15);

        System.out.println();

        Animal[] cats = {
            new Cat("Murzik"),
            new Cat("Vasbka"),
        };

        System.out.println();

        Animal[] dogs = {
                new Dog("Druzhok"),
                new Dog("Zhuchka"),
                new Dog("Sharik"),
        };

        System.out.println();

        System.out.println("Born of animals: " + Animal.getCountAnimal());
        System.out.println("Born of cats: " + Cat.getCountCat());
        System.out.println("Born of dogs " + Dog.getCountDog());

    }


}
