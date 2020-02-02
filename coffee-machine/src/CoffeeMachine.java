import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;
    private boolean isMachineOn;
    private Scanner input;
    Status currentStatus;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money){
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
        this.isMachineOn = true;
        this.input = new Scanner(System.in);
        this.currentStatus = Status.CHOOSING;
    }

    void machineOn(){
        while (isMachineOn){
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = input.next();
            switch (action) {
                case "buy":
                    buy();
                    currentStatus = Status.BUYING;
                    break;
                case "fill":
                    fill();
                    currentStatus = Status.FILLING;
                    break;
                case "take":
                    take();
                    currentStatus = Status.TAKING;
                    break;
                case "remaining":
                    quantities();
                    currentStatus = Status.REMAINING;
                    break;
                case "exit":
                    exit();
                    currentStatus = Status.EXITING;
                    break;
            }
        }
    }
    private void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String buyOrder = input.next();
        switch (buyOrder) {
            case "1":
                if (canMakeCoffee(250, 16, 16)) {
                    water -= 250;
                    coffeeBeans -= 16;
                    disposableCups--;
                    money += 4;
                }
                break;
            case "2":
                if (canMakeCoffee(350, 75, 20)) {
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    disposableCups--;
                    money += 7;
                }
                break;
            case "3":
                if (canMakeCoffee(200, 100, 12)) {
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    disposableCups--;
                    money += 6;
                }
                break;
            case "back":
                break;
            default:
                System.out.println("Not a valid option.");
                break;
        }
    }

    private boolean canMakeCoffee(int waterNeeded, int milkNeeded, int coffeeBeansNeeded){
        currentStatus = Status.CHOOSING;
        if (water >= waterNeeded) {
            if (milk >= milkNeeded) {
                if (coffeeBeans >= coffeeBeansNeeded) {
                    if(disposableCups > 0){
                        System.out.println("I have enough resources, making you a coffee!");
                        return true;
                    }
                    else{
                        System.out.println("Sorry, not enough disposable cups!");
                        return false;
                    }
                } else {
                    System.out.println("Sorry, not enough beans!");
                    return false;
                }

            } else {
                System.out.println("Sorry, not enough milk!");
                return false;
            }
        } else {
            System.out.println("Sorry, not enough water!");
            return false;
        }
    }

    private void fill(){
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

        currentStatus = Status.CHOOSING;
    }

    private void take(){
        System.out.println("I gave you $" + money);
        money = 0;

        currentStatus = Status.CHOOSING;
    }

    private void quantities(){
        System.out.println("The coffee machine has:");
        System.out.println(water + "ml of water");
        System.out.println(milk + "ml of milk");
        System.out.println(coffeeBeans + " grams of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
        currentStatus = Status.CHOOSING;
    }

    private void exit(){
        isMachineOn = false;
    }
}
