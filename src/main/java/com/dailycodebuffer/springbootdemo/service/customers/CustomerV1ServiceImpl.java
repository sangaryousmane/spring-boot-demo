package com.dailycodebuffer.springbootdemo.service.customers;

import com.dailycodebuffer.springbootdemo.entities.CustomerEntity;
import com.dailycodebuffer.springbootdemo.models.Customer;
import com.dailycodebuffer.springbootdemo.repository.customers.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.dailycodebuffer.springbootdemo.service.customers.CustomerV2ServiceImpl.mapCustomers;

@Service
public class CustomerV1ServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;

    public CustomerV1ServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> customerList() {
        List<CustomerEntity> customerEntities =
                customerRepository.findAll();

        return customerEntities.stream()
                .map(customerEntity -> {
                    Customer customer = new Customer();
                    BeanUtils.copyProperties(customerEntity, customer);
                    return customer;
                }).collect(Collectors.toList());
    }

    @Override
    public Customer customerById(String Id) {
        CustomerEntity findById = customerRepository.findById(Id).get();
        Customer customer = new Customer();
        BeanUtils.copyProperties(findById, customer);
        return customer;
    }

    @Override
    public Customer saveCustomer(Customer customer) {

        return getCustomer(customer, customerRepository);
    }

    static Customer getCustomer(Customer customer, CustomerRepository customerRepository) {
        if (customer.getId() == null || customer.getEmail().isEmpty()) {
            customer.setId(UUID.randomUUID().toString());
        }
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customer, customerEntity);
        customerRepository.save(customerEntity);
        return customer;
    }

    @Override
    public String deleteCustomerById(String Id) {
        customerRepository.deleteById(Id);
        return "The customer with Id of " + Id + " has been deleted successfully!";
    }

    @Override
    public Customer updateCustomer(String Id, Customer customer) {
        CustomerEntity customerEntity = customerRepository.findById(Id).get();

        mapCustomers(customerEntity, customer);
        customerRepository.save(customerEntity);
        BeanUtils.copyProperties(customerEntity, customer);
        return customer;
    }
}
