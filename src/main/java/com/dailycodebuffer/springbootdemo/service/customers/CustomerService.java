package com.dailycodebuffer.springbootdemo.service.customers;

import com.dailycodebuffer.springbootdemo.models.Customer;

import java.util.List;

public interface CustomerService {


    List<Customer> customerList();
    Customer customerById(String Id);
    Customer saveCustomer(Customer customer);
    String deleteCustomerById(String Id);
    Customer updateCustomer(String Id, Customer customer);

}
