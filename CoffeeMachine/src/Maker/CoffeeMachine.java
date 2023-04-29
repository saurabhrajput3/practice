package Maker;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int money;
    private int espressoCount;
    private int latteCount;
    private int cappuccinoCount;

    public CoffeeMachine() {
        this.water = 1000;
        this.milk = 1000;
        this.beans = 1000;
        this.money = 1000;
        this.espressoCount = 1000;
        this.latteCount = 1000;
        this.cappuccinoCount = 1000;
    }

    public void fillIngredients(int water, int milk, int beans) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
    }

    public void takeMoney() {
        System.out.println("Money collected: $" + this.money);
        this.money = 0;
    }

    public void showIngredients() {
        System.out.println("Ingredients in Coffee Machine:\n" +
                "Water: " + this.water + " ml\n" +
                "Milk: " + this.milk + " ml\n" +
                "Beans: " + this.beans + " grams");
    }

    public void showAnalytics() {
        System.out.println("Coffee Sales Analytics:\n" +
                "Espresso: " + this.espressoCount + " cups\n" +
                "Latte: " + this.latteCount + " cups\n" +
                "Cappuccino: " + this.cappuccinoCount + " cups\n" +
                "Money earned: $" + this.money + "\n" +
                "Ingredients used:\n" +
                "Water: " + (this.espressoCount * 250 + this.latteCount * 350 + this.cappuccinoCount * 200) + " ml\n" +
                "Milk: " + (this.latteCount * 75 + this.cappuccinoCount * 100) + " ml\n" +
                "Beans: " + (this.espressoCount * 16 + this.latteCount * 20 + this.cappuccinoCount * 12) + " grams");
    }

    public void buyCoffee(int choice) {
        switch (choice) {
            case 1:
                if (this.water < 250 || this.beans < 16) {
                    System.out.println("Error: Not enough ingredients to make Espresso!");
                } else {
                    System.out.println("Dispensing Espresso...");
                    this.water -= 250;
                    this.beans -= 16;
                    this.money += 4;
                    this.espressoCount++;
                }
                break;
            case 2:
                if (this.water < 350 || this.milk < 75 || this.beans < 20) {
                    System.out.println("Error: Not enough ingredients to make Latte!");
                } else {
                    System.out.println("Dispensing Latte...");
                    this.water -= 350;
                    this.milk -= 75;
                    this.beans -= 20;
                    this.money += 7;
                    this.latteCount++;
                }
                break;
            case 3:
                if (this.water < 200 || this.milk < 100 || this.beans < 12) {
                    System.out.println("Error: Not enough ingredients to make Cappuccino!");
                } else {
                    System.out.println("Dispensing Cappuccino...");
                    this.water -= 200;
                    this.milk -= 100;
                    this.beans -= 12;
                    this.money += 6;
                    this.cappuccinoCount++;
                }
        }
    }
}
