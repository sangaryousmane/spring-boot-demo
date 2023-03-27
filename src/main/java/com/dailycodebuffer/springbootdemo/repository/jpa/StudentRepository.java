package com.dailycodebuffer.springbootdemo.repository.jpa;

import com.dailycodebuffer.springbootdemo.entities.jpa.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {


    List<StudentEntity> findByName(String firstName);

    // TODO: Repository Methods
    List<StudentEntity> findByEmailContaining(String email);

    // TODO: This is JPQL
    @Query("SELECT s FROM StudentEntity s WHERE s.password=:password")
    List<StudentEntity> findStudentByPassword(@Param("password") String password);

    // TODO: This is a native query
    @Query(
            value = "SELECT *FROM students s WHERE s.student_email_address=?1 AND s.name=?2",
    nativeQuery = true)
    List<StudentEntity> findByEmailAndName( String email, String name);

    // TODO: this is a named param query
    @Query("SELECT s FROM StudentEntity s WHERE s.Id=:Id")
    StudentEntity studentById(@Param("Id") Long Id);

    // TODO: the modifying annotation is use for non-returnable methods like UPDATE and DELETE
    @Query("UPDATE StudentEntity s SET s.name=:name WHERE s.Id=:Id")
    @Modifying
    @Transactional
    void updateStudentName(@Param("name") String name,
                           @Param("Id") Long Id);
}

//<entity, idType>