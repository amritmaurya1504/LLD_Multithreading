package com.lld.designPatterns.behavioral.observer;

public interface StockObservable {
    void add(NotificationAlertObserver observer);
    void remove(NotificationAlertObserver observer);
    void notifySubscribers();
    void setStockCount(int count);
    String getProductName();

}
