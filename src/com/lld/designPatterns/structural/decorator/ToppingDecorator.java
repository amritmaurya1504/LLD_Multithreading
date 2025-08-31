package com.lld.designPatterns.structural.decorator;

// Abstract class for all Topping Decorators
// It extends BasePizza so that decorators and pizzas are interchangeable
/*👉 Since ToppingDecorator extends BasePizza, any topping is treated just like a pizza.
That means both a pizza (e.g., Farmhouse) and a topping-wrapped pizza (e.g., ExtraCheese(new Farmhouse())) can be used in the same way.*/
public abstract class ToppingDecorator extends BasePizza { }
