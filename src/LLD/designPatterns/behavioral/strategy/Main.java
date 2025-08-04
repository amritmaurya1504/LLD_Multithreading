package LLD.designPatterns.behavioral.strategy;

/*
    ✅ Purpose of Strategy Pattern
    - To define a family of interchangeable algorithms or behaviors.
    - Enables selecting an algorithm at runtime without modifying the context.
    - Promotes Open/Closed Principle by allowing new strategies without changing existing code.
    - Helps in clean separation of concerns and improves code maintainability.
 */

public class Main {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        UpiPayment upiPayment = new UpiPayment();
        shoppingCart.setPaymentStrategy(upiPayment);
        shoppingCart.pay(2000.0);
    }
}
