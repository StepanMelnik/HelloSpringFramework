package com.sme.spring.mvc.persistence;

import org.springframework.data.repository.Repository;

import com.sme.spring.mvc.model.Customer;

/**
 * Customer repository.
 */
public interface CustomerRepository extends Repository<Customer, Integer>
{
    /**
     * Save customer with all depend on properties.
     * 
     * @param customer The customer instance;
     * @return Returns customer instance.
     */
    Customer save(Customer customer);
}
