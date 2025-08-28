package com.lld.designPatterns.behavioral.command;

public class TurnACOffCommand implements Icommand{
    AirConditioner ac;
    public TurnACOffCommand(AirConditioner ac){
        this.ac = ac;
    }

    @Override
    public void undo() {
        ac.turnOffAc();
    }

    @Override
    public void execute() {
        ac.turnOnAc();
    }
}
