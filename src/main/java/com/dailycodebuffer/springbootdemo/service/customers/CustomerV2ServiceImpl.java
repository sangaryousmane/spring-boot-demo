package com.dailycodebuffer.springbootdemo.service.customers;


import com.dailycodebuffer.springbootdemo.entities.CustomerEntity;
import com.dailycodebuffer.springbootdemo.models.Customer;
import com.dailycodebuffer.springbootdemo.repository.customers.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import static com.dailycodebuffer.springbootdemo.service.customers.CustomerV1ServiceImpl.getCustomer;

@Service
public class CustomerV2ServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerV2ServiceImpl(CustomerRepository customerRepository) {
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
        CustomerEntity customerEntity = customerRepository.findById(Id).get();
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerEntity, customer);
        return customer;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return getCustomer(customer, customerRepository);
    }

    @Override
    public String deleteCustomerById(String Id) {
        customerRepository.deleteById(Id);
        return "The customer with ID " + Id + " has been deleted successfully!";
    }

    @Override
    public Customer updateCustomer(String Id, Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(customer.getFirstName());
        customerEntity.setLastName(customer.getLastName());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setAddress(customer.getAddress());
        customerRepository.save(customerEntity);
        BeanUtils.copyProperties(customerEntity, customer);
        return customer;
    }
}
