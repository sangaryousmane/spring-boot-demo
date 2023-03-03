package com.dailycodebuffer.springbootdemo.service.students;

import com.dailycodebuffer.springbootdemo.models.Student;
import com.dailycodebuffer.springbootdemo.exceptions.students.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceV1Impl implements StudentService{


    List<Student> students=new ArrayList<>();


    @Override
    public List<Student> studentList() {
          return students;
    }

    @Override
    public Student studentById(String Id) {
        return students.stream()
                .filter(student -> student.getId().equals(Id))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException(
                        "Hey buddy! sorry, student with that Id isn't here"
                ));
    }

    @Override
    public Student saveStudent(Student student) {
        if(student.getId() == null || student.getEmail().isEmpty()){
            student.setId(UUID.randomUUID().toString());
        }
        student.setPassword(UUID.randomUUID().toString());
        students.add(student);
        return student;
    }

    @Override
    public String deleteStudent(String Id) {
        Student student=students
                .stream().filter(s-> s.getId().equals(Id))
                .findFirst()
                .get();

        students.remove(student);
        return "Student with Id "+Id + " has been deleted successfully!";
    }
}
