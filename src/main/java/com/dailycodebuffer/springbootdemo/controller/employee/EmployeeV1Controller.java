package com.dailycodebuffer.springbootdemo.controller.employee;
import com.dailycodebuffer.springbootdemo.models.Employee;
import com.dailycodebuffer.springbootdemo.service.employees.EmployeeV1ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeV1Controller {


    @Qualifier("employeeV1ServiceImpl")
    private final EmployeeV1ServiceImpl service;

    public EmployeeV1Controller(EmployeeV1ServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Employee> employeeList() {
        return service.getEmployees();
    }

    @GetMapping("/{Id}")
    public Employee getEmployeeById(@PathVariable(name = "Id") String Id) {
        return service.getEmployeeById(Id);
    }

    @PostMapping("/save")
    public Employee saveStudent(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    @DeleteMapping("/delete/{Id}")
    public String deleteStudentById(@PathVariable(name = "Id") String Id) {
        return service.deleteEmployeeById(Id);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee,
                                   @RequestParam(name = "Id") String Id) {
        return service.updateEmployee(Id, employee);
    }


}
