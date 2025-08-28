package com.lld.designPatterns.behavioral.command;

/*
    ✅ Purpose of Command Pattern
    - To encapsulate a request as an object, thereby decoupling sender and receiver.
    - Allows logging, queuing, and undoing of operations.
    - Promotes loose coupling and adheres to the Open/Closed Principle.
    - Ideal for scenarios like remote controls, task scheduling, and transactional operations.

    - Command design pattern divide logic in three parts -> receiver, invoker and command
    Client invoke and invoker generated command and command is received by receiver
 */

public class Client {
    public static void main(String[] args) {
        System.out.println("Command Design Pattern!");

        AirConditioner ac = new AirConditioner();
        MyRemoteControl remote = new MyRemoteControl();

        remote.setIcommand(new TurnACOnCommand(ac));
        remote.pressButton();
        remote.undo();
    }
}

/*
*  Client has invoker and invoker has command and there are different concrete class of command
* and command has receiver ----- This is Command Design Pattern
*
* */
