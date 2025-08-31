package com.lld.designPatterns.structural.decorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Decorator design pattern!");

        BasePizza basePizza = new Mushroom(new ExtraCheese(new Margherita()));
        System.out.println(basePizza.cost());
    }
}
