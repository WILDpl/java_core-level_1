package ru.gb.java_code_level_1;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;


    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    // метод кормления кота
    public void eat(Plate plate) {
        if (plate.decreaseFood(appetite)) {  // кормим кота с определенным аппетитом из миски
            this.satiety = true;
            System.out.printf("Кот %s съел %d еды. %s сыт.\n", name, appetite, name);
        } else {
            System.out.printf("Кот %s голоден!\n", name);
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

}