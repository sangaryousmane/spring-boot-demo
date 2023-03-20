package com.dailycodebuffer.springbootdemo.service.jap.courses;

import com.dailycodebuffer.springbootdemo.entities.jpa.CourseEntity;
import com.dailycodebuffer.springbootdemo.entities.jpa.CourseMaterialEntity;
import com.dailycodebuffer.springbootdemo.entities.jpa.TeacherEntity;
import com.dailycodebuffer.springbootdemo.models.jpa.Course;
import com.dailycodebuffer.springbootdemo.repository.jpa.CourseEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseEntityRepository courseEntityRepository;

    public CourseServiceImpl(CourseEntityRepository courseEntityRepository) {
        this.courseEntityRepository = courseEntityRepository;
    }

    @Override
    public List<Course> allCourses() {
        List<CourseEntity> courses = courseEntityRepository.findAll();

        return courses.stream()
                .map(courseEntity -> {
                    Course course = new Course();
                    BeanUtils.copyProperties(courseEntity, course);
                    return course;
                }).collect(Collectors.toList());
    }

    @Override
    public Course getCourseById(Integer Id) {
        CourseEntity courseEntity = courseEntityRepository.findById(Id).get();
        Course course = new Course();
        BeanUtils.copyProperties(courseEntity, course);
        return course;
    }

    @Override
    public Course saveCourse(Course course, Integer Id) {

        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setTeacher(new TeacherEntity(Id));
        courseEntity.setCourseMaterial(new CourseMaterialEntity(Id));
        BeanUtils.copyProperties(course, courseEntity);
        courseEntityRepository.save(courseEntity);
        return course;

    }

    @Override
    public Course updateCourse(Course course) {
        CourseEntity courseEntity = new CourseEntity();
        BeanUtils.copyProperties(course, courseEntity);
        courseEntityRepository.save(courseEntity);
        return course;
    }

    @Override
    public String deleteCourse(Integer Id) {
        courseEntityRepository.deleteById(Id);
        return "Course with Id: " + Id + " has been deleted successfully!";
    }
}
