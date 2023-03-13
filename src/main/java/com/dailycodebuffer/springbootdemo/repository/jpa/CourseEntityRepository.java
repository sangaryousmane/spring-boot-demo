package com.dailycodebuffer.springbootdemo.repository.jpa;

import com.dailycodebuffer.springbootdemo.entities.jpa.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseEntityRepository extends JpaRepository<CourseEntity, Long> {
}