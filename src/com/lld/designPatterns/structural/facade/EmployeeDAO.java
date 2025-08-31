package com.lld.designPatterns.structural.facade;

public class EmployeeDAO {
    public void insert(){

    }
    public void updateEmployeeName(){

    }
    public Employee getEmployeeDetails(String emailId){
        return new Employee();
    }
    public Employee getEmployeeDetails(int empId){
        return new Employee();
    }
}
