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
        int water = 200;
        int milk = 50;
        int coffeeBeans = 15;

        System.out.println("Write how many cups of coffee you will need: ");

        int coffeeNeeded = input.nextInt();

        System.out.println("For " + coffeeNeeded + " cups of coffee you will need:");
        System.out.println((water * coffeeNeeded) + " ml of water");
        System.out.println((milk * coffeeNeeded) + " ml of milk");
        System.out.println((coffeeBeans * coffeeNeeded) + " g of coffee beans");
    }
}
