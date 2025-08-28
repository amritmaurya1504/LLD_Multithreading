package com.lld.designPatterns.behavioral.state;

public interface State {
    public void insertCoin(VendingMachine machine);
    public void pressButton(VendingMachine machine);
}
