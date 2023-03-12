package com.dailycodebuffer.springbootdemo.repository.employees;

import com.dailycodebuffer.springbootdemo.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {




    EmployeeEntity findEmployeeEntitiesByFirstName(String firstName);

    @Query("SELECT e FROM EmployeeEntity e WHERE e.department=:department")
    EmployeeEntity findByEmployeeDepartment(@Param("department") String department);

    @Query("SELECT e FROM EmployeeEntity e WHERE e.firstName=?1 AND e.department=?2")
    EmployeeEntity findByFirstNameAndDepartment(String firstName, String department);
}
