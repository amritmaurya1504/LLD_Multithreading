package com.lld.designPatterns.behavioral.state;

public class HasCoinState implements State{
    public void insertCoin(VendingMachine machine) {
        System.out.println("Coin already inserted!");
    }
    public void pressButton(VendingMachine machine) {
        System.out.println("Button pressed. Dispensing item...");
        machine.setState(new DispenseState());
    }
}
