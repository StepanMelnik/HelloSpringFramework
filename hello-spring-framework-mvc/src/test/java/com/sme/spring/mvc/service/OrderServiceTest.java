package com.sme.spring.mvc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.sme.spring.mvc.model.Customer;
import com.sme.spring.mvc.model.Shopcart;
import com.sme.spring.mvc.persistence.CustomerRepository;

/**
 * Unit tests of {@link OrderService}.
 */
public class OrderServiceTest extends Assertions
{
    private IOrderService orderService;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        orderService = new OrderService(customerRepository);
    }

    @Test
    void testSaveCustomer() throws Exception
    {
        Customer customer = new Customer();
        orderService.save(customer, new Shopcart());
        Mockito.verify(customerRepository).save(customer);
    }
}
