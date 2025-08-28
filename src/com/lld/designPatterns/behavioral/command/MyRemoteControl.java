package com.lld.designPatterns.behavioral.command;

import java.util.Stack;

// Invoker
public class MyRemoteControl {
    Icommand icommand;
    Stack<Icommand> acCommandHistory = new Stack<>();


    public void setIcommand(Icommand icommand){
        this.icommand = icommand;
    }

    public void pressButton(){
        icommand.execute();
        acCommandHistory.push(icommand);
    }

    public void undo(){
        if(!acCommandHistory.isEmpty()){
            Icommand lastCommand = acCommandHistory.pop();
            lastCommand.undo();
        }
    }
}
