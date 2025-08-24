package com.lld.designPatterns.behavioral.observer;

public class EmailAlertObserverImpl implements NotificationAlertObserver{
    private String emailId;
    StockObservable stockObservable;

    public EmailAlertObserverImpl(String emailId, StockObservable stockObservable) {
        this.emailId = emailId;
        this.stockObservable = stockObservable;
    }

    public void setStockObservable(StockObservable stockObservable) {
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        System.out.println("Email sent to " + this.emailId +
                ": Hurry! Product '" + stockObservable.getProductName() + "' is now in stock!");
    }
}
