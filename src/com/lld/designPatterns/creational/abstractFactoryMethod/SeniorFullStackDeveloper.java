package com.lld.designPatterns.creational.abstractFactoryMethod;

public class SeniorFullStackDeveloper implements Developer{
    @Override
    public String getRole() {
        return "Senior Full Stack Developer";
    }

    @Override
    public int getSalary() {
        return 100000;
    }
}
