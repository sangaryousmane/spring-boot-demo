package com.dailycodebuffer.springbootdemo.service.employees;

import com.dailycodebuffer.springbootdemo.models.Admin;
import com.dailycodebuffer.springbootdemo.models.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee saveEmployee(Employee employee);
    List<Admin> adminList();
    Admin addAdmin(Admin admin);
    Employee getEmployeeById(String Id);
    String deleteEmployeeById(String Id);
    Employee updateEmployee(String Id, Employee employee);
}
