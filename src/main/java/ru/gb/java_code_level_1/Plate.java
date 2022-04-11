package ru.gb.java_code_level_1;

public class Plate {
    private static int volume;
    private int foodAmount;

    public Plate(int volume, int food) {
        Plate.volume = volume; // объем миски
        this.foodAmount = food; // еда в миске
    }

    // метод убывания еды из миски
    public boolean decreaseFood(int amount) {
        if (foodAmount >= amount) { // еда в миске не может уйти в минус
            foodAmount -= amount;
            System.out.printf("Из тарелки убыло еды: -%d (%d/%d). ", amount, foodAmount, volume);
            return true;
        } else {
            System.out.printf("В тарелке слишком мало еды: -%d (%d/%d). ", amount, foodAmount, volume);
            return false;
        }
    }

    // метод добавления еды в миску
    public void promotionFood(int amount) {
        if (volume > foodAmount + amount) { // еды не может быть в миске больше, чем ее объем
            foodAmount += amount;
            System.out.printf("В тарелке прибавилось еды: +%d (%d/%d).\n", amount, foodAmount, volume);
        } else {
            System.out.printf("В тарелку не поместится столько еды: +%d (%d/%d).\n", amount, foodAmount, volume);
        }
    }

    public void getFood() {
        System.out.printf("В тарелке %d/%d еды.\n", foodAmount, volume);
    }

}
