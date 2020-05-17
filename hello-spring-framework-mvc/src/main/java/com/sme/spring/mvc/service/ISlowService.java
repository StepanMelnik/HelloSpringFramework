package com.sme.spring.mvc.service;

import java.util.List;

import com.sme.spring.mvc.model.Customer;

/**
 * Simulate slow service to run operations in asunc mode.
 */
public interface ISlowService
{
    /**
     * Fetch customers with delay.
     * 
     * @return
     */
    List<Customer> findAll();
}
