package com.dailycodebuffer.springbootdemo.service.employees;

import com.dailycodebuffer.springbootdemo.entities.EmployeeEntity;
import com.dailycodebuffer.springbootdemo.models.Admin;
import com.dailycodebuffer.springbootdemo.models.Employee;
import com.dailycodebuffer.springbootdemo.repository.employees.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV1ServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    public EmployeeV1ServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> getEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();

        return employees.stream()
                .map(employeeEntity -> {
                    Employee employee = new Employee();
                    BeanUtils.copyProperties(employeeEntity, employee);
                    return employee;
                }).collect(Collectors.toList());
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        if (employee.getEmployeeId() == null || employee.getEmailId().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Admin> adminList() {
        return null;
    }

    @Override
    public Admin addAdmin(Admin admin) {
        return null;
    }

    @Override
    public Employee getEmployeeById(String Id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(Id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String Id) {
        employeeRepository.deleteById(Id);
        return "Employee with ID of " + Id + " has been deleted successfully.";
    }

    @Override
    public Employee updateEmployee(String Id, Employee employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(Id).get();
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setDepartment(employee.getDepartment());
        employeeRepository.save(employeeEntity);
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }
}
