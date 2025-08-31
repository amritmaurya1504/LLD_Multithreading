package com.lld.designPatterns.structural.facade;

public class EmployeeFacade {
    EmployeeDAO employeeDAO;

    public EmployeeFacade(){
        employeeDAO = new EmployeeDAO();
    }

    public void insert(){
        employeeDAO.insert();
    }

    public Employee getEmployeeDetails(int empId){
        return new Employee();
    }
}
