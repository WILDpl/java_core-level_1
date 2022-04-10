package ru.gb.java_code_level_1;

public class Homework_7 {

    public static void main(String[] args) {

        Plate plate = new Plate(500, rndN(100, 300));
        plate.getFood();

        Cat[] cats = {
                new Cat("Барсик", rndN(5, 60), false),
                new Cat("Мурзик", rndN(5, 60), false),
                new Cat("Пёстрый", rndN(5, 60), false),
                new Cat("Васька", rndN(5, 60), false),
                new Cat("Рыжик", rndN(5, 60), false),
                new Cat("Счастливчик", rndN(5, 60), false),
                new Cat("Лаки", rndN(5, 60), false),
                new Cat("Серый", rndN(5, 60), false),
                new Cat("Шустрик", rndN(5, 60), false),
                new Cat("Котэ", rndN(5, 60), false),
                new Cat("Беляк", rndN(5, 60), false),
                new Cat("Черныш", rndN(5, 60), false),
        };

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            if (!cats[i].isSatiety()) {
                plate.promotionFood(rndN(150, 200));
                i--;
            }
        }

        plate.getFood();

    }

    private static int rndN(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
