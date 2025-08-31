package com.lld.designPatterns.structural.decorator;

// Base abstract class representing a Pizza
// All concrete pizzas and decorators will extend this class
public abstract class BasePizza {
    public abstract int cost();  // Every pizza must define its cost
}

