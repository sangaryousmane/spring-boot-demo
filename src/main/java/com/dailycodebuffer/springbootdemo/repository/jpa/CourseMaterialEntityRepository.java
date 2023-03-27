package com.dailycodebuffer.springbootdemo.repository.jpa;

import com.dailycodebuffer.springbootdemo.entities.jpa.CourseMaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialEntityRepository extends JpaRepository<CourseMaterialEntity, Integer> {
}