package com.dailycodebuffer.springbootdemo.repository.customers;
import com.dailycodebuffer.springbootdemo.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}
