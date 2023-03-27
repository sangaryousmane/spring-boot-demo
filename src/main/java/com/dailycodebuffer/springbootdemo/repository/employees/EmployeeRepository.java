package com.dailycodebuffer.springbootdemo.repository.employees;

import com.dailycodebuffer.springbootdemo.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {




    EmployeeEntity findEmployeeEntitiesByFirstName(String firstName);

    @Query("SELECT e FROM EmployeeEntity e WHERE e.department=:department")
    EmployeeEntity findByEmployeeDepartment(@Param("department") String department);

    @Query("SELECT e FROM EmployeeEntity e WHERE e.firstName=?1 AND e.department=?2")
    EmployeeEntity findByFirstNameAndDepartment(String firstName, String department);

    @Query("SELECT e FROM EmployeeEntity e WHERE e.firstName in :employees")
    List<EmployeeEntity> findAllEmployeeEntitiesByFirstName(
            @Param("employees") Collection<String> employee);

    @Query("UPDATE EmployeeEntity e SET e.emailId=:emailId WHERE e.firstName=:firstName")
    @Modifying
    void updateByFirstName(@Param("firstName") String firstName, @Param("emailId") String emailId);
}
