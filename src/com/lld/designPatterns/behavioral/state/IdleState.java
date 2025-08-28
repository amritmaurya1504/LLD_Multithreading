package com.lld.designPatterns.behavioral.state;

public class IdleState implements State{
    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("Coin inserted. Waiting for button press...");
        machine.setState(new HasCoinState());
    }

    @Override
    public void pressButton(VendingMachine machine) {
        System.out.println("Insert a coin first!");
    }
}
