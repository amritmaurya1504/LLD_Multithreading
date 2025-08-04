package LLD.designPatterns.behavioral.observer;

/*
    ✅ Purpose of Observer Pattern
    - To define a one-to-many dependency between objects.
    - When the subject changes state, all its observers are notified automatically.
    - Promotes loose coupling between subject (publisher) and observers (subscribers).
    - Useful in event handling systems, real-time notifications, or data binding (e.g., stock updates, UI refresh).
 */


public class Main {
    public static void main(String[] args) {
        StockObservable ps5StockObservable = new Ps5ObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("amritraj@gmail.com", ps5StockObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("rajamrit@gmail.com", ps5StockObservable);
        NotificationAlertObserver observer3 = new EmailAlertObserverImpl("soni@gmail.com", ps5StockObservable);

        ps5StockObservable.add(observer1);
        ps5StockObservable.add(observer2);
        ps5StockObservable.add(observer3);

        ps5StockObservable.setStockCount(10);

    }
}
