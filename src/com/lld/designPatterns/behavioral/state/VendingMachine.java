package com.lld.designPatterns.behavioral.state;


// Context
public class VendingMachine {
    State state;

    public VendingMachine() {
        state = new IdleState(); // Initial state
    }

    public void setState(State state){
        this.state = state;
    }

    public void insertCoin(){
        state.insertCoin(this);
    }

    public void pressButton(){
        state.pressButton(this);
    }

}
