package LLD.designPatterns.behavioral.strategy;

public class UpiPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("UPI Payment of " + amount + " done!");
    }
}
