package com.sme.spring.mvc.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sme.spring.mvc.model.Customer;
import com.sme.spring.mvc.model.Order;
import com.sme.spring.mvc.model.OrderItem;
import com.sme.spring.mvc.model.Shopcart;
import com.sme.spring.mvc.persistence.CustomerRepository;
import com.sme.spring.mvc.util.PojoGenericBuilder;

/**
 * Order service implementation.
 */
@Service
public class OrderService implements IOrderService
{
    private final CustomerRepository customerRepository;

    public OrderService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer, Shopcart shopcart)
    {
        customer.getAddresses().stream().forEach(a -> a.setCustomer(customer));

        List<OrderItem> orderItems = shopcart.getShopcartItems()
                .stream()
                .map(s -> new PojoGenericBuilder<>(OrderItem::new)
                        .with(OrderItem::setQuantity, s.getQuantity())
                        .with(OrderItem::setArticle, s.getArticle())
                        .build())
                .collect(Collectors.toList());

        Order order = new PojoGenericBuilder<>(Order::new)
                .with(Order::setOrderDate, LocalDate.now())
                .with(Order::setCustomer, customer)
                .with(Order::setOrderItems, orderItems)
                .build();

        orderItems.stream().forEach(oi -> oi.setOrder(order));

        customer.setOrders(Arrays.asList(order));

        return customerRepository.save(customer);
    }
}
