package com.lld.designPatterns.behavioral.state;


/*
*
* 🎯 Real-World Problem
    - A vending machine behaves differently depending on its state:
    - Idle (No Coin) → Only allows inserting a coin.
    - Has Coin → Allows pressing the button to get an item.
    - Dispensing → Gives the item, then goes back to Idle.

    * If we don’t use State Pattern, we’ll end up with lots of if-else
    checks inside every method. That makes code hard to maintain.
    *
    *
    * ✅ State Pattern Solution
    - Instead of using conditionals, we represent each state as a class.
    - The VendingMachine (context) holds a reference to the current state.
    - Each State class defines behavior for insertCoin() and pressButton().
    - The machine switches states as actions happen.
    *
    *
    ✅ Interview Explanation
    “In State Pattern, every concrete state class implements the same interface,
    so that the context doesn’t need to check conditions. Even if a method doesn’t
    apply in a certain state, it’s still implemented — typically as a no-op or error message.
    This keeps the context code clean and fully delegates behavior to states.”
* */

public class Client {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        machine.pressButton();
        machine.insertCoin();
        machine.insertCoin();
        machine.pressButton();
        machine.pressButton();
    }
}
