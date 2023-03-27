package com.dailycodebuffer.springbootdemo.controller.course;


import com.dailycodebuffer.springbootdemo.models.jpa.Course;
import com.dailycodebuffer.springbootdemo.service.jap.courses.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/courses")
public class CourseV1Controller {


    @Qualifier(value = "courseServiceImpl")
    private final CourseServiceImpl courseServiceImpl;


    public CourseV1Controller(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }

    @GetMapping("/")
    public List<Course> allCourses() {
        return courseServiceImpl.allCourses();
    }

    @GetMapping("/{Id}")
    public Course findCourseById(@PathVariable("Id") Integer Id) {
        return courseServiceImpl.getCourseById(Id);
    }

    @PostMapping("/saveCourse/{Id}")
    public Course saveCourse(@RequestBody Course course,
                             @PathVariable("Id") Integer Id) {
        return courseServiceImpl.saveCourse(course, Id);
    }
}
