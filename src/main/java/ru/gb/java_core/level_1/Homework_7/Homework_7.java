package ru.gb.java_core.level_1.Homework_7;

public class Homework_7 {

    public static void main(String[] args) {

        // создаем миску определенного объема и наполняем рандомным количеством еды
        Plate plate = new Plate(500, rndN(100, 300));
        plate.getFood(); // информация о количестве еды в миске

        // создаем массив голодных котов с рандомным аппетитом
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

        // цикл по массиву котов - кормим, проверяем сытость, если кому-то не хватило еды,
        // насыпаем в миску рандомное количество еды и заново кормим голодного кота,
        // пока все коты не будут сыты
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate); // кормим кота
            if (!cats[i].isSatiety()) { // если не сыт
                plate.promotionFood(rndN(150, 200)); // добавляем еду в миску
                i--; // заново кормим кота
            }
        }

        plate.getFood(); // информация о количестве еды в миске

    }

    // генератор случайных чисел в заданном диапазоне
    private static int rndN(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
