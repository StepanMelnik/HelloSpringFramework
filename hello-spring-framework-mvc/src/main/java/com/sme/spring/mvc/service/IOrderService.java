package com.sme.spring.mvc.service;

import com.sme.spring.mvc.model.Customer;
import com.sme.spring.mvc.model.Shopcart;

/**
 * Order service.
 */
public interface IOrderService
{
    /**
     * Save customer with depend on order.
     * 
     * @param customer The customer instance;
     * @param shopcart The created shopcart instance to create order;
     * @return Returns saved customer with order.
     */
    Customer save(Customer customer, Shopcart shopcart);
}
