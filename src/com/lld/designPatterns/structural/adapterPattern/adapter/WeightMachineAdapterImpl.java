package com.lld.designPatterns.structural.adapterPattern.adapter;

import com.lld.designPatterns.structural.adapterPattern.adaptee.WeightMachine;

import java.text.DecimalFormat;

public class WeightMachineAdapterImpl implements WeightMachineAdapter{

    WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine){
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg() {
        double weightInPound = weightMachine.getWeightInPound();
        return  Math.round(weightInPound * 0.45 * 1000.0) / 1000.0;
    }
}
