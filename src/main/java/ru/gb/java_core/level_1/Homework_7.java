package ru.gb.java_core.level_1;

public class Homework_7 {

    public static void main(String[] args) {

        // создаем миску определенного объема и наполняем рандомным количеством еды
        Plate plate = new Plate(500, rndN(100, 300));
        plate.getFood(); // информация о количестве еды в миске

        // создаем массив голодных котов с рандомным аппетитом
        Cats[] cats = {
                new Cats("Барсик", rndN(5, 60), false),
                new Cats("Мурзик", rndN(5, 60), false),
                new Cats("Пёстрый", rndN(5, 60), false),
                new Cats("Васька", rndN(5, 60), false),
                new Cats("Рыжик", rndN(5, 60), false),
                new Cats("Счастливчик", rndN(5, 60), false),
                new Cats("Лаки", rndN(5, 60), false),
                new Cats("Серый", rndN(5, 60), false),
                new Cats("Шустрик", rndN(5, 60), false),
                new Cats("Котэ", rndN(5, 60), false),
                new Cats("Беляк", rndN(5, 60), false),
                new Cats("Черныш", rndN(5, 60), false),
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
