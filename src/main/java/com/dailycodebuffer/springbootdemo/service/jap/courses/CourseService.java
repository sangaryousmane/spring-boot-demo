package com.dailycodebuffer.springbootdemo.service.jap.courses;

import com.dailycodebuffer.springbootdemo.models.jpa.Course;

import java.util.List;

public interface CourseService {


    List<Course> allCourses();
    Course getCourseById(Integer Id);
    Course saveCourse(Course course, Integer Id);
    Course updateCourse(Course course);
    String deleteCourse(Integer Id);

}
