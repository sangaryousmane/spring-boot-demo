package com.dailycodebuffer.springbootdemo.controller.customer;

import com.dailycodebuffer.springbootdemo.models.Customer;
import com.dailycodebuffer.springbootdemo.service.customers.CustomerV1ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customers")
public class CustomerV1Controller {

    @Qualifier(value = "customerV1ServiceImpl")
    private final CustomerV1ServiceImpl customerV1Service;

    public CustomerV1Controller(CustomerV1ServiceImpl customerV1Service) {
        this.customerV1Service = customerV1Service;
    }

    // Get all customers
    @GetMapping("/")
    public List<Customer> getAllCustomers(){
        return customerV1Service.customerList();
    }

    // get Customer By Id
    @GetMapping("/{Id}")
    public Customer getCustomerById(@PathVariable("Id") String Id){
        return customerV1Service.customerById(Id);
    }

    // save customer
    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerV1Service.saveCustomer(customer);
    }

    // Delete customer
    @DeleteMapping("/{Id}")
    public String deleteCustomer(@PathVariable(name = "Id") String Id){
        return customerV1Service.deleteCustomerById(Id);
    }

    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer,
                                   @RequestParam(name = "customer_id") String Id){
        return customerV1Service.updateCustomer(Id, customer);
    }
}
