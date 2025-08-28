package com.lld.designPatterns.behavioral.state;

public class DispenseState implements State {
    public void insertCoin(VendingMachine machine) {
        System.out.println("Wait! Dispensing in progress...");
    }
    public void pressButton(VendingMachine machine) {
        System.out.println("Item dispensed. Thank you!");
        machine.setState(new IdleState()); // Reset back to Idle
    }
}
