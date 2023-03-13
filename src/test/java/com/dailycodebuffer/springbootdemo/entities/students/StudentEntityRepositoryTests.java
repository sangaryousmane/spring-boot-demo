package com.dailycodebuffer.springbootdemo.entities.students;
import com.dailycodebuffer.springbootdemo.entities.jpa.CourseEntity;
import com.dailycodebuffer.springbootdemo.entities.jpa.Guardian;
import com.dailycodebuffer.springbootdemo.entities.jpa.StudentEntity;
import com.dailycodebuffer.springbootdemo.repository.jpa.CourseEntityRepository;
import com.dailycodebuffer.springbootdemo.repository.jpa.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentEntityRepositoryTests {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseEntityRepository courseEntityRepository;

    @Test
    void testSaveStudent() {
        Guardian guardianFanta = new Guardian(
                "Saah",
                "saah@gmail.com",
                "+23177891882");
        StudentEntity entity = StudentEntity.builder()
                .name("Peter")
                .password("peter27882!")
                .email("peter@yahoo.com")
                .guardian(guardianFanta)
                .build();
        StudentEntity saved = studentRepository.save(entity);
        assertThat(saved.getId()).isGreaterThan(0);
    }

    @Test
    void testGetAllStudent() {
        List<StudentEntity> allStudents = studentRepository.findAll();
        allStudents.forEach(System.out::println);
        assertThat(allStudents.size()).isGreaterThan(0);
    }

    @Test
    void testStudentByName() {
        List<StudentEntity> studentByName =
                studentRepository.findByName("Ousmane");
        System.out.println(studentByName);
        assertThat(studentByName.isEmpty()).isFalse();
    }

    @Test
    void testAllStudentByEmail() {
        List<StudentEntity> byEmailContainingIgnoreCase =
                studentRepository.findByEmailContaining("@yahoo");

        byEmailContainingIgnoreCase.forEach(System.out::println);
        assertThat(byEmailContainingIgnoreCase.isEmpty()).isFalse();
    }

    @Test
    void testFindStudentByPassword() {
        List<StudentEntity> studentByPassword =
                studentRepository.findStudentByPassword("ousmane2023!");
        System.out.println(studentByPassword);
        assertThat(studentByPassword.size()).isPositive();
    }

    @Test
    void testStudentByEmailAndName() {
        List<StudentEntity> byEmailAndName =
                studentRepository.findByEmailAndName("sangary76@yahoo.com", "Ousmane");
        System.out.println(byEmailAndName);
//        assertThat(byEmailAndName.size()).isPositive();
    }

    @Test
    void testById() {
        StudentEntity studentById = studentRepository.studentById(2L);
        System.out.println(studentById);
        assertThat(studentById.getId()).isPositive();
    }

    @Test
    void testUpdateName() {
        studentRepository.updateStudentName("Kadiatu", 1L);
    }

    @Test
    void testAddCourse(){

        StudentEntity entity=StudentEntity.builder()
                        .name("Zainab")
                        .email("zainab@gmail.com")
                        .password("zainab!!")
                        .courses(List.of(new CourseEntity(5L)))
                        .build();
        studentRepository.save(entity);
    }

    @Test
    void firstPageWithOneRecord(){
        Pageable pageOneRecord= PageRequest.of(0, 1);
        List<CourseEntity> courses = courseEntityRepository.findAll(pageOneRecord).getContent();

        System.out.println(courses);
    }

    @Test
    void testPageNumber(){
        Pageable pageOneRecord= PageRequest.of(0, 1);
        long totalElements = courseEntityRepository.findAll(pageOneRecord).getTotalElements();
        int totalPages = courseEntityRepository.findAll(pageOneRecord).getTotalPages();
        System.out.println("Total Elements: " + totalElements);
        System.out.println("Total Pages: " + totalPages);

    }
}
