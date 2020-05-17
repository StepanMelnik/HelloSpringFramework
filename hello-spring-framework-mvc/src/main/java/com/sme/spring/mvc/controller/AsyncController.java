package com.sme.spring.mvc.controller;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sme.spring.mvc.service.ISlowService;

/**
 * Controller with asynchronous processing supported by Servlet 3.0.
 */
@Controller
@RequestMapping("/async")
public class AsyncController
{
    private final ISlowService slowService;

    public AsyncController(ISlowService slowService)
    {
        this.slowService = slowService;
    }

    /**
     * Get all customers in asynchronous mode.
     * 
     * @param model The UI model;
     * @return Returns callable view.
     */
    @GetMapping("/customers")
    public Callable<String> form(ModelMap model)
    {
        return () ->
        {
            model.put("customers", slowService.findAll());
            return "async/customer";
        };
    }
}
