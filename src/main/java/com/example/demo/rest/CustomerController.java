package com.example.demo.rest;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/api")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }


    @GetMapping("/cusotmer/{id}")
    public Customer getCustomerById(@PathVariable("id") Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        Customer customer1 = customer.get();
        if (customer == null) {
            throw new CustomerNotFoundException("Customer id not Found - " + id);
        }
        return customer1;
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

}
