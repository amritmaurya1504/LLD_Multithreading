package com.lld.designPatterns.structural.adapterPattern.adaptee;

public class WeightMachineForBabies implements WeightMachine{
    @Override
    public double getWeightInPound() {
        return 28.9;
    }
}
