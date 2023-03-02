package com.dailycodebuffer.springbootdemo.exceptions.employees;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
