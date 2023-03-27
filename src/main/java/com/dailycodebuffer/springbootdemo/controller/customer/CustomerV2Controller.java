package com.dailycodebuffer.springbootdemo.controller.customer;


import com.dailycodebuffer.springbootdemo.models.Customer;
import com.dailycodebuffer.springbootdemo.service.customers.CustomerV2ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/customers")
public class CustomerV2Controller {


    @Qualifier(value = "customerV2ServiceImpl")
    private final CustomerV2ServiceImpl customerV2Service;

    public CustomerV2Controller(CustomerV2ServiceImpl customerV2Service) {
        this.customerV2Service = customerV2Service;
    }

    // Get all customers
    @GetMapping("/")
    public List<Customer> customerList(){
        return customerV2Service.customerList();
    }


    // Get customer by Id
    @GetMapping("/{Id}")
    public Customer customerById(@PathVariable(name = "Id") String Id){
        return customerV2Service.customerById(Id);
    }

    // Save Customer
    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerV2Service.saveCustomer(customer);
    }

    // delete customer
    @DeleteMapping("/delete/{Id}")
    public String deleteCustomerById(@PathVariable(name = "Id") String Id){
        return customerV2Service.deleteCustomerById(Id);
    }

    @PutMapping("/update")
    public Customer updateCustomerById(@RequestBody Customer customer,
                                       @RequestParam(required = false, name = "Id") String Id){
        return customerV2Service.updateCustomer(Id, customer);
    }
}
