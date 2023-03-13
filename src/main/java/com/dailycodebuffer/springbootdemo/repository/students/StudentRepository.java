package com.dailycodebuffer.springbootdemo.repository.students;

import com.dailycodebuffer.springbootdemo.entities.jpa.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {

}

//<entity, idType>