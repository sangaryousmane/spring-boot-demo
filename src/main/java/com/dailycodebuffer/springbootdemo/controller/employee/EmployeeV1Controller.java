package com.dailycodebuffer.springbootdemo.controller.employee;

import com.dailycodebuffer.springbootdemo.models.Admin;
import com.dailycodebuffer.springbootdemo.service.employees.EmployeeServiceImpl;
import com.dailycodebuffer.springbootdemo.models.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeV1Controller {


    private final EmployeeServiceImpl service;

    public EmployeeV1Controller(EmployeeServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Employee> getEmployeeList() {
       return service.getEmployees();
    }


    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }


    // Adding admin
    @PostMapping("/addAdmin")
    public Admin addAdministrator(@RequestBody Admin admin){
        return service.addAdmin(admin);
    }

    // Return all administrators
    @GetMapping("/administrators")
    public List<Admin> addAdministrators(){
        return service.adminList();
    }

    // Select an employee by ID
    @GetMapping(path = "/{Id}")
    public Employee getEmployeeById(@PathVariable("Id") String Id){
        return service.getEmployeeById(Id);
    }

    // Delete employee by id
    @DeleteMapping("/{Id}")
    public String deleteEmployeeById(@PathVariable("Id") String Id){
        return service.deleteEmployeeById(Id);
    }
}
