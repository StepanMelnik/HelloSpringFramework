package com.sme.spring.mvc.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.sme.spring.mvc.model.Customer;
import com.sme.spring.mvc.util.PojoGenericBuilder;

/**
 * Slow service implementation.
 */
@Service
public class SlowService implements ISlowService
{
    private static final int TIMEOUT = 10;

    @Override
    public List<Customer> findAll()
    {
        try
        {
            TimeUnit.SECONDS.sleep(TIMEOUT);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return Arrays.asList(
                new PojoGenericBuilder<>(Customer::new).with(Customer::setFirstname, "FirstNam1")
                        .with(Customer::setLastname, "LastNam1")
                        .build(),
                new PojoGenericBuilder<>(Customer::new).with(Customer::setFirstname, "FirstNam2")
                        .with(Customer::setLastname, "LastNam2")
                        .build(),
                new PojoGenericBuilder<>(Customer::new).with(Customer::setFirstname, "FirstNam3")
                        .with(Customer::setLastname, "LastNam3")
                        .build());
    }
}
