public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(1200,540,120,9,550);

        coffeeMachine.buy();
        coffeeMachine.fill();
        coffeeMachine.quantities();
        coffeeMachine.take();
        coffeeMachine.quantities();
    }
}
