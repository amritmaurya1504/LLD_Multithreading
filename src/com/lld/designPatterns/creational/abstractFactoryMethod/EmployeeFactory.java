package com.lld.designPatterns.creational.abstractFactoryMethod;

public interface EmployeeFactory {
    Developer createJuniorDeveloper();
    Developer createSeniorDeveloper();
}
