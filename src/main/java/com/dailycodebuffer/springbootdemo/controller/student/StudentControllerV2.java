package com.dailycodebuffer.springbootdemo.controller.student;


import com.dailycodebuffer.springbootdemo.models.Student;
import com.dailycodebuffer.springbootdemo.service.students.StudentServiceV2Impl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/students")
public class StudentControllerV2 {


    // TODO: The @Qualifier annotation qualifies which implementation class to use
    @Qualifier("studentServiceV2Impl")
    private final StudentServiceV2Impl studentService;

    public StudentControllerV2(StudentServiceV2Impl studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/",
            produces = {"application/xml", "application/json"})
    public List<Student> studentList() {
        return studentService.studentList();
    }

    @PostMapping("/save")
    public Student saveStudentEntity(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/{Id}")
    public Student getStudentByIdEntity(@PathVariable("Id") String Id) {
        return studentService.studentById(Id);
    }

    @DeleteMapping("/{Id}")
    public String deleteStudentById(@PathVariable("Id") String Id) {
        return studentService.deleteStudent(Id);
    }

    @PutMapping("/update")
    public Student updateStudentEntity(@RequestBody Student entity,
                                       @RequestParam(name = "id") String id) {
        return studentService.updateStudent(entity, id);
    }
}
