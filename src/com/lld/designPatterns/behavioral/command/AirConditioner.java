package com.lld.designPatterns.behavioral.command;

// Receiver
public class AirConditioner {

    boolean isOn;
    int temperature;

    public void turnOnAc(){
        this.isOn = true;
        System.out.println("AC is ON");
    }

    public void turnOffAc(){
        this.isOn = false;
        System.out.println("AC is OFF");
    }

    public void setTemperature(int temp){
        this.temperature = temp;
        System.out.println("Temperature changed to: " + this.temperature);
    }

}
