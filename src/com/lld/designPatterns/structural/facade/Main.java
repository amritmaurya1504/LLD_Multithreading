package com.lld.designPatterns.structural.facade;

/* When we have to hide system complexity from the client we use facade design pattern
* client interact with facade layer and facade layer interact with complex system, and you should
* not enforce client to always interact with facade client can directly use any components as well
* */

public class Main {
    public static void main(String[] args) {
        System.out.println("Facade Design Pattern !");
        EmployeeFacade employeeFacade = new EmployeeFacade();
        Employee employee = employeeFacade.getEmployeeDetails(123);
    }
}
