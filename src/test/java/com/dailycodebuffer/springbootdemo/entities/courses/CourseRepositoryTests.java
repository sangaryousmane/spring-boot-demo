package com.dailycodebuffer.springbootdemo.entities.courses;


import com.dailycodebuffer.springbootdemo.entities.jpa.CourseEntity;
import com.dailycodebuffer.springbootdemo.entities.jpa.CourseMaterialEntity;
import com.dailycodebuffer.springbootdemo.entities.jpa.StudentEntity;
import com.dailycodebuffer.springbootdemo.entities.jpa.TeacherEntity;
import com.dailycodebuffer.springbootdemo.repository.jpa.CourseEntityRepository;
import com.dailycodebuffer.springbootdemo.repository.jpa.CourseMaterialEntityRepository;
import com.dailycodebuffer.springbootdemo.repository.jpa.TeacherEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseRepositoryTests {

    @Autowired
    private CourseMaterialEntityRepository courseMaterialRepository;

    @Autowired
    private TeacherEntityRepository teacherEntityRepository;

    @Autowired
    private CourseEntityRepository courseEntityRepository;

    @Test
    void testSaveCourseMaterial(){

        TeacherEntity teacher=TeacherEntity.builder()
                .firstName("Bing")
                .lastName("Qing")
                .build();

        teacherEntityRepository.save(teacher);
        CourseEntity course=CourseEntity.builder()
                .title("DSA")
                .credit(7)
                .teacher(teacher)
                .build();

        CourseMaterialEntity material=CourseMaterialEntity.builder()
                .url("www.dsa.com")
                .course(course)
                .build();
        courseMaterialRepository.save(material);
    }

    @Test
    void testSaveCoursesAndTeacher(){
        TeacherEntity teacher=TeacherEntity.builder()
                .firstName("Anderson")
                .lastName("Peter")
                .build();

        CourseEntity courseEntity=CourseEntity.builder()
                .credit(5)
                .title("Data Science")
                .teacher(teacher)
                .build();
        courseEntityRepository.save(courseEntity);
    }
}
