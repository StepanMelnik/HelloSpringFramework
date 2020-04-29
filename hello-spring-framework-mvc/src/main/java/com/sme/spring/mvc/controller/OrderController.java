package com.sme.spring.mvc.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sme.spring.mvc.model.Address;
import com.sme.spring.mvc.model.AddressType;
import com.sme.spring.mvc.model.Customer;
import com.sme.spring.mvc.model.Shopcart;
import com.sme.spring.mvc.service.IOrderService;
import com.sme.spring.mvc.util.PojoGenericBuilder;

/**
 * Order controller.
 */
@Controller
@SessionAttributes("shopcart")
public class OrderController
{
    private final IOrderService orderService;

    public OrderController(IOrderService orderService)
    {
        this.orderService = orderService;
    }

    /**
     * New Order form.
     * 
     * @param model The model of view;
     * @return Returns view.
     */
    @GetMapping("/orders/new")
    public String newOrder(ModelMap model)
    {
        List<Address> addresses = Arrays.asList(
                new PojoGenericBuilder<>(Address::new)
                        .with(Address::setAddressType, AddressType.INVOICE)
                        .build(),
                new PojoGenericBuilder<>(Address::new)
                        .with(Address::setAddressType, AddressType.DELIVERY)
                        .build());
        Customer customer = new PojoGenericBuilder<>(Customer::new)
                .with(Customer::setAddresses, addresses)
                .build();

        model.put("customer", customer);
        return "order/edit";
    }

    /**
     * Save order.
     * 
     * @param customer The customer bean in web form;
     * @param shopcart The shopcart from session;
     * @param bindingResult The spring binding result;
     * @param model The model of view;
     * @param session The servlet session;
     * @return Returns view.
     */
    @PostMapping("/orders/add")
    public String addOrder(@Valid Customer customer, @ModelAttribute("shopcart") Shopcart shopcart, BindingResult bindingResult, ModelMap model, HttpSession session)
    {
        if (bindingResult.hasErrors())
        {
            return "order/edit";
        }

        Customer savedCustomer = orderService.save(customer, shopcart);
        model.put("customer", savedCustomer);

        model.remove("shopcart");
        session.removeAttribute("shopcart");

        return "orders";
    }
}
