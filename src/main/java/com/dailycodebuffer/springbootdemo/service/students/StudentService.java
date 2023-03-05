package com.dailycodebuffer.springbootdemo.service.students;


import com.dailycodebuffer.springbootdemo.models.Student;

import java.util.List;

public interface StudentService {


    List<Student> studentList();
    Student studentById(String Id);
    Student saveStudent(Student student);
    String deleteStudent(String Id);

    Student updateStudent(Student student, String id);
}
