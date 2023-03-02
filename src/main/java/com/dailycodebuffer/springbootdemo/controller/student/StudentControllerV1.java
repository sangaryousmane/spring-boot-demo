package com.dailycodebuffer.springbootdemo.controller.student;


import com.dailycodebuffer.springbootdemo.models.Student;
import com.dailycodebuffer.springbootdemo.service.students.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
public class StudentControllerV1 {


    public final StudentServiceImpl studentService;

    public StudentControllerV1(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> listAllStudents(){
        return studentService.studentList();
    }

    @GetMapping("/{Id}")
    public Student getStudentById(@PathVariable("Id") String Id){
        return studentService.studentById(Id);
    }

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/deleteStudent/{Id}")
    public String deleteStudent(@PathVariable("Id") String Id){
        return studentService.deleteStudent(Id);
    }
}
