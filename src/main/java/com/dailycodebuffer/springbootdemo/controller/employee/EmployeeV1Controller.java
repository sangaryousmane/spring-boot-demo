package com.dailycodebuffer.springbootdemo.controller.employee;

import com.dailycodebuffer.springbootdemo.models.Admin;
import com.dailycodebuffer.springbootdemo.service.employees.EmployeeV1ServiceImpl;
import com.dailycodebuffer.springbootdemo.service.employees.EmployeeV2ServiceImpl;
import com.dailycodebuffer.springbootdemo.models.Employee;
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


}
