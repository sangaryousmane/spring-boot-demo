package com.dailycodebuffer.springbootdemo.entities.employees;


import com.dailycodebuffer.springbootdemo.controller.employee.EmployeeV1Controller;
import com.dailycodebuffer.springbootdemo.exceptions.employees.EmployeeNotFoundException;
import com.dailycodebuffer.springbootdemo.models.Employee;
import com.dailycodebuffer.springbootdemo.repository.employees.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTests {


    private MockMvc mockMvc;


    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeV1Controller employeeV1Controller;


    private JacksonTester<Employee> jacksonTester;

    @BeforeEach
    public void setUp() {

        JacksonTester.initFields(this, new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(employeeV1Controller)
                .setControllerAdvice(new EmployeeNotFoundException())
                .addFilters(new AddDefaultCharsetFilter())
                .build();
//    }


//    @Test
//    void testByIdWhenExist() throws Exception {
//        EmployeeEntity entity = employeeRepository.findByEmployeeDepartment("IT");
//        Employee employee = new Employee();
//        BeanUtils.copyProperties(entity, employee);
//        given(entity)
//                .willReturn(entity);
//
//        MockHttpServletResponse response = mockMvc.perform(
//                        get("/employees/IT").accept(MediaType.APPLICATION_JSON))
//                .andReturn().getResponse();
//
//
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString()).isEqualTo(
//                jacksonTester.write(employee).getJson()
//        );

    }
}
