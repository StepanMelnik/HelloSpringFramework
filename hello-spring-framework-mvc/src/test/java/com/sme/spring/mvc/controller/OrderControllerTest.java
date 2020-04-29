package com.sme.spring.mvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Unit tests of {@link OrderController}.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testOrdersNew() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/orders/new"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("customer"))
                .andExpect(MockMvcResultMatchers.view().name("order/edit"));
    }
}
