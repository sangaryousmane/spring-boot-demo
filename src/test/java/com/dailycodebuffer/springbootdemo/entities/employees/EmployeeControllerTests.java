//package com.dailycodebuffer.springbootdemo.entities.employees;
//
//import com.dailycodebuffer.springbootdemo.controller.employee.EmployeeV1Controller;
//import com.dailycodebuffer.springbootdemo.entities.EmployeeEntity;
//import com.dailycodebuffer.springbootdemo.models.Employee;
//import com.dailycodebuffer.springbootdemo.repository.employees.EmployeeRepository;
//import com.dailycodebuffer.springbootdemo.service.employees.EmployeeV1ServiceImpl;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.List;
//
//import static java.lang.reflect.Array.get;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@WebMvcTest(EmployeeV1Controller.class)
//public class EmployeeControllerTests {
//
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private EmployeeV1ServiceImpl employeeV2ServiceImpl;
//
//
//    @Test
//    void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception {
//        List<Employee> employees = new ArrayList<>();
//
//        given(employeeV2ServiceImpl.getEmployees()).willReturn(employees);
//        mockMvc.perform(get("/v1/employees/")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//}