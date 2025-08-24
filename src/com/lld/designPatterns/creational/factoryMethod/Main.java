package com.lld.designPatterns.creational.factoryMethod;
/*
✅ Purpose of Factory Method
    - To encapsulate object creation logic.
    - Allows subclasses or factory classes to decide which class to instantiate.
    - Promotes loose coupling and follows the Open/Closed Principle (OCP).

    Why not good :
    - Every time a new developer role is added (e.g., MLDeveloper),
      you must modify the factory, violating Open/Closed Principle.
 */
public class Main {
    public static void main(String[] args) {
        Employee employee = EmployeeFactory.getEmployee("" +
                "Android Developer");
        employee.role();

        Employee employee1 = EmployeeFactory.getEmployee("" +
                "Full Stack Developer");
        employee1.role();
    }
}
