
import Maker.CoffeeMachine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:\n" +
                    "1. Buy Coffee\n" +
                    "2. Fill Ingredients\n" +
                    "3. Take Money\n" +
                    "4. Show Ingredients\n" +
                    "5. Analytics\n" +
                    "6. Exit\n");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Choose a coffee:\n" +
                            "1. Espresso\n" +
                            "2. Latte\n" +
                            "3. Cappuccino\n");
                    int coffeeChoice = scanner.nextInt();
                    coffeeMachine.buyCoffee(coffeeChoice);
                    break;
                case 2:
                    System.out.print("Enter the amount of water (in ml): ");
                    int water = scanner.nextInt();
                    System.out.print("Enter the amount of milk (in ml): ");
                    int milk = scanner.nextInt();
                    System.out.print("Enter the amount of beans (in grams): ");
                    int beans = scanner.nextInt();
                    coffeeMachine.fillIngredients(water, milk, beans);
                    break;
                case 3:
                    coffeeMachine.takeMoney();
                    break;
                case 4:
                    coffeeMachine.showIngredients();
                    break;
                case 5:
                    coffeeMachine.showAnalytics();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}
