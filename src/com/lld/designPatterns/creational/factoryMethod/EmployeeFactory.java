package com.lld.designPatterns.creational.factoryMethod;

public class EmployeeFactory {

    public static Employee getEmployee(String empType){
        if(empType.trim().equalsIgnoreCase("Android Developer")){
            return new AndroidDeveloper();
        }else if(empType.trim().equalsIgnoreCase("Full Stack Developer")){
            return new FullStackDeveloper();
        }else{
            return null;
        }
    }

}
