package com.dailycodebuffer.springbootdemo.controller.employee;


import com.dailycodebuffer.springbootdemo.models.Employee;
import com.dailycodebuffer.springbootdemo.service.employees.EmployeeV2ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeV2Controller {


    @Qualifier("employeeV2ServiceImpl")
    private final EmployeeV2ServiceImpl employeeV2ServiceImpl;

    public EmployeeV2Controller(EmployeeV2ServiceImpl employeeV2ServiceImpl) {
        this.employeeV2ServiceImpl = employeeV2ServiceImpl;
    }

    @GetMapping("/")
    public List<Employee> employeeList() {
        return employeeV2ServiceImpl.getEmployees();
    }

    @GetMapping("/{Id}")
    public Employee getEmployeeById(@PathVariable(name = "Id") String Id) {
        return employeeV2ServiceImpl.getEmployeeById(Id);
    }

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeV2ServiceImpl.saveEmployee(employee);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee,
                                   @RequestParam(name = "Id") String Id) {
        return employeeV2ServiceImpl.updateEmployee(Id, employee);
    }

    @DeleteMapping("/delete/{Id}")
    public String deleteEmployee(@PathVariable("Id") String Id) {
        return employeeV2ServiceImpl.deleteEmployeeById(Id);
    }
}
