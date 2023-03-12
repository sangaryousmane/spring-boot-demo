package com.dailycodebuffer.springbootdemo.entities.employees;


import com.dailycodebuffer.springbootdemo.entities.EmployeeEntity;
import com.dailycodebuffer.springbootdemo.models.Employee;
import com.dailycodebuffer.springbootdemo.repository.employees.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Commit
public class EmployeeRepositoryTests {


    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    void testFindEmployeeByFirstName() {
        EmployeeEntity employee = employeeRepository.findEmployeeEntitiesByFirstName("Cephus");
        System.out.println(employee);
        assertThat(employee.getFirstName()).isNotEmpty();
    }

    @Test
    void testFindEmployeeByDepartment() {
        EmployeeEntity itDepartment = employeeRepository.findByEmployeeDepartment("IT");
        System.out.println(itDepartment);
        assertThat(itDepartment.getDepartment()).isEqualTo("IT");
    }

    @Test
    void testFindByFirstNameAndDepartment() {
        EmployeeEntity employee =
                employeeRepository.findByFirstNameAndDepartment("Saah", "Enterpreneur");

        System.out.println(employee);
        assertThat(employee.getEmployeeId()).isNotEmpty();
    }
}
