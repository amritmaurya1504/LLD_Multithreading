package com.lld.designPatterns.structural.adapterPattern;

import com.lld.designPatterns.structural.adapterPattern.adaptee.WeightMachineForBabies;
import com.lld.designPatterns.structural.adapterPattern.adapter.WeightMachineAdapter;
import com.lld.designPatterns.structural.adapterPattern.adapter.WeightMachineAdapterImpl;

public class Client {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(
                new WeightMachineForBabies()
        );

        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
