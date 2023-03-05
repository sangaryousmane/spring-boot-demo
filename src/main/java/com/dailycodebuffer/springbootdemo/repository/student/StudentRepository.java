package com.dailycodebuffer.springbootdemo.repository.student;

import com.dailycodebuffer.springbootdemo.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {

}

//<entity, idType>