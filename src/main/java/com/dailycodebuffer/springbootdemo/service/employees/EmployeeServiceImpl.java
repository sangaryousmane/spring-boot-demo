package com.dailycodebuffer.springbootdemo.service.employees;

import com.dailycodebuffer.springbootdemo.entities.Admin;
import com.dailycodebuffer.springbootdemo.entities.Employee;
import com.dailycodebuffer.springbootdemo.service.employees.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl
        implements EmployeeService {

    List<Employee> employees = new ArrayList<>();
    List<Admin> adminList = new ArrayList<>();

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }


    @Override
    public Employee saveEmployee(Employee employee) {

        if (employee.getEmployeeId() == null ||
                employee.getEmailId().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Admin> adminList() {
        return adminList;
    }

    @Override
    public Admin addAdmin(Admin admin) {
        adminList.add(admin);
        System.out.println("ADDED SUCCESSFULLY");
        return admin;
    }

    @Override
    public Employee getEmployeeById(String Id) {
        return employees
                .stream()
                .filter(employee -> employee.getEmployeeId().equals(Id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        "Ouch! the employee Id doesn't exist " + Id
                ));
    }

    @Override
    public String deleteEmployeeById(String Id) {
        Employee employee = employees.stream()
                .filter(e -> e.getEmployeeId().equals(Id))
                .findFirst()
                .get();

        employees.remove(employee);
        return "Employee with Id " + employee.getEmployeeId() + " has been removed successfully";
    }


}


// https://docs.google.com/document/d/1ymYXuZ6x0SbO_zmEAeTLOs23Sj4Xpwz46cBybJzsvrA/edit?usp=sharing