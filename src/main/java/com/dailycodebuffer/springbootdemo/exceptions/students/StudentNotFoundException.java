package com.dailycodebuffer.springbootdemo.exceptions.students;

public class StudentNotFoundException  extends RuntimeException{

    public StudentNotFoundException(String message) {
        super(message);
    }

}
