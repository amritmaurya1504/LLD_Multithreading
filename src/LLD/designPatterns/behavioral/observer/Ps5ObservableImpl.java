package LLD.designPatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Ps5ObservableImpl implements StockObservable{
    public List<NotificationAlertObserver> observerList;
    public int stockCount;
    public String productName;

    public Ps5ObservableImpl(){
        this.observerList = new ArrayList<>();
        this.stockCount = 0;
        this.productName = "PS5";
    }

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void setStockCount(int count) {
        this.stockCount = stockCount + count;
        if(stockCount > 0){
            notifySubscribers();
        }
    }

    @Override
    public String getProductName() {
        return this.productName;
    }

    @Override
    public void notifySubscribers() {
        for (NotificationAlertObserver notificationAlertObserver : observerList){
            notificationAlertObserver.update();
        }
    }


}
