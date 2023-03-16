package com.company.repository;

import com.company.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testSaveCustomer() {
        Customer customer = new Customer(null, "John", "Doe", "john.doe@example.com", "Acme Corp", "555-1234", "123 Main St", "", "Anytown", "CA", "12345", "USA");
        customerRepository.save(customer);
        assertThat(customer.getId()).isNotNull();
    }

    @Test
    void testFindAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        assertThat(customers).isEmpty();

        customerRepository.save(new Customer(null, "John", "Doe", "john.doe@example.com", "Acme Corp", "555-1234", "123 Main St", "", "Anytown", "CA", "12345", "USA"));

        customers = customerRepository.findAll();
        assertThat(customers).hasSize(1);
    }

}
