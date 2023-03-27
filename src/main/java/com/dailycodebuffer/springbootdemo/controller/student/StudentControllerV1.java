package com.dailycodebuffer.springbootdemo.controller.student;


import com.dailycodebuffer.springbootdemo.models.jpa.Student;
import com.dailycodebuffer.springbootdemo.service.students.StudentServiceV1Impl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
public class StudentControllerV1 {


    @Qualifier("studentServiceV1Impl")
    public final StudentServiceV1Impl studentService;


    public StudentControllerV1(StudentServiceV1Impl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> listAllStudents() {
        return studentService.studentList();
    }

    @GetMapping("/{Id}")
    public Student getStudentById(@PathVariable("Id") String Id) {
        return studentService.studentById(Id);
    }

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/deleteStudent/{Id}")
    public String deleteStudent(@PathVariable("Id") String Id) {
        return studentService.deleteStudent(Id);
    }
}
