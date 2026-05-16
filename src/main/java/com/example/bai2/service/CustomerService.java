package com.example.bai2.service;


import com.example.bai2.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CustomerService {
    private final List<Customer> customers = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public Customer createCustomer(Customer customer) {
        customer.setId(nextId.getAndIncrement());
        customers.add(customer);
        return customer;
    }

    public Optional<Customer> updateCustomer(Long id, Customer customer) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(c -> {
                    c.setName(customer.getName());
                    c.setEmail(customer.getEmail());
                    return c;
                });
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst();
    }
}
