package com.lld.designPatterns.behavioral.command;

public class TurnACOnCommand implements Icommand{

    AirConditioner ac;
    public TurnACOnCommand(AirConditioner ac){
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOnAc();
    }

    @Override
    public void undo() {
        ac.turnOffAc();
    }
}
