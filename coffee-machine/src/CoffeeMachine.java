import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;
    Scanner input;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money){
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
        this.input = new Scanner(System.in);
    }

    public void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String buyOrder = input.nextLine();
        switch (buyOrder) {
            case "1": //Espresso
                water -= 250;
                coffeeBeans -= 16;
                disposableCups -= 1;
                money += 4;
                break;
            case "2": // Latte
                water -= 350;
                milk -= 75;
                coffeeBeans -= 20;
                disposableCups -= 1;
                money += 7;
                break;
            case "3": //Cappuccino
                water -= 200;
                milk -= 100;
                coffeeBeans -= 12;
                disposableCups -= 1;
                money += 6;
                break;
            default:
                System.out.println("Not a valid option.");
        }
    }

    public void fill(){
        System.out.println("Write how many ml of water do you want to add:");
        int waterToAdd = input.nextInt();
        water += waterToAdd;

        System.out.println("Write how many ml of milk do you want to add:");
        int milkToAdd = input.nextInt();
        milk += milkToAdd;

        System.out.println("How many grams of coffee beans do you want to add:");
        int beansToAdd = input.nextInt();
        coffeeBeans += beansToAdd;

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cupsToAdd = input.nextInt();
        disposableCups += cupsToAdd;
    }

    public void take(){
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void quantities(){
        System.out.println("The coffee machine has:");
        System.out.println(water + "ml of water");
        System.out.println(milk + "ml of milk");
        System.out.println(coffeeBeans + " grams of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }
}
