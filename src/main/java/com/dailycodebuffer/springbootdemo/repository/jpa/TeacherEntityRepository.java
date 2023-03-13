package com.dailycodebuffer.springbootdemo.repository.jpa;

import com.dailycodebuffer.springbootdemo.entities.jpa.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherEntityRepository
        extends JpaRepository<TeacherEntity, Long> {
}