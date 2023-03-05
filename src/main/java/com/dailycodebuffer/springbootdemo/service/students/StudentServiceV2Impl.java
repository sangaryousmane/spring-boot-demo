package com.dailycodebuffer.springbootdemo.service.students;

import com.dailycodebuffer.springbootdemo.entities.StudentEntity;
import com.dailycodebuffer.springbootdemo.models.Student;
import com.dailycodebuffer.springbootdemo.repository.student.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentServiceV2Impl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceV2Impl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> studentList() {
        List<StudentEntity> studentEntities =
                studentRepository.findAll();


        return studentEntities
                .stream()
                .map(entity -> {
                    Student student = new Student();
                    BeanUtils.copyProperties(entity, student);
                    return student;
                }).collect(Collectors.toList());
    }


    @Override
    public Student studentById(String Id) {
        StudentEntity studentEntity = studentRepository.findById(Id).get();
        Student student = new Student();
        BeanUtils.copyProperties(studentEntity, student);
        return student;
    }

    @Override
    public Student saveStudent(Student student) {

        if (student.getId() == null || student.getEmail().isEmpty()) {
            student.setId(UUID.randomUUID().toString());
        }
        student.setPassword(UUID.randomUUID().toString());
        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(student, studentEntity);
        studentRepository.save(studentEntity);
        return student;
    }

    @Override
    public String deleteStudent(String Id) {
        studentRepository.deleteById(Id);
        return "Student with Id of " + Id + " has been deleted successfully!";
    }


    @Override
    public Student updateStudent(Student student, String id) {
        StudentEntity entity =
                studentRepository.findById(id).get();

        entity.setName(student.getName());
        entity.setEmail(student.getEmail());
        entity.setPassword(student.getPassword());
        studentRepository.save(entity);

        // Convert the entity class to student
        BeanUtils.copyProperties(entity, student);
        return student;
    }
}
