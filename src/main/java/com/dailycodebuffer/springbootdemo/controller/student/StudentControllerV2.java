package com.dailycodebuffer.springbootdemo.controller.student;


import com.dailycodebuffer.springbootdemo.models.Student;
import com.dailycodebuffer.springbootdemo.service.students.StudentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v2/students")
public class StudentControllerV2 {

    private final StudentServiceImpl studentService;

    public StudentControllerV2(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/", produces = {"application/xml", "application/json"})
    public List<Student> studentList(){
        return studentService.studentList();
    }
}
