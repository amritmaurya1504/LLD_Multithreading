package LLD.designPatterns.behavioral.strategy;

public class CreditCardPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Credit Card payment of " + amount + " done!");
    }
}
