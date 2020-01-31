import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");

        Scanner input = new Scanner(System.in);

        //Amount of each ingredient per cup
        int waterNeeded = 200;
        int milkNeeded = 50;
        int beansNeeded = 15;

/*
        System.out.println("Write how many cups of coffee you will need: ");

        int coffeeNeeded = input.nextInt();

        System.out.println("For " + coffeeNeeded + " cups of coffee you will need:");
        System.out.println((waterNeeded * coffeeNeeded) + " ml of water");
        System.out.println((milkNeeded * coffeeNeeded) + " ml of milk");
        System.out.println((beansNeeded * coffeeNeeded) + " g of coffee beans");
*/

        System.out.println("Write how many ml of water the coffee machine has:");
        int currentWater = input.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int currentMilk = input.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int currentBeans = input.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cupsNeeded = input.nextInt();

        int waterCups = currentWater > waterNeeded ? currentWater / waterNeeded : 0;
        int milkCups = currentMilk > milkNeeded ? currentMilk / milkNeeded : 0;
        int beansCups = currentBeans > beansNeeded ? currentBeans / beansNeeded : 0;


        int minCups = Math.min(waterCups, Math.min(milkCups, beansCups));

        if(minCups < cupsNeeded){
            System.out.println("No, I can make only " + minCups + " cups(s) of coffee" );
        }
        else if(minCups > cupsNeeded){
            System.out.println("Yes, I can make that amount of coffee ( and even " + (minCups - cupsNeeded) + " more than that)");
        }
        else{
            System.out.println("Yes, I can make that amount of coffee");
        }
    }
}
